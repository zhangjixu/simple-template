package com.cn.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/04/01 10:56 PM
 * @Description:
 * @Version: 1.0.0
 */
@RestController
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @RequestMapping(value = "/testException", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public Object testException() {
        LOGGER.error(" ==========  testException ");
        int[] arr = new int[2];
        arr[2] = 1;
        return "success";
    }

}
