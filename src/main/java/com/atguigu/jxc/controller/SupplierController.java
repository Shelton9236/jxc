package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName SupplierController
 * @date 2020.12.03 08:53
 */
@RestController
@RequestMapping("/supplier/")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    //请求URL：http://localhost:8080/supplier/list
    // 请求参数：Integer page（当前页数）, Integer rows（每页显示的记录数）, String supplierName
    //分页查询供应商
    @PostMapping("list")
    public Map<String,Object> findAllSuppliers(Integer page, Integer rows, String supplierName) {
        Map<String,Object> map = supplierService.findAllSuppliers(page,rows,supplierName);
        return map;
    }

    //请求URL：http://localhost:8080/supplier/save?supplierId=1
    //请求参数：Supplier supplier
    //供应商添加或修改
    @PostMapping("save")
    public ServiceVO save(Supplier supplier) {
        ServiceVO serviceVO = supplierService.saveSupplier(supplier);
        return serviceVO;
    }

    //删除供应商
    //http://localhost:8080/supplier/delete
    @PostMapping("delete")
    public ServiceVO delete(String[] ids) {
        List<String> idList = Arrays.asList(ids);
        supplierService.deleteSuppiers(idList);
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS,null);
    }
}
