package com.example.parking_system.Config;

import com.example.parking_system.Service.MyUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;

    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {//use database info
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {// welcome page
        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/register","api/v1/reservation/**").permitAll()
                .antMatchers("/api/v1/register/checkreservation").hasAnyAuthority("security man","owner")
//                .antMatchers("api/v1/payment")
                .antMatchers("api/v1/park").hasAnyAuthority("owner")
                .anyRequest().authenticated()
                .and().httpBasic();


    }
}
