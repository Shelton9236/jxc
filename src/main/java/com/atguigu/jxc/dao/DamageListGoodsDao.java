package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.DamageListGoods;

import java.util.ArrayList;
import java.util.List;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName DamageListGoodsDao
 * @date 2020.12.04 11:12
 */
public interface DamageListGoodsDao {
    void insertDamageListGoods(Integer damageListId, ArrayList<DamageListGoods> list);

    List<DamageListGoods> selectDamageListGoods(Integer damageListId);
}
