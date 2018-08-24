package com.demo.emp;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	RestTemplate rt;
	
	String ur = "http://localhost:8080/emp";
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String plainTextCreds = "ravi:pass";
		
		String encodedCreds = new String(Base64.encodeBase64(plainTextCreds.getBytes()));
				
		HttpHeaders head= new HttpHeaders();
		head.set("Accept", "application/json");
		head.set("Authorization","Basic "+encodedCreds);
		
		HttpEntity hent = new HttpEntity<>(head);
		
		
		ResponseEntity<String> rspe = rt.exchange(ur,HttpMethod.GET, hent,String.class);
		
		System.out.println("Output received :"+rspe.getBody());
	}

}
