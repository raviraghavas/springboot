package com.demo.emp.helper;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HrServicehelper {
	
	@Autowired
	RestTemplate rt;
	String plainTextCreds = "ravi:pass";
	
	String encodedCreds = new String(Base64.encodeBase64(plainTextCreds.getBytes()));
	
	String urlAllEmp = "http://emp-data-service/emp";
	String urlbyId = "http://emp-data-service/emp/find/";
	
	public ResponseEntity getById(int id) {
		HttpHeaders head= new HttpHeaders();
		head.set("Accept", "application/json");
		head.set("Authorization","Basic "+encodedCreds);
		
		HttpEntity hent = new HttpEntity<>(head);
		
		ResponseEntity<String> rspe = rt.exchange(urlbyId+id,HttpMethod.GET, hent,String.class);
		
		System.out.println("Output received :"+rspe.getBody());
		
		return rspe;
	}
	
	public ResponseEntity getAllEmp() {
		HttpHeaders head= new HttpHeaders();
		head.set("Accept", "application/json");
		head.set("Authorization","Basic "+encodedCreds);
		
		HttpEntity hent = new HttpEntity<>(head);
		
		ResponseEntity<String> rspe = rt.exchange(urlAllEmp,HttpMethod.GET, hent,String.class);
		
		System.out.println("Output received :"+rspe.getBody());
		
		return rspe;
	}


}
