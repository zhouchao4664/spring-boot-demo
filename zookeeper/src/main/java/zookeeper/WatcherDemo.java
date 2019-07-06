package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 2019/3/11
 * zhouchao
 */
public class WatcherDemo {
    public static void main(String[] args) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper =
                    new ZooKeeper("192.168.233.201:218,192.168.233.202:2181,192.168.233.203:2181",
                            4000, (event) -> {
                        System.out.println("默认事件"+event.getType());

                        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                            countDownLatch.countDown();
                        }
                    });
            countDownLatch.await();

            zooKeeper.create("/zk-persis-zhouchao","1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            // exists getdata getchildren
            // 通过exists绑定事件
            Stat stat = zooKeeper.exists("/zk-persis-zhouchao", (event) -> {
                System.out.println(event.getType() + "->" +event.getPath());
                try {
                    zooKeeper.exists(event.getPath(),true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // 通过修改的事物类型操作来触发监听事件
            stat = zooKeeper.setData("/zk-persis-zhouchao","2".getBytes(),stat.getVersion());

            Thread.sleep(1000);

            zooKeeper.delete("/zk-persis-zhouchao",stat.getVersion());

            System.in.read();

            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
