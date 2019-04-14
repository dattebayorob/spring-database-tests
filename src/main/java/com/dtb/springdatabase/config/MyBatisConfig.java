package com.dtb.springdatabase.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import com.dtb.springdatabase.config.constants.Database;

@Configuration
public class MyBatisConfig {
	@Primary
	@Bean(name = "sqlSessionFactoryOne")
	public SqlSessionFactoryBean sqlSessionFactoryOne(
			@Qualifier(Database.DATASOURCE_NAME_ONE) final DataSource datasourceOne,
			ResourceLoader resourceLoader
			) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactorybean = 
				new SqlSessionFactoryBean();
		sqlSessionFactorybean.setDataSource(datasourceOne);
		Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
				.getResources("classpath:mybatis/dbone/*.xml");
		sqlSessionFactorybean.setMapperLocations(resources);
		return sqlSessionFactorybean;
	}
	@Bean
	public MapperScannerConfigurer mapperScannerConfigureDbOne() throws Exception {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryOne");
		mapperScannerConfigurer.setBasePackage("com.dtb.springdatabase.model.mappers.dbone");
		return mapperScannerConfigurer;
	}
	@Bean(name = "sqlSessionFactoryTwo")
	public SqlSessionFactoryBean sqlSessionFactoryTwo(
			@Qualifier(Database.DATASOURCE_NAME_TWO) final DataSource datasourceOne,
			ResourceLoader resourceLoader
			) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactorybean = 
				new SqlSessionFactoryBean();
		sqlSessionFactorybean.setDataSource(datasourceOne);
		Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
				.getResources("classpath:mybatis/dbtwo/*.xml");
		sqlSessionFactorybean.setMapperLocations(resources);
		return sqlSessionFactorybean;
	}
	@Bean
	public MapperScannerConfigurer mapperScannerConfigureDbTwo() throws Exception {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryTwo");
		mapperScannerConfigurer.setBasePackage("com.dtb.springdatabase.model.mappers.dbtwo");
		return mapperScannerConfigurer;
	}
}
