/*package com.training.spring.contactsmanagementsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
//@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${user.namee}")
	String userName;
	@Value("${user.passwordd}")
	String password;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("antony").password("{noop}antony").roles("USER");
//		System.out.println(userName);
		auth.inMemoryAuthentication().withUser(userName).password(password).roles("USER");
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		httpSecurity.csrf().disable();
	}

}
*/