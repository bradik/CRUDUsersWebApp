package com.bradik.webapp.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Created by Brad on 30.06.2017.
 */

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.bradik.webapp")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //System.out.println("Load configurations ... ");

        registry.addResourceHandler("/resources/angular-1.6.1/**")
                .addResourceLocations("/resources/angular-1.6.1/");
        registry.addResourceHandler("/resources/app/**")
                .addResourceLocations("/resources/app/");
        registry.addResourceHandler("/resources/user/**")
                .addResourceLocations("/resources/user/");
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public SessionFactory sessionFactory() {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());
        sessionBuilder.scanPackages("com.bradik")
        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
        .setProperty("hibernate.show_sql", "true")
        .setProperty("hibernate.id.new_generator_mappings","false");


        return sessionBuilder.buildSessionFactory();
    }

    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/test" +
                "?createDatabaseIfNotExist=true&useSSL=false" +
                "&useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        return dataSource;
    }

}
