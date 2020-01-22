package scheduler.controller;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import scheduler.service.SysJobService;

/**
 * @Author zhouchao
 * @Date 2020/1/22 10:50
 * @Description
 **/
@Slf4j
@RestController
public class QuartzController {

    @Autowired
    private JobDetail jobDetail;

    @Autowired
    private Trigger trigger;

    @Autowired
    private SysJobService sysJobService;

    @GetMapping("start")
    public String start() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        String result = "success";
        return result;
    }

    @GetMapping("change/status/{id}")
    public String changeStatus(@PathVariable("id") Integer id) throws Exception {
        log.info("开始变更定时任务状态");

        if (id == null) throw new Exception("id不能为空");

        sysJobService.changeStatus(id);

        return "success";
    }


}
