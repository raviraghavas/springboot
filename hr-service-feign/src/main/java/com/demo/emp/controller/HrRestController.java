package com.demo.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.emp.helper.HrServicehelper;

@RestController
public class HrRestController implements IHrRestController {

	@Autowired
	HrServicehelper hsh;
	
	@Override
	public ResponseEntity findEmp(@RequestParam("id") int id) {		
		return hsh.getById(id);		
	}

	@Override
	public ResponseEntity getEmpList() {
		return hsh.getAllEmp();
	}


}
