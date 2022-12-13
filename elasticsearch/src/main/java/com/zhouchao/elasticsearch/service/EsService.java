package com.zhouchao.elasticsearch.service;

import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

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
}
