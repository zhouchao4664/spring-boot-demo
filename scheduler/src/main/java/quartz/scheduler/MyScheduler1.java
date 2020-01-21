package quartz.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import quartz.job.MyJob1;

/**
 * @Author zhouchao
 * @Date 2020/1/21 14:30
 * @Description
 **/

public class MyScheduler1 {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
                .withIdentity("job1", "group1")
                .usingJobData("zhouchao", "20")
                .usingJobData("moon", "5.21F")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();

        Scheduler scheduler = factory.getScheduler();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
