package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @Author zhouchao
 * @Date 2020/1/21 11:01
 * @Description
 **/

public class TimerTaskTest extends TimerTask {
    @Override
    public void run() {
        Date executeTime = new Date(this.scheduledExecutionTime());
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("任务执行了："+dateStr);
    }
}
