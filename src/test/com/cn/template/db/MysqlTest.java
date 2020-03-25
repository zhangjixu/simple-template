package com.cn.template.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/03 10:30 PM
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class MysqlTest {

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate mysqlJdbcTemplate;

    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate oracleJdbcTemplate;

    @Test
    public void testOrder() {
        String sql = "select * from `order`;";
        List<Map<String,Object>> list = mysqlJdbcTemplate.queryForList(sql);
        System.out.println("\n" + list);
    }

    @Test
    public void testSpring() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate mysql = applicationContext.getBean("mysqlJdbcTemplate", JdbcTemplate.class);
        JdbcTemplate oracle = applicationContext.getBean("oracleJdbcTemplate", JdbcTemplate.class);
        System.out.println("\n ============ " + mysql.getDataSource().getConnection().getMetaData().getDriverName());
        System.out.println("\n ============ " + oracle.getDataSource().getConnection().getMetaData().getDriverName());
        System.out.println("\n ============ " + mysql);
        System.out.println("\n ============ " + oracle);
        System.out.println("\n ============ " + (mysql == oracle));
    }

    @Test
    public void testJDBC() {
        System.out.println("\n ============ " + mysqlJdbcTemplate);
        System.out.println("\n ============ " + oracleJdbcTemplate);
        System.out.println("\n ============ " + (mysqlJdbcTemplate == oracleJdbcTemplate));
    }


}
