//package com.mystic.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * @author Pavel Putrenkov
// * @version 1.0
// */
//@Configuration
//@EnableAuthorizationServer
//@EnableResourceServer
//public class ResourceOAuthSecurityConfiguration extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/maintenance/**").permitAll();
//        http.authorizeRequests().antMatchers("/oauth/**", "/principal").authenticated();
//    }
//}
