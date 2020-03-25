package com.cn.template.dao.impl;

import com.cn.template.dao.OrderDao;
import com.cn.template.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/03 10:29 PM
 * @Description:
 * @Version: 1.0.0
 */
@Repository
public class OrderDaoImpl2 implements OrderDao {
    @Override
    public List<Order> queryAllOrder() {
        System.out.println("调用成功");
        return null;
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void deleteOrder(Order order) {

    }
}
