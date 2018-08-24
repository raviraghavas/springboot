package com.demo.emp.config;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfiguration {
	
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		String plainTextCreds = "ravi:pass";
		
		String encodedCreds = new String(Base64.encodeBase64(plainTextCreds.getBytes()));
		
		RequestTemplate rt = new RequestTemplate();
		
		rt.header("Authorization","Basic "+encodedCreds);
		
		BasicAuthRequestInterceptor bari = new BasicAuthRequestInterceptor("ravi", "pass");
		
		bari.apply(rt);
		
		
		return bari;
	}

	//@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
}
