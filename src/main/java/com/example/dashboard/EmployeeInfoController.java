package com.example.dashboard;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RefreshScope
@RestController
public class EmployeeInfoController {

    @Autowired
    private DashboardFeignClient feignClient;

    @GetMapping("/dashboard/{id}")
    public EmployeeInfo findById(@PathVariable Long id, @RequestHeader("Authorization") String authHeader) {
        return feignClient.findById(id, authHeader);
    }

    @GetMapping("/dashboard/all")
    public Collection<?> findAll(@RequestHeader("Authorization") String authHeader) {
        return feignClient.findAll(authHeader);
    }

}
