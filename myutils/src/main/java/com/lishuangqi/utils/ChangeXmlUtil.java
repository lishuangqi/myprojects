package com.lishuangqi.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Iterator;
import java.util.Set;

public class ChangeXmlUtil {

    /*public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\yanguicao.mp3")));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\yanguicao222.mp3")));
        int ch = 0;
        while((ch = bis.read())!=-1){
            bos.write(ch);
        }
        bis.close();
        bos.close();
    }*/
    
     
    /*** 
     *  
     * 获取JSON类型 
     *         判断规则 
     *             判断第一个字母是否为{或[ 如果都不是则不是一个JSON格式的文本 
     *          
     * @param str 
     * @return 
     */ 
    public static String getJSONType(String str){ 
        if(StringUtils.isEmpty(str)){ 
            return "ERROR"; 
        } 
         
        final char[] strChar = str.substring(0, 1).toCharArray(); 
        final char firstChar = strChar[0]; 
         
        // LogUtils.d(JSONUtil.class, "getJSONType", " firstChar = "+firstChar); 
         
        if(firstChar == '{'){ 
            return "JSON_OBJECT"; 
        }else if(firstChar == '['){ 
            return "JSON_ARRAY"; 
        }else{ 
            return "JSON_ERROR";
        } 
    }
    
    public static void main(String[] args) throws DocumentException {
        String json = "{\"a\":\"100\",\"b\":{\"b1\":\"b_value1\",\"b2\":[{\"b1\":\"b_value1\",\"b2\":\"b_value2\"},{\"b1\":\"b_value1\",\"b2\":\"b_value2\"}]},\"c\": {\"c1\":\"c_value1\",\"c2\":\"c_value2\"}}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject.toJSONString());
        
        //System.out.println("type:"+type);
        /*Document doc = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement("response");
        doc.setRootElement(root);
        Element result = analysisJson(jsonObject,root,root);
        System.out.println(result.asXML());*/
        //2.第二种 创建文档及设置根元素节点的方式  
        /*Element root = DocumentHelper.createElement("Person");  
        Document document = DocumentHelper.createDocument(root);  
        //给根节点添加属性  
        root.addAttribute("学校", "南大").addAttribute("位置", "江西");  
          
        //给根节点添加孩子节点  
        Element element1 = root.addElement("学生");  
        element1.addElement("姓名").addAttribute("婚姻", "单身").addText("小章");  
        element1.addElement("年龄").addText("21");  
          
        Element element2 = root.addElement("学生");  
        element2.addElement("姓名").addAttribute("婚姻", "单身").addText("小红").addElement("爱好").addText("唱歌");  
        element2.addElement("年龄").addText("22");  
        System.out.println(document.asXML());*/
        XMLSerializer xmlSerializer = new XMLSerializer();                
        xmlSerializer.setTypeHintsEnabled(false);         
        xmlSerializer.setRootName("response");   
        String sContent=xmlSerializer.write(net.sf.json.JSONObject.fromObject(json)); 
        Document docCon = DocumentHelper.parseText(sContent);                     
        String sXml=docCon.getRootElement().asXML(); 
        System.out.println(sXml);
    }
    
    /*public static Document change(Object objJson, Element root){
        JSONObject childObj = null;
        JSONArray childArr = null;
        if(objJson instanceof JSONArray){
            JSONArray objArray = (JSONArray) objJson; 
            for (int i = 0; i < objArray.size(); i++) {
                //root.add(arg0)
            }
        }else if(objJson instanceof JSONObject){
            
        }
    }*/
    public static Element analysisJson(Object objJson, Element root, Element parent) {  
            // 如果obj为json数组  
        if (objJson instanceof JSONArray) {  
            //将接收到的对象转换为JSONArray数组  
            JSONArray objArray = (JSONArray) objJson;  
            //对JSONArray数组进行循环遍历  
            for (int i = 0; i < objArray.size(); i++) {  
                 
                root.add(analysisJson(objArray.get(i), root, null));
                //root.attributeValue("id", "" + (i + 1));
                //调用回调方法  
                /*List list = parent.selectNodes(root.getName());
                if(null != list && !list.isEmpty()){
                    System.out.println(root.asXML());
                }else{
                }*/
            }
            //return root;
        // 如果为json对象  
        }else if (objJson instanceof JSONObject) {  
            //将Object对象转换为JSONObject对象  
            JSONObject jsonObject = (JSONObject) objJson;  
            //迭代多有的Key值  
            Set it = jsonObject.keySet();  
            Iterator itg = it.iterator();
            //遍历每个Key值  
            while (itg.hasNext()) {  
                //将key值转换为字符串  
                String key = itg.next().toString();
                System.out.println("key:" + key);
                //根据key获取对象  
                Object object = jsonObject.get(key);  
                // 如果得到的是数组  
                if (object instanceof JSONArray) {  
                    //将Object对象转换为JSONObject对象  
                    JSONArray objArray = (JSONArray) object;  
                    //调用回调方法  
                    root.add(analysisJson(objArray,DocumentHelper.createElement(key),null));
                    
                }  
                // 如果key中是一个json对象  
                else if (object instanceof JSONObject) {  
                    //调用回调方法  
                    root.add(analysisJson((JSONObject) object,DocumentHelper.createElement(key),null));  
                }else if(object instanceof String){
                    root.add(DocumentHelper.createElement(key).addText(object.toString()));
                    //root.add(parent);
                }
            }  
        } 
        System.out.println(root.asXML());
        return root;  
    }
    public static Element analysisJson2(Object objJson, Element root, String pName) {  
        // 如果obj为json数组  
    if (objJson instanceof JSONArray) {  
        //将接收到的对象转换为JSONArray数组  
        JSONArray objArray = (JSONArray) objJson;  
        //对JSONArray数组进行循环遍历  
        for (int i = 0; i < objArray.size(); i++) {  
             
            //root.add(analysisJson(objArray.get(i), root, null));
            Element e = root.addElement(pName);
            analysisJson2(objArray.get(i), e, null);
            //root.attributeValue("id", "" + (i + 1));
            //调用回调方法  
            /*List list = parent.selectNodes(root.getName());
            if(null != list && !list.isEmpty()){
                System.out.println(root.asXML());
            }else{
            }*/
        }
        //return root;
    // 如果为json对象  
    }else if (objJson instanceof JSONObject) {  
        //将Object对象转换为JSONObject对象  
        JSONObject jsonObject = (JSONObject) objJson;  
        //迭代多有的Key值  
        Set it = jsonObject.keySet();  
        Iterator itg = it.iterator();
        //遍历每个Key值  
        while (itg.hasNext()) {  
            //将key值转换为字符串  
            String key = itg.next().toString();
            System.out.println("key:" + key);
            //根据key获取对象  
            Object object = jsonObject.get(key);  
            // 如果得到的是数组  
            if (object instanceof JSONArray) {  
                //将Object对象转换为JSONObject对象  
                JSONArray objArray = (JSONArray) object;  
                //调用回调方法  
                //root.add(analysisJson(objArray,DocumentHelper.createElement(key),null));
                analysisJson2(objArray,root,key);
                
            }  
            // 如果key中是一个json对象  
            else if (object instanceof JSONObject) {  
                //调用回调方法  
                root.add(analysisJson2((JSONObject) object,DocumentHelper.createElement(key),null)); 
                
            }else if(object instanceof String){
                root.addElement(key).addText(object.toString());
                //root.add(parent);
            }
        }  
    } 
    System.out.println(root.asXML());
    return root;  
}
}
