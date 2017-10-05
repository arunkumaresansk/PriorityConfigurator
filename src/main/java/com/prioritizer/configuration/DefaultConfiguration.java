package com.prioritizer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prioritizer.dao.DBConnector;

@Configuration
public class DefaultConfiguration {

	@Bean
	public DBConnector getDBConnection() {
		return new DBConnector();
	}
	
}
