package com.springboot.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class MyConfiguration {

	@Bean(name = "primaryDS") 
	@Qualifier("primaryDS")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
//	@Bean(name = "secondaryDS") 
//	@Qualifier("secondaryDS")
//	@ConfigurationProperties(prefix="springboot.secondary.datasource")
//	public DataSource secondaryDataSource() {
//		return DataSourceBuilder.create().build();
//	}
}

