package com.mystic;

import com.mystic.user.domain.User;
import com.mystic.user.infrastructure.channels.UserChannels;
import com.mystic.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Putrenkov Pavlo
 */
//@PropertySource({"classpath:application.yml"})
//@PropertySource({"classpath:bootstrap.yml"})
//@EnableCircuitBreaker
//@EnableDiscoveryClient
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableBinding({UserChannels.class})
//@EnableFeignClients
//@EnableResourceServer
public class PhoneBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



    @Configuration
    @Profile("dev")
    @RequiredArgsConstructor
    public class DevConfig implements CommandLineRunner {
        public static final long  DEV_USER_ID = -1L;
        private final UserRepository userRepository;

        @Component
        @Order(Ordered.HIGHEST_PRECEDENCE)
        class CorsFilter implements Filter {
            public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

                HttpServletResponse response = (HttpServletResponse) res;
                HttpServletRequest request = (HttpServletRequest) req;

                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
                response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
                response.setHeader("Access-Control-Max-Age", "4800");

                if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
                    response.setStatus(HttpServletResponse.SC_OK);
                } else {
                    chain.doFilter(request, response);
                }
            }

            public void init(FilterConfig filterConfig) {
            }

            public void destroy() {
            }
        }


        @Override
        public void run(String... strings) throws Exception {
            if (!userRepository.exists(-1L)) {
                userRepository.save(new User(DEV_USER_ID, "test"));
            }
        }
    }


    @Configuration
    @Profile("cloud")
    @EnableDiscoveryClient
    @EnableBinding({UserChannels.class})
    @EnableFeignClients
    @EnableResourceServer
    @RequiredArgsConstructor
    class CloudConfig extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/**").authenticated();
        }
    }

//@Configuration
//class Config {
//
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//
//}
}