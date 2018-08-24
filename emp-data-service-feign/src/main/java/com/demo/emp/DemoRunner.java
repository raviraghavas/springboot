package com.demo.emp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner,InitializingBean {

	@Value("${app.secret}")
	String secVal;
	
	@PostConstruct
	public void tes() {
		// TODO Auto-generated method stub
		
		System.out.println("Inside the postconstruct -- 1");
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Secret value key 2 :"+secVal);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Inside the afterPropertiesSet -- 3");
		
	}

}
