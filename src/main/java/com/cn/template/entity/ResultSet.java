package com.cn.template.entity;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/6/14
 * @Description:
 * @Version: 1.0.0
 */
public class ResultSet {

    private Integer code;
    private String message;
    private Object result;

    public ResultSet() {
    }

    public ResultSet(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultSet{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
