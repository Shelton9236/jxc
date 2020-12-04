package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description //todo
 *
 * @author 废材是怎样炼成的
 * @ClassName CustomerController
 * @date 2020.12.03 10:11
 */
@RestController
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("list")
    public Map<String,Object> getCustomersByName(Integer page, Integer rows, String customerName) {
        Map<String,Object> map = customerService.getCustomers(page,rows,customerName);
        return map;
    }
}
