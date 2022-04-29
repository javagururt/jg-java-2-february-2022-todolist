package com.javaguru.todolist.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.javaguru")
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource,
                                         @Value("${spring.jpa.hibernate.ddl-auto}") String ddl,
                                         @Value("${spring.jpa.properties.hibernate.dialect}") String dialect,
                                         @Value("${spring.jpa.show-sql}") String showSql,
                                         @Value("${spring.jpa.properties.hibernate.package-scan}") String packageScan
    ) throws IOException {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(packageScan);
        var hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", ddl);
        hibernateProperties.setProperty("hibernate.dialect", dialect);
        hibernateProperties.setProperty("hibernate.show_sql", showSql);
        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.afterPropertiesSet();

        return sessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        var transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
