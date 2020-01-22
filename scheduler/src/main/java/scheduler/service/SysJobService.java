package scheduler.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduler.dao.SysJobMapper;
import scheduler.domain.SysJob;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qhy
 * @since 2020-01-22
 */
@Service
public class SysJobService extends ServiceImpl<SysJobMapper, SysJob> {

    @Autowired
    private SysJobMapper sysJobMapper;

    public void changeStatus(Integer id) {

        SysJob sysJob = sysJobMapper.selectById(id);



    }
}
