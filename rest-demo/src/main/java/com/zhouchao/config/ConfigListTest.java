package com.zhouchao.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: @ConfigurationProperties prefix属性不能用驼峰，应该用小写字母、数字、中划线“-”区分单词
 * @Author : zhouchao
 * @Date : 2024-04-02 11:07
 */
@Data
@Component
@ConfigurationProperties(prefix = "list")
public class ConfigListTest {

    private List<String> test;

}


