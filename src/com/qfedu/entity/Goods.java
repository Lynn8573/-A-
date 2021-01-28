package com.qfedu.entity;

public class Goods {
    private int id;
    private String goodsName;
    private int price;
    private int score;
    private String deployDate;
    private String imgPath;
    private String comment;
    private int typeId;
    private GoodsType goodStype;

    //Goods(goodsName,price,imgPath,comment,typeId)
    public Goods(String goodsName,int price,String imgPath,String comment,int typeId){
        this.goodsName = goodsName;
        this.price = price;
        this.imgPath = imgPath;
        this.comment = comment;
        this.typeId = typeId;
    }
    public GoodsType getGoodStype() {
        return goodStype;
    }

    public void setGoodStype(GoodsType goodStype) {
        this.goodStype = goodStype;
    }

    public Goods() {
    }

    public Goods(int id, String goodsName, int price, int score, String deployDate, String imgPath, String comment, int typeId) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.score = score;
        this.deployDate = deployDate;
        this.imgPath = imgPath;
        this.comment = comment;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", score=" + score +
                ", deployDate='" + deployDate + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", comment='" + comment + '\'' +
                ", typeId=" + typeId +
                ", goodStype=" + goodStype +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(String deployDate) {
        this.deployDate = deployDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
