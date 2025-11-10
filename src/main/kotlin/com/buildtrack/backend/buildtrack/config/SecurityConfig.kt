package com.buildtrack.backend.buildtrack.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

// ================= DEV =================
// Полностью отключаем security для профиля dev
@Configuration
@Profile("dev")
class DevSecurityConfig {

    @Bean
    fun devFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .authorizeHttpRequests { it.anyRequest().permitAll() }
        return http.build()
    }
}

// ================= PROD =================
// Включаем Basic Auth для профиля prod
@Configuration
@Profile("prod")
class ProdSecurityConfig {

    @Bean
    fun prodFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .authorizeHttpRequests { it.anyRequest().authenticated() }
            .httpBasic()
        return http.build()
    }
}