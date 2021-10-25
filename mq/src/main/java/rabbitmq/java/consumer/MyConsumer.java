package rabbitmq.java.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author: zhouchao
 * @Date: 2021/10/25 10:46
 * @Description:
 */
public class MyConsumer {

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
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "zhouchao.first");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Received message : " + msg);
                System.out.println("consumerTag:" + consumerTag);
                System.out.println("deliveryTag:" + envelope.getDeliveryTag());
            }
        };

        // 开始获取消息
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

}
