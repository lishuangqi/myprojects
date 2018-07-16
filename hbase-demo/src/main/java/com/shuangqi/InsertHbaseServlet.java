package com.shuangqi;

/**
 * Created by michael on 2018/7/13.
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shuangqi.hbaseTest.HBaseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RequestMapping("/testInsert")
@Controller
public class InsertHbaseServlet extends HttpServlet {

    @RequestMapping("/{tableName}/send")
    @ResponseBody
    public void doGet(@PathVariable("tableName") String tableName,@RequestParam("data") JSONArray data, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Cache-Control", "no-cache");
        List<JSONObject> list = new ArrayList<>();
        boolean existTab = HBaseUtil.isExistTab(tableName);
        if(existTab) {
            for (Object tmpObj : data) {
                JSONObject tmpJson = (JSONObject) tmpObj;
                Iterator<String> iterator = tmpJson.keySet().iterator();

                String uuid = UUID.randomUUID().toString();
                while (iterator.hasNext()) {
                    JSONObject json = new JSONObject();
                    String key = iterator.next();
                    if ("id".equals(key)) {
                        continue;
                    }
                    //行健
                    json.put("rowKey", tmpJson.get("id") == null ? uuid : tmpJson.get("id"));
                    //列族
                    json.put("family", key);
                    //列
                    json.put("qualifier", key);
                    //值
                    json.put("value", tmpJson.get(key));

                    list.add(json);
                    System.out.println("json:" + json);

                }
            }
            /* HBaseUtil.insert(path, "1001", "", data, "zhangsan"); */
            long startTime = System.currentTimeMillis();
            HBaseUtil.insertBatch(tableName, list);
            long endTime = System.currentTimeMillis();
            System.out.println("hbaes插入数据共使用时间为：" + (endTime - startTime) + "毫秒");
            resp.getWriter().write(": Insert hbase successed!");
        }else{
            System.out.println("TODO create table");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
