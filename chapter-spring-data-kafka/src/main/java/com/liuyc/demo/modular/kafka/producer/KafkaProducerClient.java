package com.liuyc.demo.modular.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * <p> KafkaProducer </p>
 * kafka消息生产者客户端
 * @author Aion.Liu
 * @version v1.0.0
 * @since 2020/8/31 10:07 上午
 */
public class KafkaProducerClient {

    /**
     * broker of kafka
     */
    public static final String BROKER_LIST = "localhost:9092";

    /**
     * topic of kafka
     */
    public static final String TOPIC = "topic_demo";


    public static void main(String[] args) {

        // 使用ProducerConfig设定配置信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);

        // 配置生产者客户端参数并创建KafkaProducer实例
        KafkaProducer<String, String> kafkaProducer =
                new KafkaProducer<>(properties);

        // 构建所需要发送的消息
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC, "Hello World!");

        // 发送消息
        try{
            kafkaProducer.send(producerRecord);
        } catch (Exception e) {

        }

        // 关闭生产者客户端通道实例
        kafkaProducer.close();
    }
}
