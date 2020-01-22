package scheduler.utils;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author zhouchao
 * @Date 2020/1/22 17:12
 * @Description
 **/

public class SchedulerUtils {

    /**
     * 恢复一个定时任务
     *
     * @param jobName
     * @param jobGroupName
     * @throws SchedulerException
     */
    public static void jobResume(String jobName, String jobGroupName) throws SchedulerException {
        Scheduler scheduler = getScheduler();
        scheduler.resumeJob(JobKey.jobKey(jobName, jobGroupName));
    }

    /**
     * 删除一个定时任务
     *
     * @param jobName
     * @param jobGroupName
     * @throws SchedulerException
     */
    public static void jobDelete(String jobName, String jobGroupName) throws SchedulerException {
        Scheduler scheduler = getScheduler();
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, jobGroupName));
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
    }

    /**
     * 更新定时任务
     *
     * @param jobName
     * @param jobGroupName
     * @param cronExpression
     * @throws SchedulerException
     */
    public static void jobUpdate(String jobName, String jobGroupName, String cronExpression) throws SchedulerException {
        Scheduler scheduler = getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        trigger = trigger.getTriggerBuilder()
                .withIdentity(triggerKey)
                .withSchedule(cronScheduleBuilder)
                .startNow()
                .build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }

    public static Scheduler getScheduler() throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        return scheduler;
    }

}
