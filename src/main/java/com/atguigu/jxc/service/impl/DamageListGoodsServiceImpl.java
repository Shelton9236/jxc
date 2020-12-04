package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.DamageListDao;
import com.atguigu.jxc.dao.DamageListGoodsDao;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;
import com.atguigu.jxc.service.DamageListGoodsService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName DamageListGoodsServiceImpl
 * @date 2020.12.04 11:07
 */
@Service
public class DamageListGoodsServiceImpl implements DamageListGoodsService {

    @Autowired
    private DamageListGoodsDao damageListGoodsDao;

    @Autowired
    private DamageListDao damageListDao;

    @Override
    public void saveDamageListGoods(DamageList damageList, ArrayList<DamageListGoods> list) {
        damageListDao.insertDamageList(damageList);
        Integer damageListId = damageList.getDamageListId();
        if (!CollectionUtils.isEmpty(list)) {
            damageListGoodsDao.insertDamageListGoods(damageListId,list);
        }
    }

    @Override
    public Map<String, Object> getDamageList(String sTime, String eTime) {
        HashMap<String, Object> map = new HashMap<>();
        List<DamageList> damageLists = damageListDao.selectDamageList(sTime,eTime);
        map.put("rows",damageLists);
        return null;
    }

    @Override
    public Map<String, Object> getDamageListGoods(Integer damageListId) {
        Map<String, Object> map = new HashMap<>();
        List<DamageListGoods> damageListGoodsList = damageListGoodsDao.selectDamageListGoods(damageListId);
        map.put("rows",damageListGoodsList);
        return map;
    }
}
