package com.dafoo.config;

import com.dafoo.config.service.MemberDetailService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/main", "/index", "/member/login", "/member/register", "/api/**", "/assets/**", "/css/**").permitAll()
                .antMatchers("/food/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/member/login")
                .loginProcessingUrl("/member/loginProcess")
                .usernameParameter("email")
                .passwordParameter("pw")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/member/logout")
                .permitAll()
                .and()
                .headers(headers -> headers.cacheControl(cache -> cache.disable()));
        http
                .csrf().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
