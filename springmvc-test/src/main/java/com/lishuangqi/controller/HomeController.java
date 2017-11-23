package com.lishuangqi.controller;

import com.lishuangqi.service.elasticsearch.repository.ArticleRepository;
import com.lishuangqi.service.elasticsearch.repository.vo.ArticleVo;
import com.lishuangqi.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by michael on 2017/10/31.
 * 注解标注此类为springmvc的controller，url映射为"/home"
 */

@Controller
@RequestMapping("/home")
public class HomeController {
    //添加一个日志器
    private static long count =1;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    ArticleRepository articleRepository;
    //映射一个action
    @RequestMapping("/index")
    public  String index(){
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        Iterable<ArticleVo> all = articleRepository.findAll();
        System.out.println(all);
        Iterator<ArticleVo> iterator = all.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getId());
            System.out.println(iterator.next().getTitle());
            System.out.println(iterator.next().getContent());
        }
        return "index";
    }

    @RequestMapping("/post")
    public  String post(String name, String remark){
        //输出日志文件
        logger.info("the first jsp pages");
        if(StringUtil.isEmpty(name) || StringUtil.isEmpty(remark)){
            return "index";
        }
        System.out.println(name);
        System.out.println(remark);
        ArticleVo articleVo = new ArticleVo();
        articleVo.setId(count++ +"");
        articleVo.setTitle(name);
        articleVo.setContent(remark);
        articleVo.setCreatetime(new Date());
        articleRepository.save(articleVo);

        Iterable<ArticleVo> all = articleRepository.findAll();
        System.out.println(all);
        Iterator<ArticleVo> iterator = all.iterator();
        while (iterator.hasNext()){
            ArticleVo vo = iterator.next();
            System.out.println(vo.getId());
            System.out.println(vo.getTitle());
            System.out.println(vo.getContent());
            System.out.println(vo.getCreatetime());
        }
        //返回一个index.jsp这个视图
        return "index";
    }
    @RequestMapping("/search")
    public  String search(String name, String remark){
        //输出日志文件
        logger.info("the first jsp pages");
        System.out.println(name);
        System.out.println(remark);
        if(StringUtil.isEmpty(name)){
            return "search";
        }
//        List<ArticleVo> byTitleAndContent = articleRepository.findByTitleAndContent1(name, remark);
        List<ArticleVo> byTitleAndContent = articleRepository.findByTitle(name);
        Iterator<ArticleVo> iterator = byTitleAndContent.iterator();
        while (iterator.hasNext()){
            ArticleVo vo = iterator.next();
            System.out.println(vo.getId());
            System.out.println(vo.getTitle());
            System.out.println(vo.getContent());
            System.out.println(vo.getCreatetime());
        }
        //返回一个index.jsp这个视图
        return "search";
    }


    @RequestMapping("/delete")
    public  String delete(){
        //输出日志文件
        logger.info("the delete jsp pages");
        //返回一个index.jsp这个视图
        articleRepository.deleteAll();
        return "index";
    }
}