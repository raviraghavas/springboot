package com.demo.emp.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.emp.entity.Emp;
import com.demo.emp.repo.EmpRepository;

@RestController
public class EmpRestController implements IEmpRestController {

	@Autowired
	EmpRepository empRepo;
	
	@Override
	public String findEmp(@PathVariable("id") int id,ServletRequest req) {
		// TODO Auto-generated method stub
		
		System.out.println("-- Inside the server -- "+req.getLocalAddr() +" : "+req.getLocalPort());
		
		Optional <Emp> o = empRepo.findById(id);
		
		if(o.isPresent())
			return o.get().toString();
		else
			return "{\"status\" : \"Employee not found...\" }";		
	}

	@Override
	public List<Emp> getEmpList(ServletRequest req) {
		// TODO Auto-generated method stub
		
		System.out.println("-- Inside the server -- "+req.getLocalAddr() +" : "+req.getLocalPort());
		
		return empRepo.findAll();		
	}

}
