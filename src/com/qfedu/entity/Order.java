package com.qfedu.entity;

public class Order {
    private int id;
    private String orderCode;
    private double totalPrice;
    private String createDate;
    private int uid;
    private int status;
    private String orderStatus;
    private String username;

    public Order() {
    }

    public Order(int id, String orderCode, double totalPrice, String createDate, int uid, int status, String orderStatus, String username) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.uid = uid;
        this.status = status;
        this.orderStatus = orderStatus;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", createDate='" + createDate + '\'' +
                ", uid=" + uid +
                ", status=" + status +
                ", orderStatus='" + orderStatus + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
