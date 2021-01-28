package com.qfedu.service.impl;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.dao.impl.GoodsTypeDaoImpl;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;


import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
    public List<GoodsType> GoodsTypeFuzzySelect(int pageNo, int pageSize){
        return  goodsTypeDao.GoodsTypeFuzzySelect(pageNo,pageSize);
    }

    @Override
    public List<GoodsType> TypeSelect() {
        return goodsTypeDao.TypeSelect();
    }

    @Override
    public int getDataCount() {
        return goodsTypeDao.getDataCount();
    }

    @Override
    public int delById(int id) {
        return goodsTypeDao.delById(id);
    }

    public GoodsType getGoodsTypeById(int id){
        return goodsTypeDao.getGoodsTypeById(id);
    }

    @Override
    public int updateGoodsType(GoodsType goodsType) {
        return goodsTypeDao.updateGoodsType(goodsType);
    }

    @Override
    public int addGoodsType(GoodsType goodsType) {
        return goodsTypeDao.addGoodsType(goodsType);
    }
}
