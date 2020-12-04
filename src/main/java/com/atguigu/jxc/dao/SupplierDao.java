package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName SupplierDao
 * @date 2020.12.03 09:10
 */
public interface SupplierDao {
    List<Supplier> getSuppliersByPage(int offSet, String supplierName);

    void insert(Supplier supplier);

    void updateSupplier(Supplier supplier);

    void deleteSuppliers(List<String> idList);
}
