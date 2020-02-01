package scheduler.config;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import scheduler.dao.SysJobMapper;
import scheduler.domain.SysJob;
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

    @Autowired
    private MyJobFactory myJobFactory;

    @Override
    public void run(String... args) throws Exception {
        Map<String, String> map = new HashMap();
        List<SysJob> jobList = sysJobMapper.selectList(new QueryWrapper<SysJob>()
                .eq("job_Status", "1"));

        if (CollectionUtils.isEmpty(jobList)) log.info("系统启动，没有需要执行的任务");

        Scheduler scheduler = SchedulerUtils.getScheduler();
        // 如果不设置JobFactory，Service注入到Job会报空指针
        scheduler.setJobFactory(myJobFactory);
        // 启动调度器
        scheduler.start();
        for (SysJob sysJob : jobList) {
            String jobClassName = sysJob.getJobName();
            String jobGroupName = sysJob.getJobGroup();

            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(SchedulerUtils.getClass(sysJob.getJobClassPath()).getClass()).build();

            if (StringUtils.isNotEmpty(sysJob.getJobDataMap())) {
                JSONObject jb = JSONObject.parseObject(sysJob.getJobDataMap());
                Map<String, Object> dataMap = (Map<String, Object>) jb.get("data");
                for (Map.Entry<String, Object> m : dataMap.entrySet()) {
                    jobDetail.getJobDataMap().put(m.getKey(), m.getValue());
                }
            }

            //表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getJobCron());
            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
                    .withSchedule(scheduleBuilder).startNow().build();

            // 任务不存在的时候才添加
            if (!scheduler.checkExists(jobDetail.getKey())) {
                try {
                    scheduler.scheduleJob(jobDetail, trigger);
                } catch (SchedulerException e) {
                    log.info("创建定时任务失败"+e);
                    throw new Exception("创建定时任务失败");
                }
            }
        }
    }
}
