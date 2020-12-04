package com.atguigu.jxc.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.service.GoodsTypeService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName GoodsCategoryController
 * @date 2020.12.04 08:40
 */
@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    //查询商品所有分类(商品管理)
    //http://localhost:8080/goodsType/loadGoodsType
    @PostMapping("/loadGoodsType")
    public String loadGoodsType() {
//        String tree = goodsTypeService.loadTree();
//        return tree;

        List<GoodsType> treeString = goodsTypeService.loadTree();
        System.out.println(treeString);
        Map<String, Object> goodTypeMap = new HashMap<>();
        goodTypeMap = TreeGoodsType(treeString, treeString.get(0));
        System.out.println("------------------------");
        System.out.println(goodTypeMap);
        List<Object> list = new ArrayList<>();
        list.add(goodTypeMap);
        String s = JSON.toJSONString(list);
        System.out.println(s);
        return s;
    }

    private Map<String, Object> TreeGoodsType(List<GoodsType> goodsTypeList, GoodsType goodsType) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", goodsType.getGoodsTypeId());
        map.put("text", goodsType.getGoodsTypeName());
        if (goodsType.getGoodsTypeState().equals(0)) {
            map.put("state", "open");
        } else {
            map.put("state", "closed");
        }
        map.put("iconCls", "goods-type");
        Map<String, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("state", goodsType.getGoodsTypeState());
        map.put("attributes", objectHashMap);
        List<GoodsType> childrenGoodsType = getChildren(goodsTypeList, goodsType);
        List<Map> childrenList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(childrenGoodsType)) {
            for (GoodsType g : childrenGoodsType
            ) {
                Map map1 = TreeGoodsType(goodsTypeList, g);
                childrenList.add(map1);
            }
            map.put("children", childrenList);
        } else {
            return map;
        }

        return map;
    }

    private List<GoodsType> getChildren(List<GoodsType> goodsTypeList, GoodsType goodsType) {
        List<GoodsType> goodsTypeList1 = new ArrayList<>();
        for (GoodsType g : goodsTypeList
        ) {
            if (g.getPId().equals(goodsType.getGoodsTypeId())) {
                goodsTypeList1.add(g);
            }
        }
        return goodsTypeList1;
    }


    //新增分类
    //请求URL：http://localhost:8080/goodsType/save
    @PostMapping("/save")
    public ServiceVO save(String goodsTypeName, Integer pid) {
        ServiceVO serviceVO = goodsTypeService.save(goodsTypeName,pid);
        return serviceVO;
    }

    //删除分类
    //http://localhost:8080/goodsType/delete
    @PostMapping("/delete")
    public ServiceVO deleteGoodsType(Integer goodsTypeId) {
        ServiceVO serviceVO = goodsTypeService.deleteGoodsType(goodsTypeId);
        return serviceVO;
    }
}
