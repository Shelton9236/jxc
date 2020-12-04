package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.GoodsType;

import java.util.List;

/**
 * @description 商品类别
 */
public interface GoodsTypeDao {

    Integer updateGoodsTypeState(GoodsType parentGoodsType);

    List<GoodsType> selectGoodsTypeList();

    void saveGoodsType(String goodsTypeName, Integer pid);

    void deleteGoodsType(Integer goodsTypeId);
}
