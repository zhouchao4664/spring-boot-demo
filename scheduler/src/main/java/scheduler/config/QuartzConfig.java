package scheduler.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * @Author zhouchao
 * @Date 2020/1/22 10:38
 * @Description
 **/
//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(MyJob1.class)
                .withIdentity("QuartzJob")
                .usingJobData("zhouchao","呵呵哒")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        return TriggerBuilder.newTrigger()
                .withIdentity("QuartzJob")
                .forJob(printTimeJobDetail())
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}
