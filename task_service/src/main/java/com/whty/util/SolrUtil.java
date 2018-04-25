package com.whty.util;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whty.solr.model.OrgSolr;
import com.whty.solr.model.PostSolr;

/**
 * @author 作者: fangpei
 * @version 创建时间：2015-5-29 上午8:34:38
 */
public class SolrUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(SolrUtil.class);

	/** solr的url地址 */
	// private static final String
	// solrUrl="http://127.0.50.73:10002/solr/post/";

	private static final String solrUrl = "http://yun.zjer.cn:20000/solr/org/";
	private static SolrServer solrServer;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		query();
	}

	public static void query() {
		int start = 0;
		int rows = 500;
		Boolean flag = true;
		try {
			solrServer = new HttpSolrServer(solrUrl);
			ModifiableSolrParams params = new ModifiableSolrParams();

			do {
				logger.info("---开始查询第"+(start+1)+"到"+(start+10)+"条数据");
				params.set("q", "*:*");
				params.set("start", start);
				params.set("rows", rows);
				QueryResponse response = solrServer.query(params);
				List<OrgSolr> orgSolrList = response.getBeans(OrgSolr.class);

				if (orgSolrList.size() > 0) {
					for (int j = 0; j < orgSolrList.size(); j++) {
						OrgSolr os = orgSolrList.get(j);
						System.out.println(os);
					}
					start += rows;
				}else{
					flag = false;
				}
				
			} while (flag);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update() {
		try {
			solrServer = new HttpSolrServer(solrUrl);
			ModifiableSolrParams params = new ModifiableSolrParams();
			params.set("q", "id:1611604639");
			params.set("start", 0);
			params.set("rows", 1);
			QueryResponse response = solrServer.query(params);
			List<PostSolr> postSolrList = response.getBeans(PostSolr.class);
			for (int i = 0; i < 1; i++) {
				PostSolr ps = postSolrList.get(i);
				ps.setComment_count(100);
			}
			if (postSolrList.size() > 0) {
				solrServer.addBeans(postSolrList);
				solrServer.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
