package com.zhouchao.elasticsearch.service;

import com.zhouchao.elasticsearch.domain.Example;
import com.zhouchao.elasticsearch.domain.ExampleExample;
import com.zhouchao.elasticsearch.repository.ExampleMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import utils.JacksonUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/11/26 16:17
 * @Description
 **/
@Service
@Slf4j
public class ExampleService {

    @Value("${index.example}")
    private String exampleIndex;

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private ExampleMapper exampleMapper;

    public void synIndex() {
        ExampleExample exampleExample = new ExampleExample();
        exampleExample.createCriteria().andStatusEqualTo(10001);
        List<Example> exampleList = exampleMapper.selectByExample(exampleExample);

        log.info("开始同步example表数据。。。");

        for (Example example : exampleList) {
            IndexRequest request = new IndexRequest(exampleIndex)
                    .id(example.getPid())
                    .source(JacksonUtil.toJson(example), XContentType.JSON);
            try {
                client.index(request, RequestOptions.DEFAULT);
            } catch (IOException e) {
                log.info(exampleIndex + ":" + example.getPid() + "同步失败");
            }
        }


    }
}
