package com.academia.fikefino.config;

import com.academia.fikefino.services.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {

    private final UserDetailService userDetailService;

    public WebConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(encoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
            .requestMatchers("/css/**", "/img/**", "/admin/cadastro").permitAll()
            .requestMatchers("/admin/funcionarios")
            .hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/admin/login")
            .defaultSuccessUrl("/aluno")
            .permitAll();

        return http.build();
    }

}