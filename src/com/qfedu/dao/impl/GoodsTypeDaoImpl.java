package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.entity.GoodsType;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {
    @Override
    public List<GoodsType> GoodsTypeFuzzySelect(int pageNo, int pageSize) {
        String sql = "select * from t_goodstype limit ?,?";
        Object [] objects = {(pageNo-1)*pageSize,pageSize};
        List<GoodsType> list = new ArrayList<GoodsType>();
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                goodsType.setLevel(resultSet.getInt("level"));
                goodsType.setPid(resultSet.getInt("pid"));
                list.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<GoodsType> TypeSelect() {
        String sql = "select * from t_goodstype ";
        Object [] objects = {};
        List<GoodsType> list = new ArrayList<GoodsType>();
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                goodsType.setLevel(resultSet.getInt("level"));
                goodsType.setPid(resultSet.getInt("pid"));
                list.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getDataCount() {
        String sql = "select count(1) from t_goodstype";
        Object[]objects = {};
        int count =0;
        try {
            ResultSet resultSet = this.select(sql,objects);
            while (resultSet.next()){
                count=resultSet.getInt("count(1)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int delById(int id) {
        String sql = "delete from t_goodstype where id = ?";
        Object[] objects = {id};
        return this.setUpdate(sql,objects);
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        String sql = "select * from t_goodstype where id = ?";
        Object[] objects = {id};
        GoodsType goodsType = new GoodsType();
        try {
            ResultSet resultSet = this.select(sql,objects);

            if (resultSet.next()){
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                goodsType.setLevel(resultSet.getInt("level"));
                goodsType.setPid(resultSet.getInt("pid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsType;
    }

    @Override
    public int updateGoodsType(GoodsType goodsType) {
        String sql = "update t_goodstype set typename = ? where id = ?";
        Object [] objects = {goodsType.getTypename(),goodsType.getId()};
        return this.setUpdate(sql,objects);
    }

    @Override
    public int addGoodsType(GoodsType goodsType) {
        String sql = "INSERT INTO t_goodstype set typename = ?";
        Object[] objects = {goodsType.getTypename()};
        return this.setUpdate(sql,objects);
    }
}
