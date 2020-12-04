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
}
