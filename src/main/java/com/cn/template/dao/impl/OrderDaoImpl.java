package com.cn.template.dao.impl;

import com.cn.template.dao.OrderDao;
import com.cn.template.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 2:09 PM
 * @Description:
 * @Version: 1.0.0
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    @Override
    public List<Order> queryAllOrder() {
        String sql = "select * from `order`;";
        List<Order> resultList = mysqlJdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
        return resultList;
    }

    @Override
    public void updateOrder(Order order) {
        String sql = "update `order` set `price` = ? where `goods` = ?;";
        mysqlJdbcTemplate.update(sql, order.getPrice(), order.getGoods());
    }

    @Override
    public void addOrder(Order order) {
        String sql = "insert into `order`(`order_id`, `goods`, `price`) values(?, ?, ?);";
        mysqlJdbcTemplate.update(sql, order.getOrderId(), order.getGoods(), order.getPrice());
    }

    @Override
    public void deleteOrder(Order order) {
        String sql = "delete from `order` where `order_id` = ?;";
        mysqlJdbcTemplate.update(sql, order.getOrderId());
    }

}
