package com.whty.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 适用于jackson2.5版本 
 * @author jlq
 * 2015-11-19
 */


public class JacksonUtils {
	private static Log log = LogFactory.getLog(JacksonUtils.class);

	private static ObjectMapper mapper;

	
	static{
		mapper = new ObjectMapper(); // 设置输出时包含属性的风格
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 禁止使用int代表Enum的order()來反序列化Enum,非常危險
		mapper.configure(
				DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
	}
	
	private enum MapperType {
		ALWAYS, NOTNULL, NON_DEFAULT, NON_EMPTY
	}
	
	private static void setMapperiInclusion(MapperType type){
		switch(type){
			case ALWAYS:
				mapper.setSerializationInclusion(Include.ALWAYS);
				break;
			case NOTNULL:
				mapper.setSerializationInclusion(Include.NON_NULL);;
				break;
			case NON_DEFAULT:
				mapper.setSerializationInclusion(Include.NON_DEFAULT);;
				break;
			case NON_EMPTY:
				mapper.setSerializationInclusion(Include.NON_EMPTY);;
				break;
			default :
				mapper.setSerializationInclusion(Include.ALWAYS);
				break;
		}
	}
	
	
	public static String fromObjToJsonstr(MapperType type,Object object) throws JsonProcessingException{
		setMapperiInclusion(type);
			return mapper.writeValueAsString(object);
	}
	
	public static String fromObjToJsonstr(Object object) throws JsonProcessingException{
		setMapperiInclusion(MapperType.NON_EMPTY);
			return mapper.writeValueAsString(object);
	}
 
	public static <T>T fromJsonstrToObj(String str, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException{
			if(str==null||str.equals("")){
				return null;
			}
			return (T)mapper.readValue(str, valueType);
	}

}
