package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
        String tree = goodsTypeService.loadTree();
        return tree;
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
