package com.zhouchao.handler.taobao;

import com.zhouchao.dao.ScoreMapper;
import com.zhouchao.domain.Score;
import com.zhouchao.handler.com.zhouchao.handler.PlatformHandler;
import com.zhouchao.properties.KeywordConfigProperties;
import com.zhouchao.utils.SimHashUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhouchao
 * @Date: 2021/06/15 12:19
 * @Description:
 */
@Component
@Slf4j
public class TaobaoHandler implements PlatformHandler {

    public static boolean isLogin = false;

    @Autowired
    private KeywordConfigProperties keywordConfigProperties;

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> crawl(String keyword) {
        List<Score> scoreList = new ArrayList<>();

        String urlPrefix = "https://s.taobao.com/search?q=%s&imgfile=&js=1&stats_click=search_radio_all&initiative_id=staobaoz_20210615&ie=utf8";
        String url = String.format(urlPrefix, keyword);
        log.info("请求地址：{}", url);
        try {
//            if (!isLogin){
//                login();
//            }

            Document doc = Jsoup.connect(url).get();
            log.info(doc.title());
            Elements elements = doc.select("//div[@id='mainsrp-itemlist']//div[@class='row row-2 title']/a");

            for (int i = 0; i < elements.size() && i < keywordConfigProperties.getSize(); i++) {
                Element element = elements.get(i);
                log.info(element.text());
                Score score = new Score();
                score.setKeyword(keyword);
                score.setTitle(element.text());
                score.setMatching(SimHashUtil.getSemblance(keyword, element.text()));
                scoreMapper.insert(score);
                scoreList.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scoreList;
    }

    private void login() {
        String username = "hunter_zhouchao";
        String password = "hunter_zhouchao";
        String URL="https://login.taobao.com/newlogin/login.do?appName=taobao&fromSite=0&_bx-v=2.0.31";
    }
}
