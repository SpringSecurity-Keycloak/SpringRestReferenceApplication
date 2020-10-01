package com.cloudxpert.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class Oauth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	/**
	 * Allow access to the Swagger UI
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", 
				"/configuration/**", 
				"/swagger-resources/**",  
				"/swagger-ui.html", 
				"/swagger-ui/", 
				"/webjars/**", 
				"/api-docs/**");
    }
	
	/**
	 * Secure all endpoints under /v1 using OAuth 2 security. Fine grained role based access will be configured 
	 * using method level security at the RestController level
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {		
        http.cors()
            .and()
            .authorizeRequests()
            .antMatchers("/v1/*")
            .authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt();
           
    }
	
	
}
