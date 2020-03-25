package com.cn.template.db;

import com.cn.template.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/03 9:31 AM
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class OracleTest {

    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate oracleJdbcTemplate;

    @Test
    public void testAddOrder() {
        String sql = "insert into \"order\"(order_id, goods, price) values(?, ?, ?)";
        int orderId = 20200303;
        String goods = "梨";
        double price = 1.2;
        oracleJdbcTemplate.update(sql, orderId, goods, price);
    }

    @Test
    public void testQueryAllOrder() {
        String sql = "select * from \"order\"";
        List<Order> resultList = oracleJdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
        for (Order order : resultList) {
            System.out.println("\n" + order);
        }
    }

    @Test
    public void testUpdateOrder() {
        String sql = "update \"order\" set price = ? where goods = ?";
        String goods = "梨";
        double price = 0.2;
        oracleJdbcTemplate.update(sql, price, goods);
    }

    @Test
    public void testDeleteOrder() {
        String sql = "delete from \"order\" where order_id = ?";
        int orderId = 20200303;
        oracleJdbcTemplate.update(sql, orderId);
    }


}
