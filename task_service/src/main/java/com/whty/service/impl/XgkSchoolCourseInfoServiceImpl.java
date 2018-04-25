package com.whty.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.whty.common.Utils;
import com.whty.common.XgkConstant;
import com.whty.model.XgkSchoolCourseInfoDto;
import com.whty.service.XgkSchoolCourseInfoService;

/**
 * user 同步服务
 * @author Administrator
 *
 */
@Service
public class XgkSchoolCourseInfoServiceImpl implements XgkSchoolCourseInfoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //抓取数据的目标地址（浙江首页-全部学校）
    public final String ZJ_SITE="http://zt.zjzs.net/xuanke2018/allcollege.html";

    public final List<String> SELECT_COURSE_LIST=Arrays.asList("不限","历史","物理","化学","不作要求","生命科学","无","地理","无限制","酒店管理","思想政治","无科目要求","不指定","政治");

    //抓取数据的目标地址（上海首页）
    public final String SH_SITE="http://www.shmec.gov.cn/web/jyzt/xkkm2017/detail.php";

    public LinkedHashMap<String,Object> grabbingDataService(){
        LinkedHashMap<String, String> paraMap = new LinkedHashMap<String, String>(2);
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        Set<XgkSchoolCourseInfoDto> zjSchoolDtoSet=new HashSet<XgkSchoolCourseInfoDto>();
        Set<XgkSchoolCourseInfoDto> shSchoolDtoSet=new HashSet<XgkSchoolCourseInfoDto>();
        //先抓取浙江数据html utf-8编码
        try {
            String page = Utils.getUTF8HtmlBySite(ZJ_SITE,paraMap);
            zjSchoolDtoSet=parseZJHtmlToMap(page,XgkConstant.ZJ_CODE);
        } catch (Exception e) {
        	logger.debug("浙江Html转换MAP失败");
        }
        if(CollectionUtils.isNotEmpty(zjSchoolDtoSet)){
        	logger.debug("浙江数据抓取成功！");
        	//入库
           // saveData(zjSchoolDtoSet,XgkConstant.ZJ_CODE);
            resultMap.put("success",true);
            resultMap.put("msg","抓取成功!");
        }else{
            resultMap.put("success",false);
            resultMap.put("msg","抓取失败!");
        }
        return resultMap;
    }

    /*
     * 获取浙江学校数据
     */
    private Set<XgkSchoolCourseInfoDto> parseZJHtmlToMap(String html,String provinceId){
       
        Set<XgkSchoolCourseInfoDto> schoolDtoSet = new HashSet<XgkSchoolCourseInfoDto>();
        List<String> zjSchoolErrorList=new ArrayList<String>();
        //将学校名和id转成map
        Map<String,String> schoolMap=new HashMap<String,String>();
        Map<String,String> map = new HashMap<String, String>(50);
        Document doc = Jsoup.parse(html);
        Elements schoolList = doc.select("div.dis").select("table").select("tbody").select("tr");
        if(schoolList.isEmpty()){
            return schoolDtoSet;
        }else {
            schoolList.remove(0);
            //获取对应的url
            for (Element school : schoolList) {
                Elements schoolInfo = school.getAllElements();
                if(schoolInfo.size()<3){
                    continue;
                }else{
                    String schoolName=schoolInfo.get(3).text();
                    System.out.println("正在抓取==="+schoolName+"===的数据");
                   
                    String childSite="http://zt.zjzs.net/xuanke2018/"+schoolInfo.get(2).text()+".html";
                    try {
                        String page = Utils.getUTF8HtmlBySite(childSite,null);
                        List<XgkSchoolCourseInfoDto> childList=parseZJSelectCourseHtmlToMap(page);
                        if(CollectionUtils.isNotEmpty(childList)){
                            int size=childList.size();
                            for(int i=0;i<size;i++){
                                XgkSchoolCourseInfoDto dto=new XgkSchoolCourseInfoDto();
                                dto.setSchoolId(UUID.randomUUID().toString());
                                dto.setProvinceId(provinceId);
                                dto.setSchoolCode(schoolInfo.get(2).text());
                                dto.setProfession(childList.get(i).getProfession());
                                dto.setProfessionArrangement(childList.get(i).getProfessionArrangement());
                                dto.setProfessionChild(childList.get(i).getProfessionChild());
                                dto.setSelectCourse(childList.get(i).getSelectCourse());
                                schoolDtoSet.add(dto);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
           
            return schoolDtoSet;
        }
    }

   

    /*
    * 获取浙江学校数据
    */
    private List<XgkSchoolCourseInfoDto> parseZJSelectCourseHtmlToMap(String html){
        List<XgkSchoolCourseInfoDto> childInfoList=new ArrayList<XgkSchoolCourseInfoDto>();

        Document doc = Jsoup.parse(html);
        //tabsContainer_ul li.clearfix
        Elements childList = doc.select("div.search").select("table").select("tbody").select("tr");
        if(childList.isEmpty()){
            return childInfoList;
        }else {
            childList.remove(0);
            int i=0;
            for (Element child : childList) {
                i++;
                Elements childInfo = child.getAllElements();
                if(!"".equals(childInfo.text())){
                    XgkSchoolCourseInfoDto dto=new XgkSchoolCourseInfoDto();

                    dto.setSelectCourse(childInfo.get(4).text());
                    dto.setProfessionChild(childInfo.get(5).text());
                    dto.setProfession(childInfo.get(2).text());
                    dto.setProfessionArrangement(childInfo.get(1).text());
                    childInfoList.add(dto);
                }
            }
            return childInfoList;
        }
    }

    private List<String> assembleHtmlPage(List<String> siteList) throws Exception{
        List<String> htmlList=new ArrayList<String>();
        if(siteList.isEmpty()){
            return htmlList;
        }else{
            LinkedHashMap<String, String> paraMap = new LinkedHashMap<String, String>(2);

            for(String site:siteList){
                String firstPage=Utils.getGBKHtmlBySite(site,paraMap);
                Document doc = Jsoup.parse(firstPage);
                if(doc.select("div.xyy").select("div>font").size()>0){
                    htmlList.add(firstPage);
                    Integer pageCount=Integer.parseInt(doc.select("div.xyy").select("div>font").get(2).text());
                    if(pageCount>1){
                        for(int page = 2;page <= pageCount;page++){
                            paraMap.put("page", "" + page);
                            String buf = Utils.getGBKHtmlBySite(site,paraMap);
                            htmlList.add(buf);
                            paraMap.clear();
                        }
                    }
                }
            }
            return htmlList;
        }
    }
	
	


}
