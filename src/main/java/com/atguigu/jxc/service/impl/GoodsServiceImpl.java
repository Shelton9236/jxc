package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.service.CustomerReturnListGoodsService;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.SaleListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Keymap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private SaleListGoodsService saleListGoodsService;

    @Autowired
    private CustomerReturnListGoodsService customerReturnListGoodsService;

    @Override
    public ServiceVO getCode() {

        // 获取当前商品最大编码
        String code = goodsDao.getMaxCode();

        // 在现有编码上加1
        Integer intCode = Integer.parseInt(code) + 1;

        // 将编码重新格式化为4位数字符串形式
        String unitCode = intCode.toString();

        for(int i = 4;i > intCode.toString().length();i--){

            unitCode = "0"+unitCode;

        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, unitCode);
    }

    @Override
    public Map<String, Object> getGoodsList(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {
        Map<String, Object> map = new HashMap<>();

        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;

        List<Goods> goodsList = goodsDao.getGoodsInventoryList(offSet,rows,codeOrName,goodsTypeId);

           for (Goods goods : goodsList) {
            // 销售总量等于销售单据的销售数据减去退货单据的退货数据
            goods.setSaleTotal(saleListGoodsService.getSaleTotalByGoodsId(goods.getGoodsId())
                    - customerReturnListGoodsService.getCustomerReturnTotalByGoodsId(goods.getGoodsId()));

        }

        map.put("rows",goodsList);
        map.put("total",goodsDao.getGoodsInventoryCount(codeOrName,goodsTypeId));
        return map;
    }

    @Override
    public Map<String, Object> listInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {
        Map<String, Object> map = new HashMap<>();

        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;

        List<Goods> goodsList = goodsDao.getGoodsInventoryList(offSet,rows,codeOrName,goodsTypeId);
        for (Goods goods : goodsList) {
            // 销售总量等于销售单据的销售数据减去退货单据的退货数据
            goods.setSaleTotal(saleListGoodsService.getSaleTotalByGoodsId(goods.getGoodsId())
                    - customerReturnListGoodsService.getCustomerReturnTotalByGoodsId(goods.getGoodsId()));
        }

        map.put("rows",goodsList);
        map.put("total",goodsDao.getGoodsInventoryCount(codeOrName,goodsTypeId));

        return map;
    }

    @Override
    public ServiceVO saveOrUpdate(Goods goods) {
        if(goods.getGoodsId() == null){
            goodsDao.saveGoods(goods);
        }else{
            goodsDao.updateGoods(goods);
        }
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO deleteGoods(Integer goodsId) {
        Goods goods = goodsDao.selectGoodsById(goodsId);
        if(goods.getState() == 0){
            goodsDao.deleteGoods(goodsId);
            return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
        }
        return null;
    }

    @Override
    public Map<String, Object> getNoInventoryQuantity(Integer page, Integer rows, String nameOrCode) {
        Map<String,Object> map = new HashMap<>();
        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;
        List<Goods> goodsList = goodsDao.getNoInventoryQuantity(offSet, rows, nameOrCode);
        List<Goods> list = new ArrayList<>();
        for (Goods goods : goodsList) {
            if(goods.getInventoryQuantity() == -1 || goods.getInventoryQuantity() == 0){
                list.add(goods);
            }
        }
        map.put("rows",list);
        return map;
    }

    @Override
    public Map<String, Object> getHasInventoryQuantity(Integer page, Integer rows, String nameOrCode) {
        Map<String,Object> map = new HashMap<>();
        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;
        List<Goods> goodsList = goodsDao.getHasInventoryQuantity(offSet, rows, nameOrCode);
        List<Goods> list = new ArrayList<>();
        for (Goods goods : goodsList) {
            if(goods.getInventoryQuantity() != -1 || goods.getInventoryQuantity() != 0){
                list.add(goods);
            }
        }
        map.put("rows",list);
        return map;
    }

    @Override
    public ServiceVO saveStock(Integer goodsId, Integer inventoryQuantity, double purchasingPrice) {
        goodsDao.saveStock(goodsId,inventoryQuantity,purchasingPrice);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    @Override
    public ServiceVO deleteStock(Integer goodsId) {
        //goodsDao.deleteStock(goodsId);
        Goods goods = goodsDao.selectGoodsById(goodsId);
        if(goods.getState() == 0){
            goodsDao.deleteStock(goodsId);
            return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
        }
        return null;
    }

    @Override
    public Map<String, Object> getListAlarm() {
        Map<String, Object> map = new HashMap<>();
        List<Goods> goodsList = goodsDao.selectListAlarm();
        map.put("rows",goodsList);
        return map;
    }
}
