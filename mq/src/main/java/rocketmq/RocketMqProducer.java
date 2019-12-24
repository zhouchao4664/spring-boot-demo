package rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 2019/9/1
 * zhouchao
 */
public class RocketMqProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //事务消息的时候会用到
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("producer_group");

        //他会从命名服务器上拿到broker的地址
        defaultMQProducer.setNamesrvAddr("192.168.233.212:9876");
        defaultMQProducer.start();

        int num = 0;
        while (num < 20) {
            num++;
            Message message = new Message("test_topic", "TagA", ("Hello , RocketMQ:" + num).getBytes());
            SendResult sendResult = defaultMQProducer.send(message);
            System.out.println(sendResult);
        }
    }
}
