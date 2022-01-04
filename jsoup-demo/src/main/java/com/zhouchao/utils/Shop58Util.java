package com.zhouchao.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zhouchao
 * @Date: 2022/01/03 17:15
 * @Description:
 */
@Slf4j
public class Shop58Util {

    private final static Pattern pattern = Pattern.compile("houseId=(\\d+)");

    public static String getHouseId(String url){
        Matcher matcher = pattern.matcher(url);
        String houseId = null;
        if (matcher.find()) {
            houseId = matcher.group(1);
            log.info("爬取房源id为 {} 的商铺", houseId);
        }
        return houseId;
    }

}
