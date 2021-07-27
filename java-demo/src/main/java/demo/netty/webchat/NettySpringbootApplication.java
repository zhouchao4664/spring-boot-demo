package demo.netty.webchat;

import demo.netty.webchat.netty.NettyWebSocketServer;
import org.apache.xmlbeans.impl.tool.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 17:56
 * @Description:
 */
@SpringBootApplication
public class NettySpringbootApplication implements CommandLineRunner {

    @Autowired
    private NettyWebSocketServer nettyWebSocketServer;

    public static void main(String[] args) {
        SpringApplication.run(NettySpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(nettyWebSocketServer).start();
    }
}
