package com.example.OneSoftSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter {
	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("sekar").password("$2a$12$WfcocGLCmA0AUNv8I2sROe24UXw6QDgW1itxrCwsKwJGZngxKEuHS").roles("Student");
//	}
//	@Bean
//	public PasswordEncoder getPass() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	@Bean
//	public PasswordEncoder getPassword() {
//		return new BCryptPasswordEncoder(10);
//	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Sekar").password("$2a$12$vVKgI7rSTtWGmnhsLwBmiOPyE9imw06ZY6ds6u7Rx7Sp9J1P9N4Y2").roles("student").and().withUser("Ajay").password("$2a$12$uYSWW9HPRJku91A1uR66Z.e9/oWGMAPA29fMQ46o15PWeefBgsTSm").roles("trainer").and().withUser("Aravind").password("$2a$12$fHpP2xClnQUxW/95nAuaYOM4RsM8r2HxoQ8gQi0Xp8Sa9xDM6I.nu").roles("manager");
	}
	@Bean 
	public PasswordEncoder getPass() {
		return new BCryptPasswordEncoder(12);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/manager").hasRole("manager");
		http.authorizeRequests().antMatchers("/trainer").hasAnyRole("trainer","manager");
		http.authorizeRequests().antMatchers("/student").permitAll().and().formLogin();
	  
	}

}
