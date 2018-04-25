package com.whty.common;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 */

/**
 * @author Administrator
 *
 */
public class Utils {

    public static boolean isNetIsAvailable() {
        try {

            final URL url = new URL("http://www.baidu.com");
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            if(conn.getResponseCode() == 200){
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public static int getRecordCount(String url, String year) {
        String pageFix = "&page=1";
        String yearFix = "&fsyear=";

       /* if(StringUtil.isBlank(year)){
            year = "";
        }*/
        if(null==year||"".equals(year)){
            year = "";
        }

        JSONObject obj = getOnePageJSONObjectBySite(url + pageFix + yearFix + year);
        int totalRecord = obj.getJSONObject("totalRecord").getIntValue("num");

        return totalRecord;
    }

    public static int getPageCount(String url, String year) {
        int count = 0;

        int totalRecord = getRecordCount(url,year);
        count = totalRecord / 50;
        if (totalRecord % 50 > 0) {
            count++;
        }

        return count;
    }

    /** 支持包含目录
     * @param filePath
     * @param obj
     * @throws IOException
     */
    public static void serial2File(String filePath,Object obj) throws IOException{
        File targetFile = new File(filePath);
        File parent = targetFile.getParentFile();
        if(!parent.exists() && !parent.mkdirs()){
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(targetFile));
            writer.write(obj.toString());
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }




    public static String getHtmlBySite(String site,LinkedHashMap<String,String> paraMap) throws Exception {
        StringBuilder contentBuf = new StringBuilder();


        if(null != paraMap && false == paraMap.isEmpty()){

            site += "?";

            for(String key:paraMap.keySet()){
                String val = paraMap.get(key);
                site = site + key + "=" + val + "&";
            }

            site = site.substring(0,site.length() - 1);
        }
        System.out.println("请求的URL：【"+site+"】");
        URL url = new URL(site);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("contentType", "utf-8");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
        InputStreamReader input = new InputStreamReader(httpURLConnection.getInputStream(), "utf-8");
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";


        //int lineNum = 0;
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
            //lineNum++;
        }

        return contentBuf.toString();
    }

    public static String getUTF8HtmlBySite(String site,LinkedHashMap<String,String> paraMap) throws Exception {
        StringBuilder contentBuf = new StringBuilder();


        if(null != paraMap && false == paraMap.isEmpty()){

            site += "?";

            for(String key:paraMap.keySet()){
                String val = paraMap.get(key);
                site = site + key + "=" + val + "&";
            }

            site = site.substring(0,site.length() - 1);
        }
        HttpURLConnection httpURLConnection=null;
        BufferedReader bufReader=null;
        try {
            URL url = new URL(site);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("contentType", "utf-8");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Connection", "close");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(60000);
            InputStreamReader input = new InputStreamReader(httpURLConnection.getInputStream(), "utf-8");
            bufReader = new BufferedReader(input);
            String line = "";
           //获取状态码
            int code = httpURLConnection.getResponseCode();
            System.out.println(code);

            //int lineNum = 0;
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
                //lineNum++;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }
            return contentBuf.toString();
    }

    public static String getGBKHtmlBySite(String site,LinkedHashMap<String,String> paraMap) throws Exception {
        StringBuilder contentBuf = new StringBuilder();


        if(null != paraMap && false == paraMap.isEmpty()){
            if(site.contains("?")){
                site += "&";
            }else{
                site += "?";
            }


            for(String key:paraMap.keySet()){
                String val = paraMap.get(key);
                site = site + key + "=" + val + "&";
            }

            site = site.substring(0,site.length() - 1);
        }

        HttpURLConnection httpURLConnection=null;
        BufferedReader bufReader=null;
        try {
            URL url = new URL(site);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("contentType", "GBK");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Upgrade-Insecure-Requests","1");
            httpURLConnection.setRequestProperty("Connection", "close");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
//            int pv=1;
//            String cookies="ant_stream_59df58828c697=1509352860/2521576586; _gscs_1601713973=09324049z55vok10|pv:"+pv+"; _gscbrs_1601713973=1; bow_stream_59df58828c697=13; _gscu_1601713973=08154017xrx0od80";
//            httpURLConnection.setRequestProperty("Cookie",cookies);
            InputStreamReader input = new InputStreamReader(httpURLConnection.getInputStream(), "GBK");
            bufReader = new BufferedReader(input);
            String line = "";


            //int lineNum = 0;
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
                //lineNum++;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }
        return contentBuf.toString();
    }

    private static JSONObject getOnePageJSONObjectBySite(String url) {

        JSONObject obj = new JSONObject();

        String html = getHtmlBySite(url);
        if (StringUtils.isBlank(html)) {
            return obj;
        } else {
            html = html.substring(1, html.lastIndexOf(")"));
            obj = JSONObject.parseObject(html);
        }

        return obj;
    }


    private static String getHtmlBySite(String url) {

        StringBuffer html = new StringBuffer();
        InputStreamReader isr = null;
        BufferedReader buf = null;
        String str = null;
        try {
            URL urlObj = new URL(url);
            URLConnection con = urlObj.openConnection();
            isr = new InputStreamReader(con.getInputStream(), "UTF-8");
            buf = new BufferedReader(isr);
            while ((str = buf.readLine()) != null) {
                html.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    buf.close();
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return html.toString();
    }

    /**
     * @param url
     * @return
     * @throws Exception
     */
    public static JSONArray getAllJsonArrayFormEOL(String url) throws Exception{
        JSONArray jsonArray = new JSONArray();

        int page = 1;
        int pageCount = 1;

        String firstPage = Utils.getHtmlBySite(url + "&page=" + page,null);
       /* if(StringUtil.isBlank(firstPage)){
            return jsonArray;
        }*/
        if(null==firstPage||"".equals(firstPage)){
        	 return jsonArray;
        }

        firstPage = firstPage.substring(1,firstPage.lastIndexOf(")"));
       /* if(true == StringUtil.isBlank(firstPage)){
            return jsonArray;
        }*/
        if(true == (null==firstPage||"".equals(firstPage))){
            return jsonArray;
        }

        //	firstPage
        {
            JSONObject firstPageObj = JSONObject.parseObject(firstPage);
            final int totalRecord = firstPageObj.getJSONObject("totalRecord").getIntValue("num");

            if(totalRecord == 0){
                return jsonArray;
            }

            pageCount = (totalRecord/50);
            if(totalRecord%50 > 0){
                pageCount++;
            }


            JSONArray firstJsonArray = firstPageObj.getJSONArray("school");
            if(null != firstJsonArray && false == firstJsonArray.isEmpty()){
                jsonArray.addAll(firstJsonArray);
            }
        }

        //	otherPage
        for(page = 2;page <= pageCount;page++){

            String otherPage = Utils.getHtmlBySite(url + "&page=" + page,null);

            System.out.println("请求的URL为："+url+ "&page=" + page);
            System.out.println("返回的页面信息为："+otherPage);
            if(otherPage.contains("DOCTYPE")){
                Thread.sleep(3000);
               page--;
               continue;
            }
            otherPage = otherPage.substring(1,otherPage.lastIndexOf(")"));
            JSONObject otherPageObj = JSONObject.parseObject(otherPage);
            JSONArray otherJsonArray = otherPageObj.getJSONArray("school");
            if(null != otherJsonArray && false == otherJsonArray.isEmpty()){
                jsonArray.addAll(otherJsonArray);
            }
            System.out.println("循环到第"+page+"条");
        }

        return jsonArray;
    }

    public static String deserialFile2String(String filePath) throws IOException{
        StringBuilder buf = new StringBuilder();

        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        try{
            String str2 = br.readLine();
            while (str2 != null) {
                buf.append(str2);
                str2 = br.readLine();
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            br.close();
        }

        return (buf.toString());
    }

   
}
