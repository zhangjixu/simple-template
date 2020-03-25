package com.cn.template.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.template.entity.ResultSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 2:34 PM
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Test
    public void testQueryAllOrder() {
        ResultSet resultSet = (ResultSet) orderController.queryAllOrder();
        System.out.println("\n" + resultSet);
    }

    @Test
    public void testAddOrder() {
        JSONObject json = new JSONObject();
        json.put("goods", "香蕉");
        json.put("price", 0.12);
        json.put("orderId", 20200302);
        ResultSet resultSet = (ResultSet) orderController.addOrder(json.toJSONString());
        System.out.println("\n" + resultSet);
    }


    @Test
    public void testUpdateOrder() {
        JSONObject json = new JSONObject();
        json.put("goods", "香蕉");
        json.put("price", 1.23);
        ResultSet resultSet = (ResultSet) orderController.updateOrder(json.toJSONString());
        System.out.println("\n" + resultSet);

    }


    @Test
    public void testDeleteOrder() {
        JSONObject json = new JSONObject();
        json.put("orderId", 20200302);
        ResultSet resultSet = (ResultSet) orderController.deleteOrder(json.toJSONString());
        System.out.println("\n" + resultSet);
    }

}
