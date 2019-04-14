package com.dtb.springdatabase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class PersistenceContextSetup {
	
	@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryOne", transactionManagerRef = "transactionManagerOne", basePackages = "com.dtb.springdatabase.model.repositories.dbone")
//	@MapperScan(basePackages = "com.dtb.springdatabase.model.mappers.dbone")
	public static class PersistenceContextOne {

	}
	
	@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryTwo", transactionManagerRef = "transactionManagerTwo", basePackages = "com.dtb.springdatabase.model.repositories.dbtwo")
//	@MapperScan(basePackages = "com.dtb.springdatabase.model.mappers.dbtwo")	
	public static class PersistenceContextTwo{
		
	}
}
