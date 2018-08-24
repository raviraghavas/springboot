package com.demo.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.emp.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
