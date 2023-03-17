package com.example.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.boot.autoconfigure.security.servlet.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.security.config.Customizer.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.http.MediaType;
// @Configuration
@EnableWebSecurity
public class WebSecuirtyConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            // 任意request皆須做登入
            // .authorizeHttpRequests()
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
            .formLogin(form -> form.loginPage("/loginTemplate").permitAll()
                .failureHandler(jsonAuthenticationFailureHandler())
                
                
                );
            // .formLogin(withDefaults())
            
            
            
            // .httpBasic(withDefaults());

        return http.build();
    }

    // @Bean
    // WebSecurityCustomizer webSecurityCustomizer(){
    //     return web -> web.ignoring()
    //     .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    // }

    // 
    private static AuthenticationFailureHandler jsonAuthenticationFailureHandler(){

        // return (request, response, authentication) -> {
        return (request, response, exception) -> {
            // 回傳失敗狀態
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            // response.setStatus(HttpStatus.OK.value());
            // 回傳資料型態
            ObjectMapper objectMapper = new ObjectMapper();
            Object data = Map.of("title","Login failed!","status","error");
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().println(objectMapper.writeValueAsString(data));
        };

    }
    
}
