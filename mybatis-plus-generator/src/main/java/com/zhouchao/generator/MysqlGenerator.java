package com.zhouchao.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author zhouchao
 * @since 2021-05-31
 */
public class MysqlGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 全局配置
     *
     * @return
     */
    public static GlobalConfig globalConfig(String projectPath) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zhouchao");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        return gc;
    }

    /**
     * 数据源配置
     *
     * @return
     */
    public static DataSourceConfig dataSourceConfig() {
        // 获取文件流
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("application.properties");
        Properties prop = new Properties();
        //加载格式化后的流
        try {
            prop.load(new InputStreamReader(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = prop.getProperty("datasource.url");
        String username = prop.getProperty("datasource.username");
        String password = prop.getProperty("datasource.password");

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        return dsc;
    }

    /**
     * 包配置
     *
     * @return
     */
    public static PackageConfig packageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.zhouchao");
        pc.setMapper("dao");
        pc.setEntity("domain");
        return pc;
    }

    /**
     * 自定义配置
     *
     * @return
     */
    public static InjectionConfig injectionConfig(String projectPath, PackageConfig pc) {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/myMapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 模板配置
     *
     * @return
     */
    public static TemplateConfig templateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("/templates/myEntity.java");
        templateConfig.setXml(null);
        return templateConfig;
    }

    /**
     * 策略配置
     *
     * @return
     */
    public static StrategyConfig strategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.raydata.baike.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        //strategy.setSuperControllerClass("com.raydata.baike.common.BaseController");
        strategy.setInclude(scanner("表名"));
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setRestControllerStyle(true);
        return strategy;
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String projectPath = System.getProperty("user.dir");
        // 全局配置
        GlobalConfig gc = globalConfig(projectPath);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = dataSourceConfig();
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = packageConfig();
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = injectionConfig(projectPath, pc);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = templateConfig();
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = strategyConfig();
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
