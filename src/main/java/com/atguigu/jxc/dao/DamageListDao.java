package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.DamageList;

import java.util.List;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName DamageListDao
 * @date 2020.12.04 11:11
 */
public interface DamageListDao {
    void insertDamageList(DamageList damageList);

    List<DamageList> selectDamageList(String sTime, String eTime);
}
