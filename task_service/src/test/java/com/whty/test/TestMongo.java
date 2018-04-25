package com.whty.test;

import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.whty.mongodb.dao.PostDao;
import com.whty.mongodb.model.Post;


/**
 * 单元测试
 * @author Administrator
 *
 */
public class TestMongo extends BaseTest{
		@Resource
		private PostDao postDao;
		
		/**
		 * 插入
		 */
//		@Test
//		public void testInsert() {
//			logger.info("插入数据----------------------");
//			Post post = new Post();
//			//post.set_id("33333"); 会自定生成24位的uuid
//			post.setId("333");
//			post.setPaperid(111);
//			post.setUserid("ldh");
//			post.setUsername("刘德华");
//			post.setAge(40);
//			postDao.save(post);
//			logger.info(post.toString());
//			
//		}
		
		
		
		/**
		 * 多行插入
		 */
//		@Test
//		public void testInsertAll() {
//			logger.info("插入数据----------------------");
//			List<Post> list = new ArrayList<Post>();
//			for (int i = 0; i < 10; i++) {
//				Post post = new Post();
//				//post.set_id("33333"); 会自定生成24位的uuid
//				post.setId("333");
//				post.setPaperid(111);
//				post.setUserid("ldh");
//				post.setUsername("刘德华");
//				post.setAge(i+1);
//				list.add(post);
//			}
//			postDao.saveList(list);
//			
//			for (Post post2 : list) {
//				logger.info(post2.toString());
//			}
//		}
		
		/**
		 * id参数指的是_id
		 */
//		@Test
//		public void testFindById() {
//			logger.info("获取单个对象----------------------");
//			Post post = postDao.findById("33333");
//			logger.info(post.toString());
//			
//		}
		
		
		/**
		 * 单条件查询
		 */
//		@Test
//		public void testFindByCriteria() {
//			logger.info("获取单个对象----------------------");
//			Query query = new Query();
//			Criteria criteria = new Criteria();
//			criteria.and("id").is("111");
//			query.addCriteria(criteria);
//			Post post = postDao.findOne(query);
//			logger.info(post.toString());
//			
//		}
		
		/**
		 * 多条件查询or &&  and
		 */
		/*@Test
		public void testFindByCriteriaSc() {
			logger.info("获取单个对象----------------------");
			Query query = new Query();
			Criteria criteria = new Criteria();
			//or
			criteria.orOperator(Criteria.where("id").is("111"),Criteria.where("username").is("刘耀"));
			//and
			//criteria.andOperator(Criteria.where("id").is("111"),Criteria.where("username").is("刘耀"));
			
			query.addCriteria(criteria);
			List<Post> posts = postDao.find(query);
			for (Post post2 : posts) {
				logger.info("对象："+post2.toString());
			}
			
		}*/
		
		/**
		 * 指定字段查询,只查询userid和username两个字段
		 */
//		@Test
//		public void testFindByCriteriaSc() {
//			logger.info("获取单个对象----------------------");
//			Query query = new Query();
//			Criteria criteria = new Criteria();
//			//or
//			criteria.orOperator(Criteria.where("id").is("111"),Criteria.where("username").is("刘耀"));
//			query.addCriteria(criteria);
//			query.fields().include("userid").include("username");
//			List<Post> posts = postDao.find(query);
//			for (Post post2 : posts) {
//				logger.info("对象："+post2.toString());
//			}
//			
//		}
		
		/**
		 * 排序
		 */
//		@Test
//		public void testFindByCriteriaSc() {
//			logger.info("获取单个对象----------------------");
//			Query query = new Query();
//			Criteria criteria = Criteria.where("userid").is("ldh");
//			query.addCriteria(criteria);
//			 // 排序查询sort方法,按照age,paperid降序排列
//			query.with(new Sort(Direction.ASC, "age").and(new Sort(Direction.ASC, "paperid")));
//			List<Post> posts = postDao.find(query);
//			for (Post post2 : posts) {
//				logger.info("对象："+post2.toString());
//			}
//			
//		}
		
		/**
		 * 分页
		 */
//		@Test
//		public void testFindByCriteriaSc() {
//			logger.info("获取分页信息----------------------");
//			Query query = new Query();
//			Criteria criteria = Criteria.where("userid").is("ldh");
//			query.addCriteria(criteria);
//			 // 排序查询sort方法,按照age,paperid降序排列
//			query.with(new Sort(Direction.ASC, "age").and(new Sort(Direction.ASC, "paperid")));
//			Pager page = new Pager(1,2);
//			Pager<Post> posts = postDao.findPage(page, query);
//			for (Post post2 : posts.getData()) {
//				logger.info("对象："+post2.toString());
//			}
//			
//		}
		/**
		 * 大于小于的用法等
		 */
//		@Test
//		public void testFind() {
//			Query query = new Query();
//			Criteria criteria = new Criteria();
//			//大于10小于30
//			criteria.andOperator(Criteria.where("age").gte(10),Criteria.where("age").lte(30));
//			query.addCriteria(criteria);
//			List<Post> list = postDao.find(query);
//			
//			for (Post post : list) {
//				logger.info(post.toString());
//			}
//			
//		}
		/**
		 * 聚合操作,返回total
		 */
		
		/*@Test
		public void testJuhe() {
			//多个key组合分组，一个key分组掺入一个参数即可  
	        GroupBy groupBy = GroupBy.key("userid").initialDocument("{total:0}").reduceFunction("function(doc, prev){prev.total+=1}");  
			
			//默认返回的只有userid和total字段
	        Iterator<Post> list = postDao.findByJuhe(groupBy);
			
			 while(list.hasNext()){
	        	 Post post = list.next();
	        	 logger.info(post.toString());
	       }
			
		}*/
		
		/**
		 * 带查询的聚合操作
		 * 并且返回其他的字段，这里以id为例子
		 */
		@Test
		public void testJuhe() {
			Query query = new Query();
			Criteria criteria = new Criteria();
			//userid不能为空
	     	criteria.andOperator(Criteria.where("userid").ne(null));
			//多个key组合分组，一个key分组掺入一个参数即可  
	        GroupBy groupBy = GroupBy.key("userid","username").initialDocument("{id:[],total:0}").reduceFunction("function(doc, prev){prev.id.push(doc.id);prev.total+=1}");  
			
	        Iterator<Post> list = postDao.findByJuhe(criteria,groupBy);
	         while(list.hasNext()){
	        	 Post post = list.next();
	        	 logger.info(post.toString());
	       }
	       
		}

	
}
