package com.zhouchao.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author zhouchao
 * @Date 2021/4/22 15:49
 * @Description
 **/

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> DATA_SOURCE_KEY = new ThreadLocal<>();

    public static void setDataSourceKey(String dataSourceKey){
        DATA_SOURCE_KEY.set(dataSourceKey);
    }

    public static String getDataSourceKey() {
        return DATA_SOURCE_KEY.get();
    }

    public static void clearDataSourceKey(){
        DATA_SOURCE_KEY.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceKey();
    }
}
