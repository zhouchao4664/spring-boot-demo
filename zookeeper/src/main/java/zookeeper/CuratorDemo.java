package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 2019/3/11
 * zhouchao
 */
public class CuratorDemo {
    public static void main(String[] args) {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder().connectString("192.168.233.201:2181,192.168.233.202:2181,192.168.233.203:2181")
                        .sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(1000, 3))
                        .namespace("curator").build();
        curatorFramework.start();
    }
}
