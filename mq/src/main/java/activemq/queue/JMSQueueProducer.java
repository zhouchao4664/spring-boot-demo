package activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 2019/4/2
 * zhouchao
 */
public class JMSQueueProducer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.233.209:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            //创建目的地
            Destination destination = session.createQueue("myQueue");
            //创建发送者
            MessageProducer messageProducer = session.createProducer(destination);
            //创建需要发送的消息
            TextMessage message = session.createTextMessage("Hello World");
            messageProducer.send(message);

            session.commit();
            session.close();

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection == null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
