package com.ict.edu3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//build.gradle에서 dependency에 import
//implementation 'org.springframework.boot:spring-boot-starter-security'

// @Configuration이라고 하면 설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션이다.
// @EnableWebSecurity 스프링 시큐리티 사용을 위한 어노테이션 선언 @Configuration 생략 가능
// @Configuration
@EnableWebSecurity
public class SecurityJavaConfig  {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/**").permitAll()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .formLogin()
            .disable()
            .cors();

            return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}