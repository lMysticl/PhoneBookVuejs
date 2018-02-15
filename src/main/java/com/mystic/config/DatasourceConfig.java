package com.mystic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Putrenkov Pavlo
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.mystic.model.repository")
public class DatasourceConfig {

//    @Value("${spring.datasource.url}")
////    private String MYSQL_ADDRESS ;
////
////    @Value("${spring.datasource.password}")
////    private String MYSQL_PASSWORD;
////    @Value("${spring.datasource.username}")
////    private String MYSQL_USER;
////
////
////    @Value("${spring.datasource.driver-class-name}")
////    private String MYSQL_DRIVER;
    @Qualifier("dataSource")
    @Autowired
    private  DataSource dataSource;

//    @Bean
//    public DataSource datasource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
//        ds.setUrl(MYSQL_ADDRESS);
//        ds.setSchema(MYSQL_SCHEMA);
//        ds.setUsername(MYSQL_USER);
//        ds.setPassword(MYSQL_PASSWORD);
//        return ds;
//    }

//    @Bean
//    public BasicDataSource dataSource() throws URISyntaxException {
//        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
//
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setUrl(dbUrl);
//        basicDataSource.setUsername(username);
//        basicDataSource.setPassword(password);
//
//        return basicDataSource;
//    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }


//    @Bean
//    public BasicDataSource dataSource() {
//
//        BasicDataSource basicDataSource = new BasicDataSource();
////        basicDataSource.setDriverClassName(MYSQL_DRIVER);
//        basicDataSource.setUrl(MYSQL_ADDRESS);
//        basicDataSource.setUsername(MYSQL_USER);
//        basicDataSource.setPassword(MYSQL_PASSWORD);
//
//        return basicDataSource;
//    }




    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}