package com.cn.template.db;

import com.cn.template.util.MultipleDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/03 9:30 PM
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class MultipleDataSourceTest {

    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    @Test
    public void testMultipleDataSouce() {
        testDb1();
        testDb2();
    }

    public void testDb1() {
        String sql = "select * from `order`";
        MultipleDataSource.setDataSourceKey("db1");
        List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public void testDb2() {
        String sql = "select * from `tmp`";
        MultipleDataSource.setDataSourceKey("db2");
        List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
