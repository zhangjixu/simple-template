package com.cn.template.service;

import com.cn.template.entity.Order;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 12:40 PM
 * @Description:
 * @Version: 1.0.0
 */
public interface OrderService {

    List<Order> queryAllOrder();

    void updateOrder(Order order);

    void addOrder(Order order);

    void deleteOrder(Order order);

}
