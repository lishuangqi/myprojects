package com.lishuangqi.service.elasticsearch.repository;

import com.lishuangqi.service.elasticsearch.BaseSearchRepository;
import com.lishuangqi.service.elasticsearch.repository.vo.ArticleVo;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by michael on 2017/11/9.
 */
public interface ArticleRepository extends BaseSearchRepository<ArticleVo, String> {
    /**
     * spring data提供的根据方法名称的查询方式
     * @param title
     * @param content
     * @return
     */
    List<ArticleVo> findByTitleAndContent(String title, String content);

    /**
     * 使用Query注解指定查询语句
     * @param title
     * @param content
     * @return
     *  注意：需要替换的参数？需要加双引号；需要指定参数下标，从0开始
     *  双引号和不加引号都可，不能是单引号
     *  field查询已经废弃，可参考当前查询语法，已换成term查询
     *  @Query("{\"bool\" : {\"must\" : [ {\"term\" : {\"title\" : \"?1\"}}, {\"term\" : {\"content\" : \"?0\"}} ]}}")
     *  @Query("{bool : {must : [ {field : {title : ?}}, {field : {content : ?}} ]}}")
     */
    @Query("{bool : {must : [ {term : {title : ?0}}, {term : {content : ?1}} ]}}")
    List<ArticleVo> findByTitleAndContent1(String title, String content);

    @Query("{bool : {should : [ {term : {title : ?0}} ]}}")
    List<ArticleVo> findByTitle(String title);

    //还有分页、排序等API
}