package com.whty.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.whty.common.SynTypeEnum;
import com.whty.model.FpNewUser;
import com.whty.service.UserNewService;
import com.whty.solr.model.UserSolr;
import com.whty.solr.repositories.UserRepository;

/**
 * user 同步服务
 * @author Administrator
 *
 */
@Service
public class UserServiceNewImpl implements UserNewService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	

	@Resource
	private UserRepository userRepository;

	@Override
	public void SyncData(String day) {
	
		logger.error("开始同步ST_PUSHSPACE_ALL_DM");
		process(day);
		logger.error("结束同步ST_PUSHSPACE_ALL_DM");
	}
	
	@Override
	public void SyncData(String day, SynTypeEnum synType) {
		
	}

	
	/**
	 * ST_PUSHSPACE_ALL_DM FpUser.custType 用户类型 UserSolr UserSolr.usertype
	 * 
	 * 
	 * @param day
	 * @param synType
	 */
	public void process(String day) {
		List solrList = new ArrayList();
		List<FpNewUser> list = new ArrayList<FpNewUser>();
			for (FpNewUser fpUser : list) {
				logger.info(fpUser.toString());
				try{
					UserSolr userSolr = userRepository.findByPersonid(
						fpUser.getCustId());
				
					updateSolrData(fpUser,userSolr,solrList);
				}catch(Exception e){
					e.printStackTrace();
					continue;
				}

			}
			
			userRepository.save(solrList);

	}
	
	
	/**
	 * 更新Solr数据  学生,老师
	 * @param fpOrga
	 * @param userSolr
	 */
	public void updateSolrData(FpNewUser fpUser,UserSolr userSolr,List solrList){
		if(userSolr!=null){
			userSolr.setWeekNumber(fpUser.getSevenAccessNums());
			userSolr.setTotalNumber(fpUser.getTotalAccessNums());
			userSolr.setAddNumber(fpUser.getAddAccessNums());
			userSolr.setTotalRes(fpUser.getTotalResNums());
			userSolr.setAddRes(fpUser.getAddResNums());
			userSolr.setOp_time(fpUser.getOpTime());
			solrList.add(userSolr);
		}

	}


}
