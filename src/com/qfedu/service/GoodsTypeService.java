package com.qfedu.service;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    public List<GoodsType> TypeSelect();
    public List<GoodsType> GoodsTypeFuzzySelect(int pageNo, int pageSize);
    public int getDataCount();
    public int delById(int id);
    public GoodsType getGoodsTypeById(int id);
    public int updateGoodsType(GoodsType goodsType);
    public int addGoodsType(GoodsType goodsType);
}
