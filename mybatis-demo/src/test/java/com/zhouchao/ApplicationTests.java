package com.zhouchao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhouchao.domain.TestUser;
import com.zhouchao.mapper.TestUserMapper;
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

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootTest
class ApplicationTests {

    @Resource
    private ITestUserService testUserService;

    @Test
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

}
