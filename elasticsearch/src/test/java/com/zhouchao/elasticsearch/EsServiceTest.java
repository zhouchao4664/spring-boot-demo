package com.zhouchao.elasticsearch;

import com.zhouchao.elasticsearch.service.EsService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author zhouchao
 * @Description EsService测试类
 * @Date 2022/12/13 19:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EsServiceTest {

    @Resource
    private EsService esService;

    @Test
    public void testCreateIndex() throws IOException {
        esService.testCreateIndex();
    }

    @Ignore
    public void testDeleteIndex() throws IOException {
        esService.testDeleteIndex();
    }

    @Test
    public void testAddDoc() throws IOException {
        esService.testAddDoc();
    }

    @Test
    public void testGetDoc() throws IOException {
        esService.testGetDoc();
    }

    @Test
    public void testSearchAll() throws IOException {
        esService.testSearchAll();
    }
}
