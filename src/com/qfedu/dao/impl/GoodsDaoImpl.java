package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition) {
        String sql = "select * from t_goods,t_goodstype where 1=1  and t_goods.typeId = t_goodstype.id " + condition + " limit ?, ?";
        Object[] objects = {(pageNo-1)*pageSize,pageSize};
        List<Goods> list = new ArrayList<Goods>();

        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                //private int id;
                //    private String goodsName;
                //    private int price;
                //    private int score;
                //    private String deployDate;
                //    private String imgPath;
                //    private String comment;
                //    private int typeId;
                Goods goods = new Goods();
                GoodsType goodStype = new GoodsType();

                goods.setId(resultSet.getInt("t_goods.id"));
                goods.setGoodsName(resultSet.getString("goodsName"));
                goods.setPrice(resultSet.getInt("price"));
                goods.setScore(resultSet.getInt("score"));
                goods.setDeployDate(resultSet.getString("deployDate"));
                goods.setImgPath(resultSet.getString("imgPath"));
                goods.setComment(resultSet.getString("comment"));
                goods.setTypeId(resultSet.getInt("typeId"));
                goodStype.setId(resultSet.getInt("t_goodstype.id"));
                goodStype.setTypename(resultSet.getString("typename"));
                goods.setGoodStype(goodStype);
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getFuzzyDataCount(String condition) {
        String sql = "select count(1) from t_goods,t_goodstype where 1=1 and t_goods.typeId = t_goodstype.id " + condition;
        System.out.println("持久层condition.toString()输出结果：  "+condition);
        Object[] objects={};
        int count = 0;
        try {
            ResultSet resultSet= this.select(sql,objects);
            while (resultSet.next()){
                count = resultSet.getInt("count(1)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("GoodsDaoImpl 获取dataCount :  " + count);
        return count;
    }

    @Override
    public Goods getGoodsById(int id) {
        String sql = "select * from t_goods ,t_goodstype  where  t_goods.typeId = t_goodstype.id  and t_goods.id = ?";
        Object[] objects = {id};
        Goods goods = new Goods();
        GoodsType goodsType = new GoodsType();
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                //private int id;
                //    private String goodsName;
                //    private int price;
                //    private int score;
                //    private String deployDate;
                //    private String imgPath;
                //    private String comment;
                //    private int typeId;
                //    private GoodsType goodStype;
                goods.setId(resultSet.getInt("t_goods.id"));
                goods.setGoodsName(resultSet.getString("goodsName"));
                goods.setPrice(resultSet.getInt("price"));
                goods.setScore(resultSet.getInt("score"));
                goods.setDeployDate(resultSet.getString("deployDate"));
                goods.setImgPath(resultSet.getString("imgPath"));
                goods.setComment(resultSet.getString("comment"));
                goods.setTypeId(resultSet.getInt("typeId"));
                goodsType.setTypename(resultSet.getString("typename"));
                goodsType.setId(resultSet.getInt("t_goodstype.id"));
                goods.setGoodStype(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public int addGoods(Goods goods) {
        String sql= "INSERT INTO t_goods (goodsName,price,deployDate,imgPath,comment,typeId) VALUES ( ?, ?, ?, ?, ?, ?)";
        Object [] objects = {goods.getGoodsName(),goods.getPrice(),goods.getDeployDate(),goods.getImgPath(),goods.getComment(),goods.getTypeId()};
        return this.setUpdate(sql,objects);
    }

    @Override
    public int delByGoodsId(int id) {
        String sql = "delete from t_goods where id =?";
        Object[] object = {id};
        return this.setUpdate(sql,object);
    }

    @Override
    public int updateGoods(Goods goods) {
        //update t_goods set goodsName=?,price=?,deployDate=?,imgPath=?,comment=?,typeId=? where id=?
        //String sql = "update t_user set password=123 where id = ?";
        String sql = "update t_goods set goodsName = ?,price = ? ,imgPath=?,comment=?,typeId=? where id =?";
        Object[] objects = {goods.getGoodsName(),goods.getPrice(),goods.getImgPath(),goods.getComment(),goods.getTypeId(),goods.getId()};
        return this.setUpdate(sql,objects);
    }
}
