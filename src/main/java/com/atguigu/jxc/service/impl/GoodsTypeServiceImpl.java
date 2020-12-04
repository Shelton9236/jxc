package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsTypeDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.service.GoodsTypeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName GoodsTypeServiceImpl
 * @date 2020.12.04 08:42
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public List<GoodsType> loadTree() {

//        List<GoodsType> listReturn = new ArrayList<>();
//        Map<Integer, GoodsType> map = new HashMap<Integer, GoodsType>();
//
//        List<GoodsType> list = goodsTypeDao.selectGoodsTypeList();
//        for (GoodsType menu : list) {
//            map.put(menu.getGoodsTypeId(),menu);
//            if (menu.getPId() == -1) {
//                listReturn.add(menu);
//            }
//        }
//
//        for (GoodsType menu : list) {
//            GoodsType childMenu = menu;
//            GoodsType parentMenu = map.get(childMenu.getPId());
//            if (parentMenu != null) {
//                parentMenu.getChildren().add(childMenu);
//            }
//        }
//
//        Gson gson = new Gson();
//        String toJson = gson.toJson(listReturn);
//        return toJson;

        return goodsTypeDao.selectGoodsTypeList();
    }

    @Override
    public ServiceVO save(String goodsTypeName, Integer pid) {
        goodsTypeDao.saveGoodsType(goodsTypeName,pid);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO deleteGoodsType(Integer goodsTypeId) {
        goodsTypeDao.deleteGoodsType(goodsTypeId);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }
}
