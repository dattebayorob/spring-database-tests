package com.dtb.springdatabase.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.dtb.springdatabase.repository")
public class DatabaseConfig {
		
}
