package com.qfedu.dao;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    public List<GoodsType> GoodsTypeFuzzySelect(int pageNo, int pageSize);
    public List<GoodsType> TypeSelect();
    public int getDataCount();
    public int delById(int id);
    public GoodsType getGoodsTypeById(int id);
    public int updateGoodsType(GoodsType goodsType);
    public int addGoodsType(GoodsType goodsType);
}
