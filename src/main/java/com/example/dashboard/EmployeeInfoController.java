package com.example.dashboard;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RefreshScope
@RestController
public class EmployeeInfoController {

    @Autowired
    private DashboardFeignClient feignClient;

    @RequestMapping("/dashboard/{id}")
    public EmployeeInfo findById(@PathVariable Long id) {
        return feignClient.findById(id);
    }

    @RequestMapping("/dashboard/all")
    public Collection<?> findAll() {
        return feignClient.findAll();
    }

}
