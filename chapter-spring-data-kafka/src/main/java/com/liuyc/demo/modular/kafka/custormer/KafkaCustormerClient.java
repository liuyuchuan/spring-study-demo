package com.liuyc.demo.modular.kafka.custormer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * <p> KafkaCustormer </p>
 * kafka消息消费者客户端
 * @author Aion.Liu
 * @version v1.0.0
 * @since 2020/8/31 10:08 上午
 */
public class KafkaCustormerClient {

    /**
     * broker of kafka
     */
    public static final String BROKER_LIST = "localhost:9092";

    /**
     * topic of kafka
     */
    public static final String TOPIC = "topic_demo";

    /**
     * group of kafka
     */
    public static final String GROUP_ID = "group.demo";


    public static void main(String[] args) {
        /**
         * 使用ConsumerConfig设定配置信息
         */
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        // 设置消费者组名称
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);

        // 配置消费者客户端参数并创建kafkaConsumer实例
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);

        // 订阅生产者主题
        kafkaConsumer.subscribe(Collections.singletonList(TOPIC));

        // 循环获取消息内容|模拟监听，监听生产者是否生产了消息
        while (true) {
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : consumerRecords) {
                System.out.println(record.key() + "|……|" + record.value());
            }
        }

        //
    }

}
