package demo.base;

import com.sun.management.OperatingSystemMXBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;

/**
 * @Author zhouchao
 * @Date 2021/2/4 11:09
 * @Description
 **/
@Slf4j
public class RunTimeDemo {

    private static final int CPUTIME = 500;
    private static final int PERCENT = 100;
    private static final int FAULTLENGTH = 10;


    private final static Runtime runtime = Runtime.getRuntime();

    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public static void main(String[] args) {
        RunTimeDemo runTimeDemo = new RunTimeDemo();

        Resource memory = runTimeDemo.getMemory();
        String CPUPers = runTimeDemo.getCPU();

        System.out.println(CPUPers);
    }

    private Resource getMemory() {
        Resource memory = new Resource(runtime.freeMemory(), (runtime.totalMemory() - runtime.freeMemory()), runtime.totalMemory());
        return memory;
    }

    private String getCPU() {
        double CPUPers = osmxb.getProcessCpuLoad();
        CPUPers = new BigDecimal(CPUPers).multiply(new BigDecimal(100)).doubleValue();
        return CPUPers+"%";
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Resource {
        private long free;
        private long used;
        private long total;
    }
}
