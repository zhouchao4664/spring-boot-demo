package rabbitmq.spring.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import rabbitmq.spring.entity.Merchant;

/**
 * @Author: zhouchao
 * @Date: 2021/10/25 19:18
 * @Description:
 */
@Component
@RabbitListener(queues = "${com.zhouchao.firstqueue}", containerFactory = "rabbitListenerContainerFactory")
public class FirstConsumer {

    @RabbitHandler
    public void process(@Payload Merchant merchant) {
        System.out.println("First Queue received msg:" + merchant.getName());
    }
}
