//package com.jk.carfullstackapp;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(
//                (authz) -> authz.anyRequest().authenticated()
//        ).httpBasic(withDefaults());
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//}
