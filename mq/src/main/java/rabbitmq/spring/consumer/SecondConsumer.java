package rabbitmq.spring.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: zhouchao
 * @Date: 2021/10/25 19:26
 * @Description:
 */
@Component
@RabbitListener(queues = "${com.zhouchao.secondqueue}", containerFactory = "rabbitListenerContainerFactory")
public class SecondConsumer {
    @RabbitHandler
    public void process(String msgContent, Channel channel, Message message) throws IOException {
        System.out.println("Second Queue received msg:" + msgContent);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
