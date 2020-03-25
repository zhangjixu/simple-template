package com.cn.template.kafka;


import com.alibaba.fastjson.JSONObject;
import com.cn.template.entity.Order;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    /************************ 加载配置文件 ************************/
    private static Properties consumerProperties = new Properties();

    static {
        try (InputStream resourceAsStream = Consumer.class.getResourceAsStream("/config/kafka.properties");) {
            consumerProperties.load(resourceAsStream);
            LOGGER.info("加载配置文件 kafka.properties");
        } catch (IOException e) {
            LOGGER.error("加载配置文件 kafka.properties 异常", e);
            System.exit(1);
        }
    }

    private static String bootstrapServers = consumerProperties.getProperty("bootstrap.servers");
    private static String groupID = consumerProperties.getProperty("group.id");
    private static String timeOutMs = consumerProperties.getProperty("zookeeper.session.timeout.ms");
    public static String syncTimeMs = consumerProperties.getProperty("zookeeper.sync.time.ms");
    public static String intervalMs = consumerProperties.getProperty("auto.commit.interval.ms");
    public static String offsetReset = consumerProperties.getProperty("auto.offset.reset");
    public static String keyDeserializer = consumerProperties.getProperty("key.deserializer");
    public static String valueDeserializer = consumerProperties.getProperty("value.deserializer");


    private KafkaConsumer<String, String> consumer;


    public Consumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("group.id", groupID);
        props.put("zookeeper.session.timeout.ms", timeOutMs);
        props.put("zookeeper.sync.time.ms", syncTimeMs);
        props.put("auto.commit.interval.ms", intervalMs);
        props.put("auto.offset.reset", offsetReset);
        props.put("key.deserializer", keyDeserializer);
        props.put("value.deserializer", valueDeserializer);
        consumer = new KafkaConsumer<>(props);
    }


    public void doWork(String topicName) {
        try {
            consumer.subscribe(Arrays.asList(topicName));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);

                if (records != null && records.count() > 0) {

                    for (ConsumerRecord<String, String> record : records) {

                        try {
                            JSONObject json = JSONObject.parseObject(record.value());
                            int orderId = json.getInteger("orderId");
                            String goods = json.getString("goods");
                            double price = json.getDouble("price");

                            Order order = new Order(orderId, goods, price);

                            System.out.println(order);

                            consumer.commitSync();

                        } catch (Exception e) {
                            LOGGER.error("exception {} \n {}", e.getMessage(), record);
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(" kafka 消费异常 {} ", e.getMessage());
        } finally {
            consumer.commitSync();
            consumer.close();
        }
    }


}
