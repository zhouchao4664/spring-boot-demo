package quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author zhouchao
 * @Date 2020/1/21 14:24
 * @Description
 **/

public class MyJob1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println(sdf.format(date) + "-" + "任务1执行了，" + dataMap.getString("zhouchao") + "-" + Thread.currentThread().getName());
    }
}
