package com.cn.template.mybatis;

import com.cn.template.dao.OrderDao;
import com.cn.template.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 4:54 PM
 * @Description:
 * @Version: 1.0.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class MybatisTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testQueryAllOrder() {
        List<Order> list = orderDao.queryAllOrder();
        System.out.println(list);
    }

    @Test
    public void testAddOrder() {
        Order order = new Order(20200301, "苹果", 1.23);
        orderDao.addOrder(order);
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        order.setGoods("苹果");
        order.setPrice(2.1);
        orderDao.updateOrder(order);

    }

    @Test
    public void testDeleteOrder() {
        Order order = new Order();
        order.setOrderId(20200301);
        orderDao.deleteOrder(order);
    }


}
