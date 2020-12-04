package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @description 商品信息
 */
@Mapper
public interface GoodsDao {

    String getMaxCode();

    List<Goods> getGoodsInventoryList(int offSet, Integer rows, String codeOrName, Integer goodsTypeId);

    Object getGoodsInventoryCount(String codeOrName, Integer goodsTypeId);

    void saveGoods(Goods goods);

    void updateGoods(Goods goods);

    Goods selectGoodsById(Integer goodsId);

    void deleteGoods(Integer goodsId);

    List<Goods> getNoInventoryQuantity(int offSet, Integer rows, String nameOrCode);

    List<Goods> getHasInventoryQuantity(int offSet, Integer rows, String nameOrCode);

    void saveStock(Integer goodsId, Integer inventoryQuantity, double purchasingPrice);

    List<Goods> selectListAlarm();

    void deleteStock(Integer goodsId);
}
