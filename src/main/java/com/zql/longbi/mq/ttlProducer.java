package com.zql.longbi.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ttlProducer {

  private final static String QUEUE_NAME = "ttl_queue";

  public static void main(String[] argv) throws Exception {
    //创建连接工厂
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
//        factory.setUsername();
//        factory.setPassword();
//        factory.setPort();
    // 建立连接、创建频道
    try(Connection connection = factory.newConnection();
    Channel channel = connection.createChannel()) {
//      // 创建消息队列
//      Map<String, Object> args = new HashMap<String, Object>();
//      args.put("x-message-ttl", 10000);
//      channel.queueDeclare(QUEUE_NAME, false, false, false, args);
    //发送消息
    String message = "Hello World!";
    AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
            .expiration("20000")
            .build();
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);

    channel.basicPublish("", QUEUE_NAME, properties, message.getBytes(StandardCharsets.UTF_8));
    System.out.println(" [x] Sent '" + message + "'");
    }
  }
}