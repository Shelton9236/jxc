package com.atguigu.jxc.service;

import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName CustomerService
 * @date 2020.12.03 10:20
 */
public interface CustomerService {
    Map<String, Object> getCustomers(Integer page, Integer rows, String customerName);
}
