package com.demo.emp.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.emp.config.FeignClientConfiguration;
import com.demo.emp.entity.Emp;

@FeignClient(value="emp-data-service",configuration=FeignClientConfiguration.class)
//@FeignClient(value="emp-data-service")
public interface IFeignClientController extends IEmpRestController {

	@RequestMapping(path="/emp/find/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String findEmp(@PathVariable("id") int id);
	
	@RequestMapping(path="/emp",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getEmpList();
	
}
