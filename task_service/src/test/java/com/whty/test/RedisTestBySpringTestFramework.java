package com.whty.test;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;

import com.whty.model.TestRedisDTO;
import com.whty.util.JedisManager;
import com.whty.util.SerializeUtil;

/**
 * 单元测试
 * @author Administrator
 *
 */
public class RedisTestBySpringTestFramework extends BaseTest{
	
   
	 @Resource
	    private JedisManager jedisManager;
	@Test
	public void testInsert() {
		String tokenInfo = "USER_TOKEN_KEY" + UUID.randomUUID().toString().replaceAll("-", "");
		TestRedisDTO redis = new TestRedisDTO();
		redis.setAge(10);
		redis.setId("111");
		redis.setIntrsting("basketball");
		redis.setName("ly");
		try {
			jedisManager.saveValueByKey(1, tokenInfo.getBytes(), SerializeUtil.serialize( redis),24*60 *60 * 7);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		logger.info("保存成功");
		
	}
	 
	/* @Test
		public void testGet() {
			
			TestRedisDTO redis = null;
			
			try {
				byte[] bt =  jedisManager.getValueByKey(1, "USER_TOKEN_KEYe7a8dd61cf0f4966b92220238cf52614".getBytes());
				redis = (TestRedisDTO) SerializeUtil.unserialize(bt);
			     
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			logger.info("名字："+redis.getName());
			
		}*/
	 
	/* @Test
		public void testDel() {
			
			try {
				 jedisManager.deleteByKey(1, "USER_TOKEN_KEYe7a8dd61cf0f4966b92220238cf52614".getBytes());
			     
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			logger.info("删除成功");
			
		}*/
	 
	 
	
	
}
