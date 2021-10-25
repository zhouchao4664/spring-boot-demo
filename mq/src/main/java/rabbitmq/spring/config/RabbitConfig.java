package rabbitmq.spring.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhouchao
 * @Date: 2021/10/25 18:54
 * @Description:
 */
@Configuration
public class RabbitConfig {
    @Value("${com.zhouchao.firstqueue}")
    private String firstqueue;

    @Value("${com.zhouchao.secondqueue}")
    private String secondqueue;

    @Value("${com.zhouchao.thirdqueue}")
    private String thirdqueue;

    @Value("${com.zhouchao.fourthqueue}")
    private String fourthqueue;

    @Value("${com.zhouchao.directexchange}")
    private String directexchange;

    @Value("${com.zhouchao.directexchange}")
    private String topicexchange;

    @Value("${com.zhouchao.directexchange}")
    private String fanouthexchange;


    @Bean("firstQueue")
    public Queue getFirstQueue(){
        return new Queue(firstqueue);
    }

    @Bean("secondQueue")
    public Queue getSecondQueue(){
        return new Queue(secondqueue);
    }

    @Bean("thirdQueue")
    public Queue getThirdQueue(){
        return new Queue(thirdqueue);
    }

    @Bean("fourthQueue")
    public Queue getFourthQueue(){
        return new Queue(fourthqueue);
    }

    @Bean("directExchange")
    public DirectExchange getDirectExchange(){
        return new DirectExchange(directexchange);
    }

    @Bean("topicExchange")
    public TopicExchange getTopicExchange(){
        return new TopicExchange(topicexchange);
    }

    @Bean("fanoutExchange")
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange(fanouthexchange);
    }

    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue,@Qualifier("directExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("zhouchao.first");
    }

    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue,@Qualifier("topicExchange") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("zhouchao.second");
    }

    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindFourth(@Qualifier("fourthQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
