package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Goods;

import java.util.Map;

public interface GoodsService {


    ServiceVO getCode();


    Map<String, Object> getGoodsList(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);

    Map<String, Object> listInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);

    ServiceVO saveOrUpdate(Goods goods);

    ServiceVO deleteGoods(Integer goodsId);

    Map<String, Object> getNoInventoryQuantity(Integer page, Integer rows, String nameOrCode);

    Map<String, Object> getHasInventoryQuantity(Integer page, Integer rows, String nameOrCode);

    ServiceVO saveStock(Integer goodsId, Integer inventoryQuantity, double purchasingPrice);

    ServiceVO deleteStock(Integer goodsId);

    Map<String, Object> getListAlarm();
}
