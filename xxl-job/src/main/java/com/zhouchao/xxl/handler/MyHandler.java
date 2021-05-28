package com.zhouchao.xxl.handler;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @Author: zhouchao
 * @Date: 2021/05/28 17:17
 * @Description:
 */
@Component
public class MyHandler {


    @XxlJob(value = "my-handler", init = "init", destroy = "destroy")
    public void execute() {
        System.out.println("执行xxl-job。。。");
    }

    /**
     * init handler, invoked when JobThread init
     */
    public void init() {
        System.out.println("任务初始化。。。");
    }

    /**
     * destroy handler, invoked when JobThread destroy
     */
    public void destroy() {
        System.out.println("任务销毁。。。");
    }
}


