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
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;
    
//    @Value("${service.employeeeurekaclient.serviceId}")
//    private String employeeServiceId;

    @RequestMapping("/dashboard/{id}")
    public EmployeeInfo findById(@PathVariable Long id) {
        Application application = eurekaClient.getApplication("EmployeeEurekaClient");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/find/" + id;
        System.out.println("URL" + url);
        EmployeeInfo emp = restTemplate.getForObject(url, EmployeeInfo.class);
        System.out.println("RESPONSE " + emp);
        return emp;
    }

    @RequestMapping("/dashboard/all")
    public Collection<?> findAll() {
        Application application = eurekaClient.getApplication("EmployeeEurekaClient");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/findall";
        System.out.println("URL" + url);
        Collection <?> list = restTemplate.getForObject(url, Collection.class);
        System.out.println("RESPONSE " + list);
        return list;
    }

}
