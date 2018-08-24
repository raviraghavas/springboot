package com.demo.emp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DaoConfig {

	@Value("${mysql.driver}")
	private String driver;
	
	@Value("${mysql.url}")
	private String url;
	
	@Value("${mysql.username}")
	private String username;
	
	@Value("${mysql.password}")
	private String pass;
	
	@Bean
	public DriverManagerDataSource ds()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		
		ds.setUsername(username);
		ds.setPassword(pass);
		return ds;
	}


	@Bean
	@ConfigurationProperties(prefix="app.mysql")
//	@Primary
	@Profile("demoapp")
	public DataSource datasource() {
		
		return DataSourceBuilder.create().build(); 
		
		
	}
	
}
