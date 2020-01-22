package scheduler.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import scheduler.dao.SysJobMapper;
import scheduler.domain.SysJob;
import scheduler.service.SysJobService;
import scheduler.utils.SchedulerUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2020/1/22 17:40
 * @Description
 **/
@Slf4j
@Component
public class InitStartScheduler implements CommandLineRunner {
    @Autowired
    private SysJobMapper sysJobMapper;


    @Override
    public void run(String... args) throws Exception {
        Map<String, String> map = new HashMap();
        List<SysJob> jobList = sysJobMapper.selectList(new QueryWrapper<SysJob>()
                .eq("job_Status", "1"));

        if (CollectionUtils.isEmpty(jobList)) log.info("系统启动，没有需要执行的任务");

        Scheduler scheduler = SchedulerUtils.getScheduler();

//        scheduler.setJobFactory();

        for (SysJob sysJob : jobList) {
            String jobClassName = sysJob.getJobName();
            String jobGroupName = sysJob.getJobGroup();

            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(getClass(sysJob.getJobClassPath()).getClass()).build();
        }
    }

    public static Job getClass(String className) {

        return null;
    }
}
