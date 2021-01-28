package com.qfedu.entity;

public class GoodsType {
    private int id;
    private String typename;
    private int level;
    private int pid;

    public GoodsType() {
    }

    public GoodsType(String typename) {
        this.typename = typename;
    }

    public GoodsType(int id, String typename, int level, int pid) {
        this.id = id;
        this.typename = typename;
        this.level = level;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", level=" + level +
                ", pid=" + pid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
