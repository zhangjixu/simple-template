package com.cn.template.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Producer {

    private static Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    /************************ 加载配置文件 ************************/
    private static Properties producerProperties = new Properties();

    static {
        try (InputStream resourceAsStream = Producer.class.getResourceAsStream("/config/kafka.properties");) {
            producerProperties.load(resourceAsStream);
            LOGGER.info("加载配置文件 kafka.properties");
        } catch (IOException e) {
            LOGGER.error("加载配置文件 kafka.properties 异常", e);
            System.exit(1);
        }
    }

    private static String bootstrapServers = producerProperties.getProperty("bootstrap.servers");
    private static String acks = producerProperties.getProperty("acks");
    private static String retries = producerProperties.getProperty("retries");
    private static String batchSize = producerProperties.getProperty("batch.size");
    private static String lingerMs = producerProperties.getProperty("linger.ms");
    private static String bufferMemory = producerProperties.getProperty("buffer.memory");
    private static String keySerializer = producerProperties.getProperty("key.serializer");
    private static String valueSerializer = producerProperties.getProperty("value.serializer");

    private org.apache.kafka.clients.producer.Producer producer;

    public Producer() {
        Properties props = new Properties();

        props.put("bootstrap.servers", bootstrapServers);
        props.put("acks", acks);
        props.put("retries", retries);
        props.put("batch.size", batchSize);
        props.put("linger.ms", lingerMs);
        props.put("buffer.memory", bufferMemory);
        props.put("key.serializer", keySerializer);
        props.put("value.serializer", valueSerializer);

        producer = new KafkaProducer<>(props);
    }

    public void doWork(JSONObject json, String topicName) {
        producer.send(new ProducerRecord<>(topicName, json.toJSONString()));
        producer.close();
        LOGGER.warn("生产消息成功");
    }
}