package com.example.spring.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;

import com.example.spring.filter.TokenGenerationFilter;
import com.example.spring.filter.TokenValidationFilter;

@Configuration
@ComponentScan(basePackages = "com.examole")
public class SecurityConfig {

    @Bean
    SecurityFilterChain customDefaultFilter(HttpSecurity http) throws Exception {
        http.
                addFilterAfter(new TokenGenerationFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidationFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/person/login").permitAll()
                        .requestMatchers("/getUser").hasAnyRole("BASIC","ADMIN")
                        .requestMatchers("/addUser").hasRole("ADMIN")
                        .anyRequest().authenticated()).csrf().disable();
        http.httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
