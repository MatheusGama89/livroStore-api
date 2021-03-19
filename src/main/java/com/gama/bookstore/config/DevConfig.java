package com.gama.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gama.bookstore.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	private DBService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instaciaBaseDados() {
		if (strategy.equals("create")) {
			this.dbservice.instanciaBaseDeDados();
		}
		return false;
	}
	

}
