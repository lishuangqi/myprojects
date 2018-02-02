package com.lishuangqi.controller;

import com.lishuangqi.common.ztree.Tree;
import com.lishuangqi.common.ztree.TreeNode;
import com.lishuangqi.service.elasticsearch.repository.ArticleRepository;
import com.lishuangqi.service.elasticsearch.repository.vo.ArticleVo;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by michael on 2017/10/31.
 * 注解标注此类为springmvc的controller，url映射为"/home"
 */

@Controller
@RequestMapping("/tree")
public class TreeDataController {
    //添加一个日志器
    private static long count =1;
    private static final Logger logger = LoggerFactory.getLogger(TreeDataController.class);
    @Autowired
    ArticleRepository articleRepository;
    //映射一个action
    @RequestMapping("/index")
    public  String index(){
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "treeData";
    }

    @ResponseBody
    @RequestMapping("/treeData")
    public net.sf.json.JSONObject treeData(Model model, HttpServletRequest request) {
        Map map = new HashMap();
        map.put("parentId", "ROOT");
        map.put("orderName", "sort");
        map.put("descAsc", "asc");
        List<JSONObject> platProductsRegs = new ArrayList<JSONObject>();
        for (JSONObject temp : platProductsRegs){
//            temp.setUrl("");
//            temp.setLevel(1);
//            temp.setParentId("ROOT");
            temp.put("url","");
            temp.put("Level",1);
            temp.put("parentId", "ROOT");
        }
        Tree tree = new Tree(platProductsRegs);
        TreeNode nresult = tree.buildMyTree(null);
        JSONObject json = JSONObject.fromObject(nresult);
        return json;
    }
}