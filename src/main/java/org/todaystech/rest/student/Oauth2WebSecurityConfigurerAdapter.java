package org.todaystech.rest.student;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
	 * Configure Oauth 2 server support
	 * 
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {		
        http.cors()
            .and()
            .oauth2ResourceServer()
            .jwt();
           
    }
}
