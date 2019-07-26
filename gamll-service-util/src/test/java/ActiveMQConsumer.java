import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQConsumer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
            Queue testa = session.createQueue("testa");
            MessageConsumer consumer = session.createConsumer(testa);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if(message instanceof TextMessage){
                        String text = null;
                        try {
                            text = ((TextMessage) message).getText();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                        System.out.println(text);
                    }

                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
