package com.cloudxpert.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class Oauth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		
        http.cors()
            .and()
              .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v1/student/list").permitAll()
                .anyRequest()
                  .authenticated()
            .and()
              .oauth2ResourceServer()
              .jwt();
              
         
        
    }
	
	
}
