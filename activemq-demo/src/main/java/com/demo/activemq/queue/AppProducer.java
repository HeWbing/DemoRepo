package com.demo.activemq.queue;

/**
 * Created by He on 2017/10/11.
 */

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息提供者，向消息中间件发送消息
 */
public class AppProducer {

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

        //6.创建生产者
        MessageProducer producer = session.createProducer(destination);

        //7.使用生产者向目的地发送消息

        for (int i = 0 ;i < 100 ;i++){
            //8.创建消息
            TextMessage textMessage = session.createTextMessage("我是第  "+i+"  条消息！");

            //9.使用生产者将消息发送至目的地
            //第一个参数是目的地，第二个参数是 要发送的信息
            producer.send(destination, textMessage);

            System.out.println("成功发送消息： "+textMessage.getText());
        }

        connection.close();
    }
}
