package demo.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class UserMBeanDemo {
    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        User user = new User();
        ObjectName objectName = new ObjectName("demo.jmx:type=User");
        mBeanServer.registerMBean(creatUserMBean(user), objectName);
        while (true) {
            Thread.sleep(2000);
            System.out.println(user);
        }
    }

    private static Object creatUserMBean(User user) {
        return new UserManager(user);

    }
}
