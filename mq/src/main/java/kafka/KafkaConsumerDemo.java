package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * 2019/4/19
 * zhouchao
 */
public class KafkaConsumerDemo extends Thread {
    private final KafkaConsumer<Integer, String> consumer;

    public KafkaConsumerDemo(String topic) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.233.210:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaProducerDemo");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        consumer = new KafkaConsumer<Integer, String>(properties);
        consumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public void run() {
        while (true) {
            ConsumerRecords<Integer,String> consumerRecords = consumer.poll(1000);
            for (ConsumerRecord record:consumerRecords) {
                System.out.println("message receive:" + record.value());
            }
        }
    }

    public static void main(String[] args) {
        new KafkaConsumerDemo("test").start();
    }
}
