package com.disneyApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.disneyApp.config.CustomAccessDeniedHandler;
import com.disneyApp.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers
		("/", "/error", "/forbidden" , "/layouts", "/login"
				, "/usuario/registro" , "/usuario/save","/uploads/**","/js/**","/css/**", "/pelicula/ver-comentarios/**", "/cargar-peli")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/signin").loginPage("/login").permitAll().defaultSuccessUrl("/")
		.failureUrl("/login?error=true")
		.usernameParameter("username").passwordParameter("password")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
		
	}
	
	
	
}
