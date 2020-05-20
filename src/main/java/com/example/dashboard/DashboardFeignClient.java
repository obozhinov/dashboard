package com.example.dashboard;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient("EmployeeEurekaClient")
public interface DashboardFeignClient {
    @RequestMapping(method= RequestMethod.GET,value="/employee/findall")
    Collection<?> findAll(@RequestHeader("Authorization") String authHeader);

    @RequestMapping(method= RequestMethod.GET,value="/employee/{id}")
    EmployeeInfo findById(@PathVariable Long id, @RequestHeader("Authorization") String authHeader);
}


