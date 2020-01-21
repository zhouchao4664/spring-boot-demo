package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author zhouchao
 * @Date 2020/1/21 10:57
 * @Description
 **/

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTaskTest();
        timer.schedule(task,5000,1000);
    }

}
