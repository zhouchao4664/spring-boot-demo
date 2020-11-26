package com.zhouchao.elasticsearch.repository;

import com.zhouchao.elasticsearch.domain.Example;
import com.zhouchao.elasticsearch.domain.ExampleExample;
import org.springframework.stereotype.Repository;

/**
 * ExampleMapper继承基类
 */
@Repository
public interface ExampleMapper extends MyBatisBaseDao<Example, Integer, ExampleExample> {

}