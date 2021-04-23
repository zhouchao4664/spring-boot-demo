package com.zhouchao.config.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhouchao.config.datasource.DataSourceProperties;
import com.zhouchao.config.datasource.DynamicDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.LocaleUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Map;
import java.util.Optional;

/**
 * @Author zhouchao
 * @Date 2021/4/23 18:00
 * @Description
 **/
@Slf4j
@Aspect
@Component
public class DynamicSourceAspect {

    @Autowired
    private DataSourceProperties properties;

    /**
     * 切换数据源规则：
     * 1. 当请求头中包含key: ACCEPT_LANGUAGE {@link HttpHeaders}
     * 2. 当请求头中没有语言标识key 则会从方法参数中获取 参数名称 language
     */
    @Before("@annotation(DynamicSource)")
    public void changeSource(JoinPoint joinPoint) {

        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            changeDefaultSource();
            return;
        }
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        if (null == request) {
            changeDefaultSource();
            return;
        }

        /**
         * TODO
         * {@link HttpHeaders}
         */
        String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
        if (!StringUtils.isEmpty(language)) {

            log.info("请求语言解析:{}", language);
            DynamicDataSource.setDataSourceKey(LocaleUtils.toLocale(language).getLanguage());
            return;
        }

        final String contentType = request.getHeader(HttpHeaders.CONTENT_TYPE);
        if (null != contentType && contentType.equals(MediaType.APPLICATION_JSON_VALUE)) {
            language = analysisJson(request);
            if (!StringUtils.isEmpty(language)) {

                log.info("请求语言解析:{}", language);
                DynamicDataSource.setDataSourceKey(LocaleUtils.toLocale(language).getLanguage());
                return;
            }
        }

        // 尝试从请求参数中获取
        language = request.getParameter("language");
        if (StringUtils.isEmpty(language)) {
            changeDefaultSource();
            return;
        }

        log.info("请求语言解析:{}", language);
        DynamicDataSource.setDataSourceKey(LocaleUtils.toLocale(language).getLanguage());
    }

    @After("@annotation(DynamicSource)")
    public void restoreSource(JoinPoint joinPoint) {
        DynamicDataSource.clearDataSourceKey();
    }

    /**
     * 选择默认数据源
     */
    private void changeDefaultSource() {

        final Map<String, DataSourceProperties.Datasource> datasources = properties.getDatasources();
        final Optional<String> optional = datasources.keySet().stream().filter(v -> datasources.get(v).getIsDefault()).findAny();
        if (optional.isPresent()) {
            final String language = optional.get();
            log.info("请求头中未检测到Accept-Language信息 尝试使用默认语言:{}", language);
            DynamicDataSource.setDataSourceKey(language);
            return;
        }
        throw new RuntimeException("系统错误，请检查数据源配置");
    }

    /**
     * Application/Json数据解析
     */
    private String analysisJson(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception ignored) {
        }
        String str = sb.toString().replaceAll("\\s", "").replaceAll("\n", "");
        Language language = null;
        try {
            language = new ObjectMapper().readValue(str, Language.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (null == language) {
            return null;
        }
        return language.getLanguage();
    }

    @Data
    private static class Language {
        private String language;
    }
}
