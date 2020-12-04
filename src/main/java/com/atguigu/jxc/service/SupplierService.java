package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName SupplierService
 * @date 2020.12.03 09:02
 */
public interface SupplierService {

    Map<String, Object> findAllSuppliers(Integer page, Integer rows, String supplierName);

    ServiceVO saveSupplier(Supplier supplier);

    void deleteSuppiers(List<String> idList);
}
