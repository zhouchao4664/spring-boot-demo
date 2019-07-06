package demo.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * 2019/3/18
 * zhouchao
 */
public class ProcessIdDemo {
    public static void main(String[] args) {
        getProcessIdBeforeJava9();
        getProcessIdInJava9();
        getProcessIdInJava10();

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        //Instant instant = Instant.ofEpochMilli(runtimeMXBean.getStartTime());
        System.out.println("当前进程启动时间"+ new Date(runtimeMXBean.getStartTime()));
        System.out.println("当前进程上线时间"+ runtimeMXBean.getUptime());
        System.out.println("当前进程线程数量"+ threadMXBean.getThreadCount());

        ManagementFactory.getMemoryManagerMXBeans().forEach(memoryManagerMXBean -> {

        });

        System.exit(0);

        System.out.println("会执行吗？");
    }

    private static void getProcessIdInJava10() {
    }

    private static void getProcessIdInJava9() {
    }

    private static void getProcessIdBeforeJava9() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String name = runtimeMXBean.getName();
        String pid = name.substring(0,name.indexOf("@"));
        System.out.println("[Java 9 之前的方法] 当前进程 ID ："+pid);

    }


}
