package com.qfedu.dao;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsDao {
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition);
    public int getFuzzyDataCount(String condition);
    public Goods getGoodsById(int id);
    public int addGoods(Goods goods);
    public int delByGoodsId(int id);
    public int updateGoods(Goods goods);
}
