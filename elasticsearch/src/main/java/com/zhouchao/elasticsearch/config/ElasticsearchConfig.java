package com.zhouchao.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhouchao
 * @Description es配置类
 * @Date 2022/12/13 18:26
 */
@Configuration
public class ElasticsearchConfig {

    @Value("${spring.elasticsearch.rest.uris}")
    private String hostList;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        String[] split = hostList.split(",");

        HttpHost[] httpHosts = new HttpHost[split.length];

        for (int i = 0; i < split.length; i++) {
            String iterm = split[i];
            String[] s = iterm.split(":");
            httpHosts[i] = new HttpHost(s[0], Integer.parseInt(s[1]), "http");
        }
        return new RestHighLevelClient(RestClient.builder(httpHosts));
    }

}
