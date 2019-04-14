package com.dtb.springdatabase.config;

import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_ENTITY_MANAGER_ONE;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_ENTITY_MANAGER_TWO;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_NAME_ONE;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_NAME_TWO;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_PREFIX_ONE;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_PREFIX_TWO;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_PU_ONE;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_PU_TWO;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_TRANSACTION_MANAGER_ONE;
import static com.dtb.springdatabase.config.constants.Database.DATASOURCE_TRANSACTION_MANAGER_TWO;
import static com.dtb.springdatabase.config.constants.Database.ENTITIES_PACKAGES;
import static com.dtb.springdatabase.config.constants.Database.REPOSITORIES_PACKAGES;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryOne", transactionManagerRef = "transactionManagerOne", basePackages = REPOSITORIES_PACKAGES)
@MapperScan(basePackages = "com.dtb.springdatabase.model.mappers")
public class DatabaseConfig {
	@Primary
	@Bean(name = DATASOURCE_NAME_ONE)
	@ConfigurationProperties(prefix = DATASOURCE_PREFIX_ONE)
	public DataSource dataSourceOne() {
		return DataSourceBuilder.create().build();
	}
	@Primary
	@Bean(name = DATASOURCE_ENTITY_MANAGER_ONE)
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryOne(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSourceOne") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages(ENTITIES_PACKAGES)
				.persistenceUnit(DATASOURCE_PU_ONE).build();
	}
	@Primary
	@Bean(name = DATASOURCE_TRANSACTION_MANAGER_ONE)
	public PlatformTransactionManager transactionManagerOne(
			@Qualifier(DATASOURCE_ENTITY_MANAGER_ONE) EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Bean(name = DATASOURCE_NAME_TWO)
	@ConfigurationProperties(prefix = DATASOURCE_PREFIX_TWO)
	public DataSource dataSourceTwo() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = DATASOURCE_ENTITY_MANAGER_TWO)
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryTwo(EntityManagerFactoryBuilder builder,
			@Qualifier(DATASOURCE_NAME_TWO) DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages(ENTITIES_PACKAGES)
				.persistenceUnit(DATASOURCE_PU_TWO).build();
	}

	@Bean(name = DATASOURCE_TRANSACTION_MANAGER_TWO)
	public PlatformTransactionManager transactionManagerTwo(
			@Qualifier(DATASOURCE_ENTITY_MANAGER_TWO) EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
