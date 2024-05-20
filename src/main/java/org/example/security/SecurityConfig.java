//package org.example.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
////                .antMatchers("/login", "/styles.css", "/scripts.js").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .addFilterBefore(otpAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
////                .formLogin()
////                .loginPage("/login")
////                .loginProcessingUrl("/login")
////                .defaultSuccessUrl("/home", true)
////                .permitAll()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Bean
//    public OTPAuthenticationFilter otpAuthenticationFilter() {
//        return new OTPAuthenticationFilter();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
