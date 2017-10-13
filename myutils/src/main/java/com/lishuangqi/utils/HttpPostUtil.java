package com.lishuangqi.utils;

import com.alibaba.fastjson.JSON;
import com.lishuangqi.utils.security.AES128Encrypt;
import com.lishuangqi.utils.security.MD5Tools;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class HttpPostUtil {

    public static String postJson(String url, JSONObject parms) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        JSONObject jsonObject = new JSONObject();

        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(JSON.toJSONString(parms), "utf-8"));
            httpPost.setHeader("Content-Type", "application/json");
            CloseableHttpResponse response;
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity);
            return body;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String postFromUrlJson(String url, JSONObject parms) {
        StringBuffer response = new StringBuffer();
        HttpClient httpClient = new HttpClient();
        PostMethod method = new PostMethod(url);

        try {
            NameValuePair[] param = new NameValuePair[parms.size()];
            if (parms != null) {
                int i = 0;
                for (Iterator iter = parms.keys(); iter.hasNext(); ) {
                    String key = (String) iter.next();
                    param[i++] = new NameValuePair(key, (String) parms.get(key));
                }
            }
            method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=GBK");
            method.setRequestBody(param);
            InputStream responBodyStream = null;
            InputStreamReader streamReader = null;
            BufferedReader reader = null;
            try {
                httpClient.executeMethod(method);
                System.out.println(method.getStatusCode());
                if (method.getStatusCode() == HttpStatus.SC_OK) {
                    responBodyStream = method.getResponseBodyAsStream();
                    streamReader = new InputStreamReader(responBodyStream, "GBK");
                    reader = new BufferedReader(streamReader);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                }
            } catch (IOException e) {
                System.out.println("执行Http Post请求" + url + "时，发生异常！");
            } finally {
                try {
                    responBodyStream.close();
                    streamReader.close();
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String postJson2(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        JSONObject jsonObject = new JSONObject();

        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "text/html");
            CloseableHttpResponse response;
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity);
            return body;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] sendRequestByForm(String url, String params, String method)
            throws Exception {
        URL url1 = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
        // conn.setConnectTimeout(10000);//连接超时 单位毫秒
        // conn.setReadTimeout(2000);//读取超时 单位毫秒
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestMethod(method);// 提交模式
        conn.connect();
        if (params != null) {
            byte[] bypes = params.toString().getBytes("UTF-8");
            conn.getOutputStream().write(bypes);// 输入参数
        }
        InputStream inStream = conn.getInputStream();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();// 网页的二进制数据
        outStream.close();
        inStream.close();
        return data;
    }

    public static JSONObject dataProcessing(URL url) {
        JSONObject json = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestMethod("GET");
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            json = JSONObject.fromObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static JSONArray dataArrayProcessing(URL url) {
        JSONArray json = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestMethod("GET");
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            json = JSONArray.fromObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    private static String POST_MOBILE_URL = "http://aaaaa/dddd/";
    private static String APP_KEY = "adfadfadfllll";

    public static JSONObject getMobileData(String method, String queryTime, JSONObject parms, long timestamp) {
        try {
            parms.put("appkey", AES128Encrypt.encrypt(APP_KEY));
            parms.put("timestamp", AES128Encrypt.encrypt(timestamp + ""));
            System.out.println("ASIAINFO" + APP_KEY + (queryTime != null ? queryTime : "") + "Test" + timestamp);
            String signature = MD5Tools.md5Str("ASIAINFO" + APP_KEY + (queryTime != null ? queryTime : "") + "Test" + timestamp);
            parms.put("signature", signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(POST_MOBILE_URL + method + (queryTime != null ? "?queryTime=" + queryTime : ""));
        System.out.println(parms.toString());
        String resultStr = HttpPostUtil.postFromUrlJson(POST_MOBILE_URL + method + (queryTime != null ? "?queryTime=" + queryTime : ""), parms);
        return JSONObject.fromObject(resultStr);
    }

    public static void main(String[] args) {
        try {
            long begintime = System.currentTimeMillis();

            URL url = new URL("http://adfadf/Consultation/toAddNew.html?m={\"contactNum\":\"15351217622\",\"province\":\"四川\",\"city\":\"成都\"}");
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setRequestProperty("Cookie", "sessionKey=bdf1f434b1fed4343f0f33ab70a26d80");

            urlcon.connect();         //获取连接
            InputStream is = urlcon.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
            StringBuffer bs = new StringBuffer();
            String l = null;
            while ((l = buffer.readLine()) != null) {
                bs.append(l).append("/n");
            }
            System.out.println(bs.toString());

            String sessionId = "";
            String cookieVal = "";
            String key = null;
            //取cookie
            for (int i = 1; (key = urlcon.getHeaderFieldKey(i)) != null; i++) {
                if (key.equalsIgnoreCase("set-cookie")) {
                    cookieVal = urlcon.getHeaderField(i);
                    cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
                    sessionId = sessionId + cookieVal + ";";
                }
            }
            System.out.println(sessionId);

            System.out.println("总共执行时间为：" + (System.currentTimeMillis() - begintime) + "毫秒");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
