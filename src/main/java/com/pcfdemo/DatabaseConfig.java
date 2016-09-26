//package com.pcfdemo;
//
//import javax.sql.DataSource;
//
//import org.springframework.cloud.service.relational.CloudDataSourceFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//public class DatabaseConfig {
//
//	@Bean("pcfdemo_mysql")
//	@Profile("cloud")
//	public DataSource dataSource(){
//		CloudFactory cloudFactory = new CloudFactory();
//		Cloud cloud = cloudFactory.getCloud();
//		List<ServiceInfo> databaseInfos = cloud.getServiceInfos( DataSource.class);
//	}
//	
//}
