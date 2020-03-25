package com.cn.template.entity;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 12:32 PM
 * @Description:
 * @Version: 1.0.0
 */
public class Order {

    private Integer id;
    private Integer orderId;
    private String goods;
    private Double price;

    public Order() {

    }

    public Order(Integer orderId, String goods, Double price) {
        this.orderId = orderId;
        this.goods = goods;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goods='" + goods + '\'' +
                ", price=" + price +
                '}';
    }
}
