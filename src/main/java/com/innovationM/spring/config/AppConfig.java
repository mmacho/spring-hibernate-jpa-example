package com.innovationM.spring.config;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.innovationM.spring.dao")
@EnableTransactionManagement
@ComponentScan({ "com.innovationM.spring.service" })
public class AppConfig {

	// @Bean
	// public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	// throws PropertyVetoException {
	// LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
	// LocalContainerEntityManagerFactoryBean();
	// entityManagerFactoryBean.setDataSource(dataSource());
	// entityManagerFactoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
	// entityManagerFactoryBean.setPersistenceXmlLocation("META-INF/persistence.xml");
	// entityManagerFactoryBean.setJpaVendorAdapter(new
	// HibernateJpaVendorAdapter());
	// entityManagerFactoryBean.setPackagesToScan("com.innovationM.spring.entity");
	// Properties jpaProperties = new Properties();
	// jpaProperties.put("hibernate.dialect",
	// "org.hibernate.dialect.H2Dialect");
	// entityManagerFactoryBean.setJpaProperties(jpaProperties);
	// return entityManagerFactoryBean;
	//
	// }

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
		return factoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws PropertyVetoException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	// @Bean
	// public ComboPooledDataSource comboPooledDataSource() throws
	// PropertyVetoException {
	// ComboPooledDataSource dataSource = new ComboPooledDataSource();
	// dataSource.setDriverClass("org.h2.Driver");
	// dataSource.setJdbcUrl("jdbc:h2:mem:bookstore1");
	// dataSource.setUser("sa");
	// dataSource.setPassword("");
	// dataSource.setMinPoolSize(5);
	// dataSource.setMaxPoolSize(20);
	// return dataSource;
	// }

	// @Bean
	// public DataSource dataSource() {
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName("org.h2.Driver");
	// dataSource.setUrl("jdbc:h2:mem:bookstore:db;DB_CLOSE_DELAY=-1");
	// dataSource.setUsername("sa");
	// dataSource.setPassword("sa");
	//
	// return dataSource;
	// }

	// @Bean
	// public PlatformTransactionManager transactionManager() {
	//
	// JpaTransactionManager txManager = new JpaTransactionManager();
	// txManager.setEntityManagerFactory(entityManagerFactory(dataSource()).getObject());
	// return txManager;
	//
	// }

}
