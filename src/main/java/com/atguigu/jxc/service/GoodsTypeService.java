package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.GoodsType;

import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName GoodsTypeService
 * @date 2020.12.04 08:42
 */
public interface GoodsTypeService {
    List<GoodsType> loadTree();

    ServiceVO save(String goodsTypeName, Integer pid);

    ServiceVO deleteGoodsType(Integer goodsTypeId);
}
