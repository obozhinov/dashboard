package com.example.dashboard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient("EmployeeEurekaClient")
public interface DashboardFeignClient {
    @RequestMapping(method= RequestMethod.GET,value="/employee/findall")
    Collection<?> findAll();

    @RequestMapping(method= RequestMethod.GET,value="/employee/find/{id}")
    EmployeeInfo findById(@PathVariable Long id);
}


