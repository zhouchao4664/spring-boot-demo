package scheduler.controller;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zhouchao
 * @Date 2020/1/22 10:50
 * @Description
 **/
@Controller
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

        return "success";
    }


}
