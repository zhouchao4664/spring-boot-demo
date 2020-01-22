package scheduler.controller;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhouchao
 * @Date 2020/1/22 10:50
 * @Description
 **/
@RestController
public class QuartzController {

    @Autowired
    private JobDetail jobDetail;

    @Autowired
    private Trigger trigger;

    @GetMapping("start")
    public String start() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        String result = "success";
        return result;
    }


}
