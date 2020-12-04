package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;

import java.util.ArrayList;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName DamageListGoodsService
 * @date 2020.12.04 11:06
 */
public interface DamageListGoodsService {
    void saveDamageListGoods(DamageList damageList, ArrayList<DamageListGoods> list);

    Map<String, Object> getDamageList(String sTime, String eTime);

    Map<String, Object> getDamageListGoods(Integer damageListId);
}
