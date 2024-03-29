package com.zhouchao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.dao.ShopMapper;
import com.zhouchao.domain.Shop;
import com.zhouchao.handler.shop58.Shop58Handler;
import com.zhouchao.service.IShopService;
import com.zhouchao.utils.Shop58Util;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouchao
 * @since 2022-01-01
 */
@Slf4j
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Autowired
    private Shop58Handler shop58Handler;

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public void crawl(String url) {

        log.info("请求地址：{}", url);
        try {
            Document doc = Jsoup.connect(url).get();
            log.info(doc.title());
            Elements elements = doc.select("#house-list-wrap").select("li").select("a");

            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                String href = element.attr("href");
                String houseId = Shop58Util.getHouseId(href);
                if (!StringUtils.isEmpty(houseId)) {
                    Shop shop = shopMapper.selectOne(new QueryWrapper<Shop>().lambda().eq(Shop::getHouseId, houseId));
                    if (shop != null) {
                        continue;
                    }
                }

                shop58Handler.crawl(href);
            }

            // 下一页
            Element nextPage = doc.select("div[class='pager']").select("a[class='next']").first();
            if (nextPage == null) {
                return;
            }

            String href = nextPage.attr("href");
            crawl(href);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
