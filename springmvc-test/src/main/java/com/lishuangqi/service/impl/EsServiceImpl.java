package com.lishuangqi.service.impl;

import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.stats.StatsBuilder;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.elasticsearch.search.aggregations.metrics.sum.SumBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by michael on 2017/11/9.
 */
@Service("esService")
public class EsServiceImpl{

    @Autowired
    private static Client client;

    /**
     * 用docId获取document
     * @param indexName
     * @param typeName
     * @param docId
     */
    private static void getWithId(String indexName, String typeName, String docId) {
        //get with id
        GetResponse gResponse = client.prepareGet(indexName, typeName, docId).execute().actionGet();
        System.out.println(gResponse.getIndex());
        System.out.println(gResponse.getType());
        System.out.println(gResponse.getVersion());
        System.out.println(gResponse.isExists());
        Map<String, Object> results = gResponse.getSource();
        if(results != null) {
            for(String key : results.keySet()) {
                Object field = results.get(key);
                System.out.println(key);
                System.out.println(field);
            }
        }
    }
    private static void indexWithBulk(String index, String type) {
        //指定索引名称，type名称和documentId(documentId可选，不设置则系统自动生成)创建document
        IndexRequest ir1 = new IndexRequest();
        String source1 = "{" + "\"user\":\"kimchy\"," + "\"price\":\"6.3\"," + "\"tid\":\"20001\"," + "\"message\":\"Elasticsearch\"" + "}";
        ir1.index(index).type(type).id("100").source(source1);
        IndexRequest ir2 = new IndexRequest();
        String source2 = "{" + "\"user\":\"kimchy2\"," + "\"price\":\"7.3\"," + "\"tid\":\"20002\"," + "\"message\":\"Elasticsearch\"" + "}";
        ir2.index(index).type(type).id("102").source(source2);
        IndexRequest ir3 = new IndexRequest();
        String source3 = "{" + "\"user\":\"kimchy3\"," + "\"price\":\"8.3\"," + "\"tid\":\"20003\"," + "\"message\":\"Elasticsearch\"" + "}";
        ir3.index(index).type(type).id("103").source(source3);
        BulkResponse response = client.prepareBulk().add(ir1).add(ir2).add(ir3).execute().actionGet();
        BulkItemResponse[] responses = response.getItems();
        if(responses != null && responses.length > 0) {
            for(BulkItemResponse r : responses) {
                String i = r.getIndex();
                String t = r.getType();
                System.out.println(i+","+t);
            }
        }

    }
    private static void sumCountSearch(String indexName, String typeName,
                                       String sumField, String countField, String searchField, String searchValue) {
        SumBuilder sb = AggregationBuilders.sum("sumPrice").field(sumField);
        TermQueryBuilder tb = termQuery(searchField, searchValue);
        SearchResponse sResponse = client.prepareSearch(indexName).setTypes(typeName).setQuery(tb).addAggregation(sb).execute().actionGet();
        Map<String, Aggregation> aggMap = sResponse.getAggregations().asMap();
        if(aggMap != null && aggMap.size() > 0) {
            for(String key : aggMap.keySet()) {
                if("sumPrice".equals(key)) {
                    Sum s = (Sum)aggMap.get(key);
                    System.out.println(key + "," + s.getValue());
                }
                else if("countTid".equals(key)) {
                    StatsBuilder c = (StatsBuilder)aggMap.get(key);
                    System.out.println(key + "," + c.toString());
                }
            }
        }
    }
    private static void updateDoc(String indexName, String typeName, String id) throws IOException, InterruptedException, ExecutionException {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index(indexName);
        updateRequest.type(typeName);
        updateRequest.id(id);
        updateRequest.doc(jsonBuilder().startObject().field("gender", "male").endObject());
        UpdateResponse resp = client.update(updateRequest).get();
        resp.getClass();
    }
    private static void scrollSearch(String indexName, String typeName, String... ids) {
        IdsQueryBuilder qb = QueryBuilders.idsQuery().addIds(ids);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                .setSearchType(SearchType.SCAN)
                .setQuery(qb)
                .setScroll(new TimeValue(100))
                .setSize(50)
                .execute()
                .actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards+","+timeCost+","+sShards);

        while (true) {
            SearchHits hits = sResponse.getHits();
            SearchHit[] hitArray = hits.getHits();
            for(int i = 0; i < hitArray.length; i++) {
                SearchHit hit = hitArray[i];
                Map<String, Object> fields = hit.getSource();
                for(String key : fields.keySet()) {
                    System.out.println(key);
                    System.out.println(fields.get(key));
                }
            }
            sResponse = client.prepareSearchScroll(sResponse.getScrollId()).setScroll(new TimeValue(100)).execute().actionGet();
            if (sResponse.getHits().getHits().length == 0) {
                break;
            }
        }
    }
    private static void deleteDocuments(String string, String string2) {
        SearchResponse sResponse = client.prepareSearch(string)
                .setTypes(string2)
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchAllQuery())
                .setFrom(0).setSize(60)
                .execute()
                .actionGet();
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        List<String> ids = new ArrayList<String>(hitArray.length);
        for(int i = 0; i < count; i++) {
            System.out.println("==================================");
            SearchHit hit = hitArray[i];
            ids.add(hit.getId());

        }
        for(String id : ids) {
            DeleteResponse response = client.prepareDelete(string, string2, id).execute().actionGet();
        }
    }
    private static void dateRangeSearch(String indexName, String typeName,
                                        String termName, String from, String to) {
        // 构建range query
        //2015-08-20 12:27:11
        QueryBuilder qb = QueryBuilders.rangeQuery(termName).from(from).to(to);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                // 设置search type
                // 常用search type用：query_then_fetch
                // query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                // 查询的termName和termvalue
                .setQuery(qb)
                // 设置排序field
                .addSort(termName, SortOrder.DESC)
                // 设置分页
                .setFrom(0).setSize(60).execute().actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards + "," + timeCost + "," + sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for (int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for (String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    private static void dateRangeSearch2(String indexName, String typeName,
                                         String termName, String from, String to) {
        // 构建range query
        QueryBuilder qb = QueryBuilders.rangeQuery(termName).from(from).to(to);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                // 设置search type
                // 常用search type用：query_then_fetch
                // query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                // 查询的termName和termvalue
                .setQuery(qb)
                // 设置排序field
                .addSort(termName, SortOrder.DESC)
                // 设置分页
                .setFrom(0).setSize(60).execute().actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards + "," + timeCost + "," + sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for (int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for (String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    private static void countWithQuery(String indexName, String typeName, String termName, String termValue, String sortField, String highlightField) {
        //search result get source
        CountResponse cResponse = client.prepareCount(indexName)
                .setTypes(typeName)
                .setQuery(termQuery(termName, termValue))
                .execute()
                .actionGet();
        int tShards = cResponse.getTotalShards();
        int sShards = cResponse.getSuccessfulShards();
        System.out.println(tShards+","+sShards);
        long count = cResponse.getCount();
    }
    private static void rangeSearchWithOtherSearch(String indexName, String typeName,
                                                   String termName, String min, String max, String termQueryField) {
        // 构建range query
        QueryBuilder qb = QueryBuilders.rangeQuery(termName).from(min).to(max);
        TermQueryBuilder tb = termQuery(termName, termQueryField);
        BoolQueryBuilder bq = boolQuery().must(qb).must(tb);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                // 设置search type
                // 常用search type用：query_then_fetch
                // query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                // 查询的termName和termvalue
                .setQuery(bq)
                // 设置排序field
                .addSort(termName, SortOrder.DESC)
                // 设置分页
                .setFrom(0).setSize(60).execute().actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards + "," + timeCost + "," + sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for (int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for (String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    private static void termRangeSearch(String indexName, String typeName,
                                        String termName, String min, String max, String highlightField) {
        QueryBuilder qb = QueryBuilders.rangeQuery(termName).from(min).to(max);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                // 设置search type
                // 常用search type用：query_then_fetch
                // query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                // 查询的termName和termvalue
                .setQuery(qb)
                // 设置排序field
                .addSort(termName, SortOrder.DESC)
                //设置高亮field
                .addHighlightedField(highlightField)
                // 设置分页
                .setFrom(0).setSize(60).execute().actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards + "," + timeCost + "," + sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for (int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for (String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    private static void sumOneField(String indexName, String typeName, String fieldName) {
        SumBuilder sb = AggregationBuilders.sum("sum").field(fieldName);
        //search result get source
        SearchResponse sResponse = client.prepareSearch(indexName).setTypes(typeName).addAggregation(sb).execute().actionGet();
        Map<String, Aggregation> aggMap = sResponse.getAggregations().asMap();
        if(aggMap != null && aggMap.size() > 0) {
            for(String key : aggMap.keySet()) {
                Sum s = (Sum)aggMap.get(key);
                System.out.println(s.getValue());
            }
        }
    }
    private static void searchWithTermQueryAndRetureSpecifiedFields(String indexName, String typeName, String termName,String termValue, String sortField, String highlightField,String... fields) {
        SearchRequestBuilder sb = client.prepareSearch(indexName)
                .setTypes(typeName)
                // 设置search type
                // 常用search type用：query_then_fetch
                // query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                // 查询的termName和termvalue
                .setQuery(termQuery(termName, termValue))
                // 设置排序field
                .addSort(sortField, SortOrder.DESC)
                // 设置高亮field
                .addHighlightedField(highlightField)
                // 设置分页
                .setFrom(0).setSize(60);
        for (String field : fields) {
            sb.addField(field);
        }
        SearchResponse sResponse = sb.execute().actionGet();
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for (int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, SearchHitField> fm = hit.getFields();
            for (String key : fm.keySet()) {
                SearchHitField f = fm.get(key);
                System.out.println(f.getName());
                System.out.println(f.getValue());
            }
        }
    }
    private static void searchWithIds(String indexName, String typeName, String sortField, String highlightField, String... ids) {
        IdsQueryBuilder qb = QueryBuilders.idsQuery().addIds(ids);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                //设置search type
                //常用search type用：query_then_fetch
                //query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                //查询的termName和termvalue
                .setQuery(qb)
                //设置排序field
                .addSort(sortField, SortOrder.DESC)
                //设置高亮field
                .addHighlightedField(highlightField)
                //设置分页
                .setFrom(0).setSize(60)
                .execute()
                .actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards+","+timeCost+","+sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for(int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for(String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }

    /**
     * 在index:indexName, type:typeName中做通配符查询
     * @param indexName
     * @param typeName
     * @param termName
     * @param termValue
     * @param sortField
     * @param highlightField
     */
    private static void wildcardSearch(String indexName, String typeName, String termName, String termValue, String sortField, String highlightField) {
        QueryBuilder qb = QueryBuilders.wildcardQuery(termName, termValue);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                //设置search type
                //常用search type用：query_then_fetch
                //query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                //查询的termName和termvalue
                .setQuery(qb)
                //设置排序field
//              .addSort(sortField, SortOrder.DESC)
                //设置高亮field
//              .addHighlightedField(highlightField)
                //设置分页
                .setFrom(0).setSize(60)
                .execute()
                .actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards+","+timeCost+","+sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for(int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for(String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }

    /**
     * 在index:indexName, type:typeName中做模糊查询
     * @param indexName
     * @param typeName
     * @param termName
     * @param termValue
     * @param sortField
     * @param highlightField
     */
    private static void fuzzySearch(String indexName, String typeName, String termName, String termValue, String sortField, String highlightField) {
        QueryBuilder qb = QueryBuilders.fuzzyQuery(termName, termValue);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                //设置search type
                //常用search type用：query_then_fetch
                //query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                //查询的termName和termvalue
                .setQuery(qb)
                //设置排序field
                .addSort(sortField, SortOrder.DESC)
                //设置高亮field
                .addHighlightedField(highlightField)
                //设置分页
                .setFrom(0).setSize(60)
                .execute()
                .actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards+","+timeCost+","+sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for(int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for(String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    /**
     * 在index:indexName, type:typeName中做区间查询
     * @param indexName
     * @param typeName
     * @param termName
     * @param min
     * @param max
     * @param highlightField
     */
    private static void numericRangeSearch(String indexName, String typeName,
                                           String termName, double min, double max, String highlightField) {
        // 构建range query
        QueryBuilder qb = QueryBuilders.rangeQuery(termName).from(min).to(max);
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                // 设置search type
                // 常用search type用：query_then_fetch
                // query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                // 查询的termName和termvalue
                .setQuery(qb)
                // 设置排序field
                .addSort(termName, SortOrder.DESC)
                //设置高亮field
                .addHighlightedField(highlightField)
                // 设置分页
                .setFrom(0).setSize(60).execute().actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards + "," + timeCost + "," + sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for (int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for (String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    /**
     * 在索引indexName, type为typeName中查找两个term：term1(termName1, termValue1)和term2(termName2, termValue2)
     * @param indexName
     * @param typeName
     * @param termName1
     * @param termValue1
     * @param termName2
     * @param termValue2
     * @param sortField
     * @param highlightField
     */
    private static void searchWithBooleanQuery(String indexName, String typeName, String termName1, String termValue1,
                                               String termName2, String termValue2, String sortField, String highlightField) {
        //构建boolean query
        BoolQueryBuilder bq = boolQuery().must(termQuery(termName1, termValue1)).must(termQuery(termName2, termValue2));
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                //设置search type
                //常用search type用：query_then_fetch
                //query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                //查询的termName和termvalue
                .setQuery(bq)
                //设置排序field
                .addSort(sortField, SortOrder.DESC)
                //设置高亮field
                .addHighlightedField(highlightField)
                //设置分页
                .setFrom(0).setSize(60)
                .execute()
                .actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        System.out.println(tShards+","+timeCost+","+sShards);
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for(int i = 0; i < count; i++) {
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for(String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    /**
     * 在索引indexName, type为typeName中查找term(termName, termValue)
     * @param indexName
     * @param typeName
     * @param termName
     * @param termValue
     * @param sortField
     * @param highlightField
     */
    private static void searchWithTermQuery(String indexName, String typeName, String termName, String termValue, String sortField, String highlightField) {
        SearchResponse sResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                //设置search type
                //常用search type用：query_then_fetch
                //query_then_fetch是先查到相关结构，然后聚合不同node上的结果后排序
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                //查询的termName和termvalue
                .setQuery(termQuery(termName, termValue))
                //设置排序field
//              .addSort(sortField, SortOrder.DESC)
                //设置高亮field
//              .addHighlightedField(highlightField)
                //设置分页
                .setFrom(0).setSize(60)
                .execute()
                .actionGet();
        int tShards = sResponse.getTotalShards();
        long timeCost = sResponse.getTookInMillis();
        int sShards = sResponse.getSuccessfulShards();
        SearchHits hits = sResponse.getHits();
        long count = hits.getTotalHits();
        SearchHit[] hitArray = hits.getHits();
        for(int i = 0; i < count; i++) {
            System.out.println("==================================");
            SearchHit hit = hitArray[i];
            Map<String, Object> fields = hit.getSource();
            for(String key : fields.keySet()) {
                System.out.println(key);
                System.out.println(fields.get(key));
            }
        }
    }
    /**
     * 用java的map构建document
     */
    private static void indexWithMap(String indexName, String typeName) {
        Map<String, Object> json = new HashMap<String, Object>();
        //设置document的field
        json.put("user","kimchy2");
        json.put("postDate",new Date());
        json.put("price",6.4);
        json.put("message","Elasticsearch");
        json.put("tid","10002");
        json.put("endTime","2015-08-25 09:00:00");
        //指定索引名称，type名称和documentId(documentId可选，不设置则系统自动生成)创建document
        IndexResponse response = client.prepareIndex(indexName, typeName, "2").setSource(json).execute().actionGet();
        //response中返回索引名称，type名称，doc的Id和版本信息
        String index = response.getIndex();
        String type = response.getType();
        String id = response.getId();
        long version = response.getVersion();
        boolean created = response.isCreated();
        System.out.println(index+","+type+","+id+","+version+","+created);
    }

    /**
     * 用java字符串创建document
     */
    private static void indexWithStr(String indexName, String typeName) {
        //手工构建json字符串
        //该document包含user, postData和message三个field
        String json = "{" + "\"user\":\"kimchy\"," + "\"postDate\":\"2013-01-30\"," + "\"price\":\"6.3\"," + "\"tid\":\"10001\"," + "}";
        //指定索引名称，type名称和documentId(documentId可选，不设置则系统自动生成)创建document
        IndexResponse response = client.prepareIndex(indexName, typeName, "1")
                .setSource(json)
                .execute()
                .actionGet();
        //response中返回索引名称，type名称，doc的Id和版本信息
        String index = response.getIndex();
        String type = response.getType();
        String id = response.getId();
        long version = response.getVersion();
        boolean created = response.isCreated();
        System.out.println(index+","+type+","+id+","+version+","+created);
    }

    private static void deleteDocWithId(String indexName, String typeName, String docId) {
        DeleteResponse dResponse = client.prepareDelete(indexName, typeName, docId).execute().actionGet();
        String index = dResponse.getIndex();
        String type = dResponse.getType();
        String id = dResponse.getId();
        long version = dResponse.getVersion();
        System.out.println(index+","+type+","+id+","+version);
    }

    /**
     * 创建索引
     * 注意：在生产环节中通知es集群的owner去创建index
     * @param indexName
     * @param documentType
     * @throws IOException
     */
    private static void createIndex(String indexName, String documentType) throws IOException {
        final IndicesExistsResponse iRes = client.admin().indices().prepareExists(indexName).execute().actionGet();
        if (iRes.isExists()) {
            client.admin().indices().prepareDelete(indexName).execute().actionGet();
        }
        client.admin().indices().prepareCreate(indexName).setSettings(Settings.settingsBuilder().put("number_of_shards", 1).put("number_of_replicas", "0")).execute().actionGet();
        XContentBuilder mapping = jsonBuilder()
                .startObject()
                .startObject(documentType)
//                     .startObject("_routing").field("path","tid").field("required", "true").endObject()
                .startObject("_source").field("enabled", "true").endObject()
                .startObject("_all").field("enabled", "false").endObject()
                .startObject("properties")
                .startObject("user")
                .field("store", true)
                .field("type", "string")
                .field("index", "not_analyzed")
                .endObject()
                .startObject("message")
                .field("store", true)
                .field("type","string")
                .field("index", "analyzed")
                .field("analyzer", "standard")
                .endObject()
                .startObject("price")
                .field("store", true)
                .field("type", "float")
                .endObject()
                .startObject("nv1")
                .field("store", true)
                .field("type", "integer")
                .field("index", "no")
                .field("null_value", 0)
                .endObject()
                .startObject("nv2")
                .field("store", true)
                .field("type", "integer")
                .field("index", "not_analyzed")
                .field("null_value", 10)
                .endObject()
                .startObject("tid")
                .field("store", true)
                .field("type", "string")
                .field("index", "not_analyzed")
                .endObject()
                .startObject("endTime")
                .field("type", "date")
                .field("store", true)
                .field("index", "not_analyzed")
                .field("format", "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .endObject()
                .startObject("date")
                .field("type", "date")
                .endObject()
                .endObject()
                .endObject()
                .endObject();
        client.admin().indices()
                .preparePutMapping(indexName)
                .setType(documentType)
                .setSource(mapping)
                .execute().actionGet();
    }
}