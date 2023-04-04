package com.zhouchao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhouchao.domain.TestOrder;
import com.zhouchao.domain.TestUser;
import com.zhouchao.mapper.TestUserMapper;
import com.zhouchao.service.ITestOrderService;
import com.zhouchao.service.ITestUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootTest
class ApplicationTests {

    @Resource
    private ITestUserService testUserService;

    @Resource
    private ITestOrderService testOrderService;

    @Ignore
    void contextLoads() {
        Random random = new Random();
        List<TestUser> testUserList = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            TestUser user = new TestUser();
            user.setUsername(RandomStringUtils.randomAlphanumeric(7));
            user.setAge(random.nextInt(80));
            user.setAddress(RandomStringUtils.randomAlphanumeric(20));
            user.setHeight(random.nextDouble());
            user.setWeight(random.nextDouble());
            testUserList.add(user);
        }
        log.info("开始存入数据。。。");
        testUserService.saveBatch(testUserList);
    }

    @Ignore
    void testMybatis() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        TestUserMapper mapper = sqlSession.getMapper(TestUserMapper.class);

        List<TestUser> userList = mapper.selectList(new QueryWrapper<>());

        userList.forEach(System.out::println);
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void testTansactional() {
        TestUser user = new TestUser();
        user.setId(1);
        user.setUsername("樊华");
        user.setHeight(1.8);
        user.setWeight(100.12);
        user.setAge(36);
        user.setPhone("150012312345");
        user.setAddress("北京市朝阳区什么什么破地方");

        TestOrder order = new TestOrder();
        order.setUserId(1);
        order.setTotalPrice(BigDecimal.ONE);
        order.setPaymentPrice(BigDecimal.ONE);
        order.setPaymentDate(LocalDateTime.now());
        order.setOrderTitle("买坨屎");
        order.setCreateDate(LocalDateTime.now());

        testUserService.updateUser(user);

        testOrderService.saveOrder(order);

        System.out.println("炸弹！！！");
        System.out.println(1/0);

    }

}
