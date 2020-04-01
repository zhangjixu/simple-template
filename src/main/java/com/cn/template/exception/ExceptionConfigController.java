package com.cn.template.exception;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/04/01 10:51 PM
 * @Description:
 * @Version: 1.0.0
 */
@ControllerAdvice
public class ExceptionConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionConfigController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject customException(Exception e) {
        JSONObject json = new JSONObject();
        LOGGER.error(" 捕获到了异常: {}", e.getMessage());
        json.put("exception", e.getMessage());
        return json;
    }


}
