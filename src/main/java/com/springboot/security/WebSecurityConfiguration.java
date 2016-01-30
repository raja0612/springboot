package com.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author RAJASHEKHAR
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	 @Autowired
	 private UserDetailsService userDetailsService;
	
	
	@Autowired
	public void globalSecuirtyAuthentcation(AuthenticationManagerBuilder auth) throws Exception{
		/*This is example is for in memory authentications means predefined user credentials
		 * 
		 * auth.inMemoryAuthentication()
		.withUser("user")
		.password("user@123")
		.roles("USER");
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("admin")
		.roles("USER","ADMIN");*/
		
		
		
		
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}

}
