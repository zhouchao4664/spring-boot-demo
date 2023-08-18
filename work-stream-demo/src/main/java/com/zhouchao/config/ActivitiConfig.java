package com.zhouchao.config;

import org.flowable.engine.ProcessEngine;
import org.flowable.image.impl.DefaultProcessDiagramGenerator;
import org.flowable.spring.SpringExpressionManager;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class ActivitiConfig {

    @Bean
    public ProcessEngine processEngine(DataSourceTransactionManager transactionManager, DataSource dataSource,
                                       ApplicationContext context) throws IOException {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        //自动部署已有的流程文件
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(ResourceLoader.CLASSPATH_URL_PREFIX + "/process/*.bpmn*");
        configuration.setTransactionManager(transactionManager);
        configuration.setDataSource(dataSource);
        configuration.setDeploymentResources(resources);
        configuration.setDeploymentMode("single-resource");
        configuration.setDatabaseSchemaUpdate("false");
        configuration.setExpressionManager(new SpringExpressionManager(context, null));
        configuration.setProcessDiagramGenerator(new DefaultProcessDiagramGenerator());
        ProcessEngine processEngine = configuration.buildProcessEngine();
        return processEngine;
    }

}