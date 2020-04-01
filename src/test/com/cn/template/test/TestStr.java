package com.cn.template.test;

import org.junit.Test;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/04/01 11:20 PM
 * @Description:
 * @Version: 1.0.0
 */
public class TestStr {

    @Test
    public void test() {
        try {
            int[] arr = new int[2];
            arr[2] = 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
