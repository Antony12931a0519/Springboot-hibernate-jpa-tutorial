/*package com.training.spring.contactsmanagementsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${user.namee}")
	private String userName;
	
	@Value("${user.passwordd}")
	private String password;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(userName).password("{noop}"+password).roles("USER");
	}
}
*/