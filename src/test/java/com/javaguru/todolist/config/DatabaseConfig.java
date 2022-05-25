package com.javaguru.todolist.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DatabaseConfigBean databaseConfigBean() {
        var configBean = new DatabaseConfigBean();
        configBean.setCaseSensitiveTableNames(false);
        configBean.setDatatypeFactory(new H2DataTypeFactory());
        return configBean;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(
            DataSource dataSource,
            DatabaseConfigBean databaseConfigBean
    ) throws SQLException {
        var factoryBean = new DatabaseDataSourceConnectionFactoryBean();
        factoryBean.setSchema(dataSource.getConnection().getSchema());
        factoryBean.setDataSource(dataSource);
        factoryBean.setDatabaseConfig(databaseConfigBean);
        return factoryBean;
    }
}
