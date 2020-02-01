package scheduler.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduler.dao.SysJobMapper;
import scheduler.domain.SysJob;
import scheduler.utils.Constant;
import scheduler.utils.SchedulerUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qhy
 * @since 2020-01-22
 */
@Service
public class SysJobService extends ServiceImpl<SysJobMapper, SysJob> {

    @Autowired
    private SysJobMapper sysJobMapper;

    public int changeStatus(Integer id) throws Exception {
        SysJob sysJob = sysJobMapper.selectById(id);
        if (sysJob == null) return 0;

        //如果是现在是启用，则停用
        if (Constant.JOB_STATE.YES == sysJob.getJobStatus()) {
            sysJob.setJobStatus(Constant.JOB_STATE.NO);
            Boolean result = SchedulerUtils.isResume(sysJob.getJobName(), sysJob.getJobGroup());
            if (result) SchedulerUtils.jobdelete(sysJob.getJobName(), sysJob.getJobGroup());
        }

        //如果现在是停用，则启用
        if (Constant.JOB_STATE.NO == sysJob.getJobStatus()) {
            sysJob.setJobStatus(Constant.JOB_STATE.YES);
            Boolean result = SchedulerUtils.jobresume(sysJob.getJobName(), sysJob.getJobGroup());
            //存在则激活，不存在则添加
            if (result) {
                SchedulerUtils.jobresume(sysJob.getJobName(), sysJob.getJobGroup());
            } else {
                SchedulerUtils.addJob(sysJob.getJobClassPath(), sysJob.getJobName(), sysJob.getJobGroup(), sysJob.getJobCron(), sysJob.getJobDataMap());
            }
        }
        sysJobMapper.updateById(sysJob);
        return 1;
    }
}
