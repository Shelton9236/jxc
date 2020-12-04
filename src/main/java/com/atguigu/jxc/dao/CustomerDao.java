package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Customer;

import java.util.List;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName CustomerDao
 * @date 2020.12.03 10:24
 */
public interface CustomerDao {
    List<Customer> getCustomers(int offSet, Integer rows, String customerName);
}
