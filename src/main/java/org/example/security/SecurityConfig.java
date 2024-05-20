package org.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/js/*", "/home", "/css/*", "/").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(otpAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/home", true)
//                .permitAll()
//                .anyRequest()
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public OTPAuthenticationFilter otpAuthenticationFilter() throws Exception {
        OTPAuthenticationFilter filter = new OTPAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

