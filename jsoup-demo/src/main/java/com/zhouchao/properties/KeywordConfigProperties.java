package com.zhouchao.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zhouchao
 * @Date: 2021/06/15 11:50
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "keyword.search")
public class KeywordConfigProperties {

    private int size;

    private List<String> list;

}
