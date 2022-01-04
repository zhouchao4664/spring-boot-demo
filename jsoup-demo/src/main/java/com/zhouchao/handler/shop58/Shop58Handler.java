package com.zhouchao.handler.shop58;

import com.zhouchao.dao.ShopMapper;
import com.zhouchao.domain.Shop;
import com.zhouchao.utils.Shop58Util;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

/**
 * @Author: zhouchao
 * @Date: 2022/01/01 13:11
 * @Description:
 */
@Slf4j
@Component
public class Shop58Handler {

    @Autowired
    private ShopMapper shopMapper;

    public void crawl(String url) {
        try {
            Random random = new Random();
            long sleepTime = 10000 + random.nextInt(20000);
            log.info("请求路径：{}，休眠 {} 毫秒", url, sleepTime);
            Thread.sleep(sleepTime);
            Document doc = Jsoup.connect(url).get();
            log.info(doc.title());
            Element elementTitle = doc.selectFirst("div[class='main-wrap']").select("div[class='house-title']").select("h1").first();
            String title = elementTitle != null ? elementTitle.text() : "";

            Element elementAddress = doc.select("#mapWrap").select("p[class='addr']").first();
            String address = elementAddress != null ? elementAddress.text() : "";

            Element elementInfo = doc.select("#intro > ul").select("li:contains(月租)").select("span[class='content']").first();
            String price = elementInfo != null ? elementInfo.text() : "";

            Shop shop = new Shop();
            shop.setHouseId(Shop58Util.getHouseId(url));
            shop.setShopName(title);
            shop.setAddress(address);
            shop.setPrice(price);
            shop.setUrl(url);
            shopMapper.insert(shop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
