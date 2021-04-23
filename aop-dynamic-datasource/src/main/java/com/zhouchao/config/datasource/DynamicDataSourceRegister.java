package com.zhouchao.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.DataSourceException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2021/4/22 16:37
 * @Description
 **/

public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private DataSource defaultDataSource;

    private final Map<String, DataSource> dataSources = new HashMap<>();

    private static final String prefix = "spring.datasource.dynamic";

    @Override
    public void setEnvironment(Environment environment) {
        final Binder binder = Binder.get(environment);
        final DataSourceProperties dataSourceProperties = binder.bind(prefix, DataSourceProperties.class).get();
        final Map<String, DataSourceProperties.Datasource> datasourceMap = dataSourceProperties.getDatasource();

        final long count = datasourceMap.values().stream().filter(DataSourceProperties.Datasource::getIsDefault).count();

        if (count > 1) throw new RuntimeException("默认数据源只能设置一个");
        if (count < 1) throw new RuntimeException("必须设置一个默认数据源 is-default:true");

        datasourceMap.forEach((key, datasource) -> {
            final DataSource dataSource = dataSource(datasource);
            if (datasource.getIsDefault()) defaultDataSource = dataSource;
            dataSources.put(key, dataSource);
            dataBinder(dataSource, environment, key);
        });
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        final Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("dataSource", defaultDataSource);
        targetDataSources.putAll(dataSources);

        final GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);

        final MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        propertyValues.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
    }

    private DataSource dataSource(DataSourceProperties.Datasource datasource) {

        if (null == datasource) {
            throw new DataSourceException("dataSource config ds is null");
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(datasource.getUrl());
        config.setDriverClassName(datasource.getDriverClassName());
        config.setUsername(datasource.getUsername());
        config.setPassword(datasource.getPassword());
        return new HikariDataSource(config);
    }

    private void dataBinder(DataSource dataSource, Environment env, String key) {
        Binder binder = Binder.get(env);
        binder.bind(key, Bindable.ofInstance(dataSource));
    }
}
