package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerDao;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName CustomerServiceImpl
 * @date 2020.12.03 10:20
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Map<String, Object> getCustomers(Integer page, Integer rows, String customerName) {
        HashMap<String, Object> map = new HashMap<>();

        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;

        List<Customer> customerList = customerDao.getCustomers(offSet,rows,customerName);

        map.put("rows",customerList);
        return map;
    }
}
