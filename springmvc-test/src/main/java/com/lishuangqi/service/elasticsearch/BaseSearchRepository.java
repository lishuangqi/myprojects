package com.lishuangqi.service.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by michael on 2017/11/9.
 */
public interface BaseSearchRepository<E, ID extends Serializable>
        extends ElasticsearchRepository<E, ID>, PagingAndSortingRepository<E, ID> {
}
