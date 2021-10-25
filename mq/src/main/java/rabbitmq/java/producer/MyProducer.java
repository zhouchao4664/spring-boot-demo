package rabbitmq.java.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: zhouchao
 * @Date: 2021/10/25 11:07
 * @Description:
 */
public class MyProducer {

    private static final String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private static final String QUEUE_NAME = "SIMPLE_QUEUE";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        // 连接ip
        factory.setHost("192.168.233.102");
        // 默认监听端口
        factory.setPort(5672);
        // 虚拟机
        factory.setVirtualHost("/");

        // 设置访问的用户
        factory.setUsername("admin");
        factory.setPassword("admin");

        // 建立连接
        Connection connection = factory.newConnection();
        // 创建消息通道
        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, false, false, null);

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "zhouchao.first");

        String msg = "Hello World";

        channel.basicPublish(EXCHANGE_NAME, "zhouchao.first", null, msg.getBytes());
        channel.close();
        connection.close();
    }

}
