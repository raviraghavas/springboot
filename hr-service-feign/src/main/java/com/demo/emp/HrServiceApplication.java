package com.demo.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.demo.emp.controller.IEmpRestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses=IEmpRestController.class)
public class HrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrServiceApplication.class, args);
	}
	
	/*@Bean
	@LoadBalanced
	public RestTemplate rt()
	{
		return new RestTemplate();
	}
	
	public ILoadBalancer loadbalancer() {
		return new ZoneAwareLoadBalancer();
	}*/
}
