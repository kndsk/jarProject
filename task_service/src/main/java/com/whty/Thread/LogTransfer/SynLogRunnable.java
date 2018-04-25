package com.whty.Thread.LogTransfer;

/**
 * 功能：多线程执行：读取日志文件，解析json到实体类，保存数据库，移动日志文件
 * 备注： 1.以上过程为一个事物，发生异常统一回滚，并记录异常记录表。
 * 		 2.解析json异常为第三方数据源问题，该类日志文件处理失败后移动到错误分类文件夹，并记录异常记录表，等待手动处理
 *       3.保存数据库及以后的操作，如果发生异常为本身程序运行产生的异常。日志文件不移动，等待下次自动任务重新处理。
 *       4.io异常移动到错误分类文件夹，并记录异常记录表，等待手动处理
 * @author jlq
 * 2015-11-19
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;

import javax.sql.DataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.whty.exception.BusinessException;
import com.whty.main.StratListerner;
import com.whty.model.LogDetail;
import com.whty.service.impl.LogServiceImpl;
import com.whty.service.impl.LogServiceImpl.SysCode;
import com.whty.util.FileUtil;
import com.whty.util.JacksonUtils;

public class SynLogRunnable implements Runnable {
	// @Resource

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private BlockingQueue<File> queueFile;

	public SynLogRunnable(BlockingQueue<File> queueFile) {
		this.queueFile = queueFile;
	}

	@Override
	public void run() {
		while (this.queueFile.size() > 0) {
			File file = null;
			try {

				file = this.queueFile.poll();

				if (file == null) {
					return;
				}
				String[] logDetails = FileToSqlArray(file);
				logger.info("开始入库操作");
				if (logDetails != null) {
					saveLogDetailByJdbc(logDetails, file);
				} else {
					moveSuccessFile(file);
				}
				Thread t = Thread.currentThread();
				String name = t.getName();

				saveErrorLog(file, "10000", "处理成功");
				logger.info("处理成功！文件：" + file.getName() + "已处理完毕");
			} catch (IOException e) {
				moveFailtureFile(file);
				e.printStackTrace();
				String msg = "处理失败，读写文件异常。文件名：" + file.getName() + "，错误原因："
						+ e.getMessage();
				logger.error(msg);
				saveErrorLog(file, "11002", msg);
			} // catch (InterruptedException e) {
				// 休眠异常不做处理
			// }
			catch (BusinessException e) {
				// 数据库异常
				moveFailtureFile(file);
				e.printStackTrace();
				String msg = "处理失败，数据库插入异常。文件名：" + file.getName() + ",错误原因："
						+ e.getMessage();
				saveErrorLog(file, "11003", msg);
				logger.error(msg);
			}
		}
	}

	private StringBuffer readFile(File file) throws JsonParseException,
			JsonMappingException, IOException {

		StringBuffer fileContent = new StringBuffer();
		InputStreamReader read = new InputStreamReader(
				new FileInputStream(file), "utf-8");
		BufferedReader reader = new BufferedReader(read);
		String line;
		while ((line = reader.readLine()) != null) {
			fileContent.append(line);
		}
		reader.close();

		return fileContent;
	}

	private List<LogDetail> FileToEntity(File file) throws JsonParseException,
			JsonMappingException, IOException {
		List<LogDetail> logDetails = null;
		StringBuffer fileContent = readFile(file);
		if (fileContent != null || fileContent != null) {
			logDetails = jsonToLogDetails(fileContent);
		}
		return logDetails;
	}

	private StringBuffer FileToSql(File file) throws JsonParseException,
			JsonMappingException, IOException {
		StringBuffer logDetails = null;
		StringBuffer fileContent = readFile(file);
		if (fileContent != null || fileContent != null) {
			String systemCode = "";
			for (SysCode sCode : SysCode.values()) {
				if (file.getName().split("_")[0].toUpperCase().equals(
						sCode.toString())) {
					systemCode = sCode.getValue();
					break;
				}
			}

			logDetails = jsonToLogSql(fileContent, systemCode);
		}
		return logDetails;
	}

	private String[] FileToSqlArray(File file) throws JsonParseException,
			JsonMappingException, IOException {
		String[] logDetails = null;
		StringBuffer fileContent = readFile(file);
		if (fileContent != null && fileContent.length() > 0) {
			String systemCode = "";
			for (SysCode sCode : SysCode.values()) {
				if (file.getName().split("_")[0].toUpperCase().equals(
						sCode.toString())) {
					systemCode = sCode.getValue();
					break;
				}
			}
			logDetails = jsonToLogSqlArray(fileContent, systemCode);
		}
		return logDetails;
	}

	private List<LogDetail> jsonToLogDetails(StringBuffer jsonStr)
			throws JsonParseException, JsonMappingException, IOException {
		List<LogDetail> logDetailList = new ArrayList<LogDetail>();

		String[] jsonStrs = jsonStr.toString().split("}");

		for (int i = 0; i < jsonStrs.length; i++) {
			LogDetail logDetail = JacksonUtils.fromJsonstrToObj(jsonStrs[i]
					+ "}", LogDetail.class);
			logDetailList.add(logDetail);
		}

		return logDetailList;
	}

	private StringBuffer jsonToLogSql(StringBuffer jsonStr, String systemCode)
			throws JsonParseException, JsonMappingException, IOException {
		List<LogDetail> logDetailList = new ArrayList<LogDetail>();
		StringBuffer resultSqlStr = new StringBuffer();
		String[] jsonStrs = jsonStr.toString().split("}");

		for (int i = 0; i < jsonStrs.length; i++) {
			HashMap hashmp = JacksonUtils.fromJsonstrToObj(jsonStrs[i] + "}",
					HashMap.class);
			resultSqlStr.append(mapToSql(hashmp, systemCode));
		}

		return resultSqlStr;
	}

	private String[] jsonToLogSqlArray(StringBuffer jsonStr, String systemCode)
			throws JsonParseException, JsonMappingException, IOException {
		List<LogDetail> logDetailList = new ArrayList<LogDetail>();

		StringBuffer resultSqlStr = new StringBuffer();
		String[] jsonStrs = jsonStr.toString().split("}");
		String[] strs = new String[jsonStrs.length];
		for (int i = 0; i < jsonStrs.length; i++) {
			HashMap hashmp = JacksonUtils.fromJsonstrToObj(jsonStrs[i] + "}",
					HashMap.class);
			strs[i] = mapToSql(hashmp, systemCode).toString();
		}

		return strs;
	}

	private StringBuffer mapToSql(Map map, String systemCode) {
		StringBuffer headBuf = new StringBuffer();
		StringBuffer strBuf = new StringBuffer();
		StringBuffer valueBuf = new StringBuffer();
		/* +append */
		//此处加过滤，根据systemcode 区分表名
		String tableName = "";
		if(systemCode.equals(SysCode.LOGINPORTAL.getValue())||systemCode.equals(SysCode.SYSLOGIN.getValue())){
			tableName = LogServiceImpl.logintableName;
		}else{
			tableName = LogServiceImpl.tableName;
		}
		headBuf.append("insert into ").append(tableName);
		
		strBuf.append("(systemCode,");
		valueBuf.append("('" + systemCode + "',");
		Iterator iter = map.entrySet().iterator();

		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();

			

			if (entry.getKey().toString().toUpperCase().equals("OPERATIONTIME")) {
				strBuf.append("CREATETIME").append(",");
				valueBuf.append("to_date('").append(entry.getValue())
						.append("','yyyy/mm/dd hh24:mi:ss'),");
			}
			// 过滤des中的 单引号
			if (entry.getKey().toString().toUpperCase().equals("OPERATIONDES")) {
				strBuf.append(entry.getKey()).append(",");
				if (entry.getValue() == null) {
					valueBuf.append("'").append(entry.getValue()).append("',");
				} else {
					String temp_mapValue = entry.getValue().toString()
							.replace("'", "''");
					valueBuf.append("'").append(temp_mapValue).append("',");
				}
			}else{
				strBuf.append(entry.getKey()).append(",");
				valueBuf.append("'").append(entry.getValue()).append("',");
			}
			
		}
		strBuf.deleteCharAt(strBuf.length() - 1).append(")");
		valueBuf.deleteCharAt(valueBuf.length() - 1).append(")");

		strBuf.append(" values ").append(valueBuf);
		headBuf.append(strBuf);
		return headBuf;

	}

	

	private void saveLogDetailByJdbc(String[] strBuff, File file)
			throws BusinessException, FileNotFoundException {
		ApplicationContext applicationContext = StratListerner.applicationContext;
		DataSource dataSource = (DataSource) applicationContext
				.getBean("dataSource");
		Connection con = null;
		String sql_ = "";
		try {
			con = dataSource.getConnection();
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);

			for (int i = 0; i < strBuff.length; i++) {
				sql_ = strBuff[i];
				stmt.addBatch(strBuff[i]);
				// logger.info(strBuff[i]);
				//if (i % 1000 == 0) {
					stmt.executeBatch();
					stmt.clearBatch();

				//}

			}

			stmt.executeBatch();
			stmt.clearBatch();

			moveSuccessFile(file);

			con.commit();
			con.setAutoCommit(true);

			con.close();
			logger.info("保存成功！处理了" + strBuff.length + "条数据");
		} catch (SQLException e) {
			//logger.info(sql_);
			try {
				if (con != null) {
					con.rollback();
					con.setAutoCommit(true);
					con.close();

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new BusinessException(e.toString());
		}

	}

	/*private void saveLogDetail(StringBuffer strBuff, File file)
			throws BusinessException, FileNotFoundException {

		ApplicationContext applicationContext = StratListerner.applicationContext;
		SessionFactory sessionFactory = (SessionFactory) applicationContext
				.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Assert.notNull(strBuff);
		Transaction tr = session.beginTransaction();

		Query query = session.createSQLQuery(strBuff.toString());
		query.executeUpdate();
		moveSuccessFile(file);
		tr.commit();
		if (session != null) {
			session.close();
		}

	}*/

	private void saveErrorLog(File file, String errorCode, String errorMsg) {
		ApplicationContext applicationContext = StratListerner.applicationContext;
		DataSource dataSource = (DataSource) applicationContext
				.getBean("dataSource");
		Connection con = null;
		String sql = "";
		sql += "insert into ST_OPERATELOGSTATE (FILENAME,ERRORCODE,ERRORMSG)";
		sql += "values (?,?,?)";
		// logger.info(sql);
		try {
			con = dataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			stmt.setString(1, file.getName());
			stmt.setString(2, errorCode);
			stmt.setString(3, errorMsg);
			stmt.execute();
			con.commit();
			con.setAutoCommit(true);
			con.close();

		} catch (SQLException e) {
			try {
				if (con != null) {
					con.rollback();
					con.setAutoCommit(true);
					con.close();

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage());
			}
			throw new BusinessException(e.toString());
		}

	}

	private void moveSuccessFile(File file) throws FileNotFoundException {
		// throw new FileNotFoundException();
		String targetFileName = LogServiceImpl.targetFileName;
		targetFileName = targetFileName + "//"+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		try {
			FileUtil.copyToFile(file, targetFileName);

		} catch (FileNotFoundException e) {
			// 数据库记录日志？
			logger.error("移动到成功文件夹异常，文件已直接删除。文件名：" + file.getName() + "错误原因："
					+ e.getMessage());
			saveErrorLog(file, "11001", "移动到成功文件夹异常，但数据已导入，原文件已直接删除");
			e.printStackTrace();
		} finally {
			FileUtil.deleteFromName(file.getPath());
		}
	}

	private void moveFailtureFile(File file) {
		String targetFileName = LogServiceImpl.targetFileName_Failture;
		targetFileName = targetFileName ;
		try {
			FileUtil.copyToFile(file, targetFileName);
			FileUtil.deleteFromName(file.getPath());
		} catch (FileNotFoundException e) {
			// 数据库记录日志
			logger.error("移动到错误文件夹异常，原文件仍留在原地。文件名：" + file.getName() + "错误原因："
					+ e.getMessage());
			saveErrorLog(file, "110005", "移动到错误文件夹异常，原文件仍留在原地");
			e.printStackTrace();
		}
	}

	private String removeRootDir(String fileName) {
		int beginIndex = fileName.indexOf(LogServiceImpl.sourceFileName);
		return fileName.substring(beginIndex);
	}

}
