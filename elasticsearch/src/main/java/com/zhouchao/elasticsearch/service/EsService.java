package com.zhouchao.elasticsearch.service;

import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Description es服务类，展示一些es的基础操作
 * @Date 2022/12/13 18:39
 */
@Service
public class EsService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

/*  PUT /elasticsearch_test
    {
        "settings":{},
        "mappings":{
            "properties":{
                "description":{
                    "type":"text",
                    "analyzer":"ik_max_word"
                },
                "name":{
                    "type": "keyword"
                },
                "pic":{
                    "type": "text",
                    "index": false
                },
                "studymodel":{
                    "type":"keyword:
                }
            }
        }
    }
 */

    /**
     * @description: 创建索引对象
     * @author: zhouchao
     * @date: 2022/12/13 18:48
     */
    public void testCreateIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("elasticsearch_test");

//        XContentBuilder builder = XContentFactory.jsonBuilder()
//                .startObject()
//                .field("properties")
//                .startObject()
//                .field("description").startObject().field("type", "text").field("analyzer", "ik_max_word").endObject()
//                .field("name").startObject().field("type", "keyword").endObject()
//                .field("pic").startObject().field("type", "text").field("index", false).endObject()
//                .field("studymodel").startObject().field("type", "keyword").endObject()
//                .endObject()
//                .endObject();
        createIndexRequest.mapping("{\n" +
                "            \"properties\":{\n" +
                "                \"description\":{\n" +
                "                    \"type\":\"text\",\n" +
                "                    \"analyzer\":\"ik_max_word\"\n" +
                "                },\n" +
                "                \"name\":{\n" +
                "                    \"type\": \"keyword\"\n" +
                "                },\n" +
                "                \"pic\":{\n" +
                "                    \"type\": \"text\",\n" +
                "                    \"index\": false\n" +
                "                },\n" +
                "                \"studymodel\":{\n" +
                "                    \"type\":\"keyword\"\n" +
                "                }\n" +
                "            }\n" +
                "        }", XContentType.JSON);

        IndicesClient indicesClient = restHighLevelClient.indices();
        CreateIndexResponse createIndexResponse = indicesClient.create(createIndexRequest, RequestOptions.DEFAULT);

        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println(acknowledged);
    }

    /**
     * @description: 删除索引
     * @author: zhouchao
     * @date: 2022/12/14 10:56
     */
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("elasticsearch_test");

        IndicesClient indicesClient = restHighLevelClient.indices();

        AcknowledgedResponse delete = indicesClient.delete(deleteIndexRequest, RequestOptions.DEFAULT);

        boolean acknowledged = delete.isAcknowledged();
        System.out.println(acknowledged);
    }

/*
    POST /elasticsearch_test/_doc/1
    {
      "name": "spring cloud实战",
      "description": "本课程主要从四个章节进行讲解： 1.微服务架构入门 2.spring cloud 基础入门 3.实战Spring Boot 4.注册中心eureka。",
      "studymodel":"201001",
      "timestamp": "2020-08-22 20:09:18",
      "price": 5.6
    }
*/

    /**
     * @description: 添加文档
     * @author: zhouchao
     * @date: 2022/12/14 11:01
     */
    public void testAddDoc() throws IOException {
        IndexRequest indexRequest = new IndexRequest("elasticsearch_test");

        indexRequest.id("1");

        Map<String, Object> jsonMap = new HashMap<>(8);
        jsonMap.put("name", "spring cloud实战3");
        jsonMap.put("description", "本课程主要从四个章节进行讲解3： 1.微服务架构入门 2.spring cloud 基础入门 3.实战Spring Boot 4.注册中心eureka。");
        jsonMap.put("studymodel", "3101001");
        jsonMap.put("timestamp", "2020-07-22 20:09:18");
        jsonMap.put("price", 35.6);

        indexRequest.source(jsonMap);

        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = indexResponse.getResult();
        System.out.println(result);
    }

    /**
     * @description: 查询文档
     * @author: zhouchao
     * @date: 2022/12/14 15:00
     */
    public void testGetDoc() throws IOException {
        GetRequest getRequest = new GetRequest("elasticsearch_test", "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);

        Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        System.out.println(sourceAsMap);
    }

    //搜索全部记录
    /*
       GET   /elasticsearch_test/_search
        {
          "query":{
             "match_all":{}
          }
        }
    */

    /**
     * @description: matchAll查询
     * @author: zhouchao
     * @date: 2022/12/14 15:02
     */
    public void testSearchAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest("elasticsearch_test");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();

        // 匹配到的总记录数
        TotalHits totalHits = hits.getTotalHits();

        // 得到匹配度搞的文档
        SearchHit[] searchHits = hits.getHits();

        // 日期格式化对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (SearchHit searchHit : searchHits) {
            String id = searchHit.getId();
            // 文档内容
            Map<String, Object> sourceMap = searchHit.getSourceAsMap();
            String name = (String) sourceMap.get("name");
            String timestamp = (String) sourceMap.get("timestamp");
            String description = (String) sourceMap.get("description");
            Double price = (Double) sourceMap.get("price");
            System.out.println(name);
            System.out.println(timestamp);
            System.out.println(description);
            System.out.println(price);
        }
    }

    /**
     * @description: TermQuery查询
     * @author: zhouchao
     * @date: 2022/12/14 17:00
     */
    public void testTermQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("elasticsearch_test");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("name", "spring cloud实战"));
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();

        // 匹配到的总记录数
        TotalHits totalHits = hits.getTotalHits();

        // 得到匹配度搞的文档
        SearchHit[] searchHits = hits.getHits();

        // 日期格式化对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (SearchHit searchHit : searchHits) {
            String id = searchHit.getId();
            // 文档内容
            Map<String, Object> sourceMap = searchHit.getSourceAsMap();
            String name = (String) sourceMap.get("name");
            String timestamp = (String) sourceMap.get("timestamp");
            String description = (String) sourceMap.get("description");
            Double price = (Double) sourceMap.get("price");
            System.out.println(name);
            System.out.println(timestamp);
            System.out.println(description);
            System.out.println(price);
        }
    }

    /**
     * @description: 分页查询
     * @author: zhouchao
     * @version: 1.0.0
     * @date: 2022/12/14 17:47
     */
    public void testSearchAllPage() throws IOException {
        SearchRequest searchRequest = new SearchRequest("elasticsearch_test");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.fetchSource(new String[]{"name", "studymodel", "price", "timestamp"}, new String[]{});

        // 设置分页
        int page = 1;
        int size = 2;
        int from = (page - 1) * size;

        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);

        // 设置price 降序
        searchSourceBuilder.sort("price", SortOrder.DESC);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();

        // 匹配到的总记录数
        TotalHits totalHits = hits.getTotalHits();

        // 得到匹配度搞的文档
        SearchHit[] searchHits = hits.getHits();

        // 日期格式化对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (SearchHit searchHit : searchHits) {
            String id = searchHit.getId();
            // 文档内容
            Map<String, Object> sourceMap = searchHit.getSourceAsMap();
            String name = (String) sourceMap.get("name");
            String timestamp = (String) sourceMap.get("timestamp");
            String description = (String) sourceMap.get("description");
            Double price = (Double) sourceMap.get("price");
            System.out.println(name);
            System.out.println(timestamp);
            System.out.println(description);
            System.out.println(price);
        }
    }
}
