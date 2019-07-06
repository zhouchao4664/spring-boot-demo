package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 2019/3/11
 * zhouchao
 */
public class ConnectionDemo {
    public static void main(String[] args) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper =
                    new ZooKeeper("192.168.233.201:218,192.168.233.202:2181,192.168.233.203:2181",
                            4000, (event) ->{
                        if (Watcher.Event.KeeperState.SyncConnected == event.getState()){
                            countDownLatch.countDown();
                        }
                    });
            countDownLatch.await();
            System.out.println(zooKeeper.getState());

            //添加节点
            zooKeeper.create("/zk-persis-zhouchao" ,"0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            //得到当前节点的值
            Stat stat = new Stat();
            byte[] data = zooKeeper.getData("/zk-persis-zhouchao",null,stat);
            System.out.println(new String(data));

            //修改节点值
            zooKeeper.setData("/zk-persis-zhouchao","1".getBytes(),stat.getVersion());
            data = zooKeeper.getData("/zk-persis-zhouchao",null,stat);
            System.out.println(new String(data));

            zooKeeper.delete("/zk-persis-zhouchao",stat.getVersion());

            zooKeeper.close();
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
