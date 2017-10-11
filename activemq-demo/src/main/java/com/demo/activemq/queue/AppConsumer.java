package com.demo.activemq.queue;

/**
 * Created by He on 2017/10/11.
 */

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 队列消费者，用于接收队列生产者发送的消息
 */
public class AppConsumer {

    //activemq服务器地址 61616是activemq默认的端口
    private final static String URL = "tcp://127.0.0.1:61616";
    //创建队列名字
    private final static String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        //1.创建activemq 连接工厂 ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);

        //2.连接实例
        Connection connection = connectionFactory.createConnection();

        //3.启动连接
        connection.start();

        //4.创建会话 session
        //第一个参数意思：是否在事物中进行处理 ，第二个参数是设置应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5.创建发送消息的目的地
        Destination destination = session.createQueue(QUEUE_NAME);

        //6.创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //7.创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;

                try {
                    System.out.println("成功接收消息  "+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
