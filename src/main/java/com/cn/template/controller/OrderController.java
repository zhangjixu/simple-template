package com.cn.template.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.template.entity.Order;
import com.cn.template.entity.ResultSet;
import com.cn.template.service.impl.OrderServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 2:05 PM
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping(value = "/queryAllOrder", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public Object queryAllOrder() {
        ResultSet resultSet = new ResultSet();

        try {
            List<Order> orders = orderServiceImpl.queryAllOrder();
            resultSet.setCode(100);
            resultSet.setResult(orders);
        } catch (Exception e) {
            resultSet.setCode(101);
            resultSet.setMessage("异常信息为 " + e.getMessage());
            LOGGER.error("", e.getMessage());
        }

        return resultSet;
    }


    @RequestMapping(value = "/addOrder", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object addOrder(@RequestBody String params) {
        ResultSet resultSet = new ResultSet();
        try {

            JSONObject json = JSONObject.parseObject(params);
            Integer orderId = json.getInteger("orderId");
            String goods = json.getString("goods");
            Double price = json.getDouble("price");

            if (StringUtils.isBlank(goods)) {
                resultSet.setCode(102);
                resultSet.setMessage("有必填字段为空");
                return resultSet;
            }

            Order order = new Order(orderId, goods, price);
            orderServiceImpl.addOrder(order);

            resultSet.setCode(100);
            resultSet.setResult("增加成功");

        } catch (Exception e) {
            resultSet.setCode(101);
            resultSet.setMessage("异常信息为 " + e.getMessage());
            LOGGER.error("", e.getMessage());
        }
        return resultSet;
    }

    @RequestMapping(value = "/updateOrder", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object updateOrder(@RequestBody String params) {
        ResultSet resultSet = new ResultSet();
        try {

            JSONObject json = JSONObject.parseObject(params);
            String goods = json.getString("goods");
            Double price = json.getDouble("price");

            if (StringUtils.isBlank(goods)) {
                resultSet.setCode(102);
                resultSet.setMessage("有必填字段为空");
                return resultSet;
            }

            Order order = new Order();
            order.setGoods(goods);
            order.setPrice(price);

            orderServiceImpl.updateOrder(order);
            resultSet.setCode(100);
            resultSet.setResult("更新成功");

        } catch (Exception e) {
            resultSet.setCode(101);
            resultSet.setMessage("异常信息为 " + e.getMessage());
            LOGGER.error("", e.getMessage());
        }
        return resultSet;
    }

    @RequestMapping(value = "/deleteOrder", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteOrder(@RequestBody String params) {
        ResultSet resultSet = new ResultSet();
        try {

            JSONObject json = JSONObject.parseObject(params);
            Integer orderId = json.getInteger("orderId");
            if (orderId == null) {
                resultSet.setCode(102);
                resultSet.setMessage("有必填字段为空");
                return resultSet;
            }

            Order order = new Order();
            order.setOrderId(orderId);
            orderServiceImpl.deleteOrder(order);
            resultSet.setCode(100);
            resultSet.setResult("删除成功");
        } catch (Exception e) {
            resultSet.setCode(101);
            resultSet.setMessage("异常信息为 " + e.getMessage());
            LOGGER.error("", e.getMessage());
        }
        return resultSet;
    }

}
