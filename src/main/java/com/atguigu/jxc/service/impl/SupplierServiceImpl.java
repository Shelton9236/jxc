package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SupplierDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName SupplierServiceImpl
 * @date 2020.12.03 09:03
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public Map<String, Object> findAllSuppliers(Integer page, Integer rows, String supplierName) {
        Map<String, Object> map = new HashMap<>();

        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;

        List<Supplier> supplierList = supplierDao.getSuppliersByPage(offSet,supplierName);

        map.put("rows",supplierList);

        return map;
    }

    @Override
    public ServiceVO saveSupplier(Supplier supplier) {
        if (supplier.getSupplierId() == null) {
            supplierDao.insert(supplier);
        }else {
            supplierDao.updateSupplier(supplier);
        }
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    @Override
    public void deleteSuppiers(List<String> idList) {
        supplierDao.deleteSuppliers(idList);
    }
}
