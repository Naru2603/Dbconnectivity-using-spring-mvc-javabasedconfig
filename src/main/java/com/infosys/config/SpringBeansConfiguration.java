package com.infosys.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.infosys")
public class SpringBeansConfiguration {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp" );
		
		return vr;
	}
	
	public DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring-mvc-webapp");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		
		sf.setDataSource(dataSource()); //manually set Datasource to sessionfactory
		sf.setPackagesToScan("com.infosys.entity");
		sf.setHibernateProperties(readHibernateProperties()); //set hibernate porperties
		
		return sf;
	}

	private Properties readHibernateProperties() {
		
		Properties props = new Properties();
		
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		
		return props;
	}
}
