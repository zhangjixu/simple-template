package com.cn.template.service.impl;

import com.cn.template.dao.impl.OrderDaoImpl;
import com.cn.template.entity.Order;
import com.cn.template.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 2:09 PM
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDaoImpl orderDaoImpl;

    @Override
    public List<Order> queryAllOrder() {
        return orderDaoImpl.queryAllOrder();
    }

    @Override
    public void updateOrder(Order order) {
        orderDaoImpl.updateOrder(order);
    }

    @Override
    public void addOrder(Order order) {
        orderDaoImpl.addOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDaoImpl.deleteOrder(order);
    }
}
