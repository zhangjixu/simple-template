package com.cn.template.kafka;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 1:35 PM
 * @Description:
 * @Version: 1.0.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class KafkaTest {

    @Test
    public void testConsumerUtils() {
        Consumer consumer = new Consumer();
        consumer.doWork("zjx");
    }

    @Test
    public void testProducerUtils() {
        Producer producer = new Producer();
        JSONObject json = new JSONObject();
        json.put("orderId", 20200301);
        json.put("goods", "苹果");
        json.put("price", 2.5);
        producer.doWork(json, "zjx");
    }

}
