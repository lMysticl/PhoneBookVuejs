package com.mystic.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Putrenkov Pavlo
 */
@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class AdditionalWebConfig implements WebMvcConfigurer {
    /**
     * Allowing all origins, headers and methods here is only intended to keep this example simple.
     * This is not a default recommended configuration. Make adjustments as
     * necessary to your use case.
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }


//    private    CorsSupportProperties corsSupportProperties = new CorsSupportProperties();
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//
//        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(corsSupportProperties.isAllowCredentials());
//        corsConfiguration.addAllowedOrigin(corsSupportProperties.getAllowOrigin());
//        corsConfiguration.addAllowedHeader(corsSupportProperties.getAllowHeader());
//        corsConfiguration.addAllowedMethod(corsSupportProperties.getAllowMethod());
//
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//
//        CorsFilter corsFilter = new CorsFilter(urlBasedCorsConfigurationSource);
//        FilterRegistrationBean registration = new FilterRegistrationBean(corsFilter);
//        registration.addUrlPatterns("/*");
//        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return registration;
//    }



    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .maxAge(3600);
    }


}
