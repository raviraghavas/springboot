package com.demo.emp.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.emp.entity.Emp;

@RestController
public interface IEmpRestController {

	@RequestMapping(path="/emp/find/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String findEmp(@PathVariable("id") int id,ServletRequest req);
	
	@RequestMapping(path="/emp",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getEmpList(ServletRequest req);
	
}
