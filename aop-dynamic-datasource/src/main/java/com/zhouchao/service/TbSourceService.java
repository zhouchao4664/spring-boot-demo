package com.zhouchao.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhouchao.dao.TbSourceMapper;
import com.zhouchao.domain.TbSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouchao
 * @since 2021-04-25
 */
@Service
public class TbSourceService extends ServiceImpl<TbSourceMapper, TbSource> {

    @Autowired
    private TbSourceMapper tbSourceMapper;

    public List<TbSource> getTbSource() {
        return tbSourceMapper.selectList(new QueryWrapper<>());
    }
}
