package com.qfedu.service.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition) {
        return goodsDao.fuzzySelectGoods(pageNo,pageSize,condition);
    }

    @Override
    public int getFuzzyDataCount(String condition) {
        return goodsDao.getFuzzyDataCount(condition );
    }

    public Goods getGoodsById(int id){return goodsDao.getGoodsById(id);}

    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int delByGoodsId(int id) {
        return goodsDao.delByGoodsId(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }
}
