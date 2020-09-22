package com.cloudxpert.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
        http.cors()
            .and()
              .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v1/student/list").permitAll()
                //.antMatchers(HttpMethod.POST, "/v1/student").hasAuthority("SCOPE_StudentService-write")
                .anyRequest()
                  .authenticated()
            .and()
              .oauth2ResourceServer().jwt();
         
        
    }
}
