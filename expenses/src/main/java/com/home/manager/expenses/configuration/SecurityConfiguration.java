package com.home.manager.expenses.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
//        return http
//                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
//                .build();
//    }
//}