/*package com.evolvus.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			//http.authorizeRequests().anyRequest().authenticated();
			//http.authorizeRequests().antMatchers("/**").authenticated();
			http.authorizeRequests().antMatchers("/**").permitAll();
			http.authorizeRequests().antMatchers("*").permitAll();;
			http.authorizeRequests().antMatchers(HttpMethod.GET).permitAll();
			http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
			
	}
}
*/