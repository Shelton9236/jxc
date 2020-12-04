package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.service.GoodsService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description 商品信息Controller
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询商品库存信息
     * @param page 当前页
     * @param rows 每页显示条数
     * @param codeOrName 商品编码或名称
     * @param goodsTypeId 商品类别ID
     * @return
     */
    @PostMapping("/listInventory")
    @RequiresPermissions(value = "当前库存查询")
    @ResponseBody
    public Map<String, Object> listInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId){
        Map<String, Object> map =goodsService.listInventory(page,rows,codeOrName,goodsTypeId);
        return map;
    }


    /**
     * 分页查询商品信息
     * @param page 当前页
     * @param rows 每页显示条数
     * @param goodsName 商品名称
     * @param goodsTypeId 商品类别ID
     * @return
     */
    @PostMapping("/list")
    @ResponseBody
    public Map<String,Object> getGoodsList(Integer page,Integer rows,String goodsName,Integer goodsTypeId) {
        Map<String,Object> map = goodsService.getGoodsList(page,rows,goodsName,goodsTypeId);
        return map;
    }


    /**
     * 生成商品编码
     * @return
     */
    @RequestMapping("/getCode")
    @RequiresPermissions(value = "商品管理")
    public ServiceVO getCode() {
        return goodsService.getCode();
    }

    /**
     * 添加或修改商品信息
     * @param goods 商品信息实体
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public ServiceVO saveOrUpdate(Goods goods){
        ServiceVO serviceVO = goodsService.saveOrUpdate(goods);
        return serviceVO;
    }

    /**
     * 删除商品信息
     * @param goodsId 商品ID
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public ServiceVO deleteGoods(Integer goodsId){
        ServiceVO serviceVO = goodsService.deleteGoods(goodsId);
        return serviceVO;
    }

    /**
     * 分页查询无库存商品信息
     * @param page 当前页
     * @param rows 每页显示条数
     * @param nameOrCode 商品名称或商品编码
     * @return
     */
    @PostMapping("/getNoInventoryQuantity")
    @ResponseBody
    public Map<String,Object> getNoInventoryQuantity(Integer page,Integer rows,String nameOrCode){
        Map<String,Object> map = goodsService.getNoInventoryQuantity(page,rows,nameOrCode);
        return map;
    }

    /**
     * 分页查询有库存商品信息
     * @param page 当前页
     * @param rows 每页显示条数
     * @param nameOrCode 商品名称或商品编码
     * @return
     */
    @PostMapping("/getHasInventoryQuantity")
    @ResponseBody
    public Map<String,Object> getHasInventoryQuantity(Integer page,Integer rows,String nameOrCode){
        Map<String,Object> map = goodsService.getHasInventoryQuantity(page,rows,nameOrCode);
        return map;
    }

    /**
     * 添加商品期初库存
     * @param goodsId 商品ID
     * @param inventoryQuantity 库存
     * @param purchasingPrice 成本价
     * @return
     */
    @PostMapping("/saveStock")
    @ResponseBody
    public ServiceVO saveStock(Integer goodsId,Integer inventoryQuantity,double purchasingPrice){
        ServiceVO serviceVO = goodsService.saveStock(goodsId,inventoryQuantity,purchasingPrice);
        return serviceVO;
    }

    /**
     * 删除商品库存
     * @param goodsId 商品ID
     * @return
     */
    @PostMapping("/deleteStock")
    @ResponseBody
    public ServiceVO deleteStock(Integer goodsId){
        ServiceVO serviceVO = goodsService.deleteStock(goodsId);
        return serviceVO;
    }

    /**
     * 查询库存报警商品信息
     * @return
     */
    @PostMapping("/listAlarm")
    @ResponseBody
    public Map<String,Object> listAlarm(){
        Map<String,Object> map = goodsService.getListAlarm();
        return map;
    }
}
