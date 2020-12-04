package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.DamageList;
import com.atguigu.jxc.entity.DamageListGoods;
import com.atguigu.jxc.entity.User;
import com.atguigu.jxc.service.DamageListGoodsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName DamageListGoodsController
 * @date 2020.12.04 11:00
 */
@RestController
public class DamageListGoodsController {

    @Autowired
    private DamageListGoodsService damageListGoodsService;

    //保存报损单
    //请求URL：http://localhost:8080/damageListGoods/save?damageNumber=BS1605766644460（报损单号,前端生成）
    @PostMapping("/damageListGoods/save")
    public ServiceVO save(DamageList damageList, String damageListGoodsStr, HttpSession session){
        //需要从session中获取到用户Id
        User user = (User) session.getAttribute("currentUser");
        damageList.setUserId(user.getUserId());
        Gson gson = new Gson();
        //需要使用GSON将JSON串转换为集合对象
        ArrayList<DamageListGoods> list = gson.fromJson(damageListGoodsStr, ArrayList.class);
        damageListGoodsService.saveDamageListGoods(damageList,list);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    //报损单查询
    //请求URL：http://localhost:8080/damageListGoods/list
    //请求参数：String  sTime（开始时间）, String  eTime（结束时间）
    @PostMapping("/damageListGoods/list")
    public Map<String,Object> getDamageList(String  sTime,String  eTime){
        Map<String,Object> map = damageListGoodsService.getDamageList(sTime,eTime);
        return map;
    }

    //查询报损单商品信息
    //请求URL：http://localhost:8080/damageListGoods/goodsList
    @PostMapping("/damageListGoods/goodsList")
    public Map<String,Object> getDamageListGoods(Integer damageListId) {
        Map<String, Object> map = damageListGoodsService.getDamageListGoods(damageListId);
        return map;
    }
}
