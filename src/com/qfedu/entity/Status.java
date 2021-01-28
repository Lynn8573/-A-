package com.qfedu.entity;

public class Status {
    private int id;
    private String order_status;

    public Status() {
    }

    public Status(int id, String order_staus) {
        this.id = id;
        this.order_status = order_staus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}
