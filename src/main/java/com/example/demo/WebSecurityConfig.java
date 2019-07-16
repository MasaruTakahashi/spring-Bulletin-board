package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}

	@Override
	public void configure(WebSecurity web)throws Exception{
		web.ignoring().antMatchers("/images/**","/css/**","/javascript/**");
	}

	@Override
	public void configure(HttpSecurity http)throws Exception{
		http
		.authorizeRequests()
		.anyRequest().authenticated().and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/userEntry")
		.usernameParameter("login_id")
		.passwordParameter("password")
		.successForwardUrl("/threadList")
		.failureUrl("/login?error")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth
		.inMemoryAuthentication()
		.withUser("login_id").password("{noop}password").roles("user");
	}
}
