package com.demo.accesscontrol;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * @author Tushar mahajan
 *
 */
@Configuration
@EnableJpaAuditing
@EnableWebSecurity
@ComponentScan(basePackages = {"com.demo.accesscontrol.entity"})//repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class
public class MyConfig extends WebSecurityConfigurerAdapter {
	
	//@Override protected void configure(AuthenticationMangerBuilder auth) throws Exception { //final HttpSecurity http  
		
		@Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/**");
	    
		/*
		 * http.antMatcher("/**") .authorizeRequests() .antMatchers("/").permitAll().se
		 * .anyRequest() .authenticated() .and() .httpBasic() .and() .csrf().disable();
		 */
        
//        .antMatchers("/employee", "/insurance").hasRole("User")
		/*
		 * .anyRequest() .authenticated() .and() .httpBasic() .and() .csrf().disable();
		 */        
//            .anyRequest().authenticated().and().formLogin();  
    }  
	//@Autowired
//	AuthenticationManager authenticationManager;
	// AuthenticationManager am;
	// 
	/*
	 * @Bean public UserDetailsService userDetailsService() { return null;//new
	 * UserDetailsService(); }
	 * 
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService());
	 * authProvider.setPasswordEncoder(passwordEncoder());
	 * 
	 * return authProvider; }
	 * 
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(authenticationProvider()); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .anyRequest().authenticated() .and()
	 * .formLogin().permitAll() .and() .logout().permitAll(); }
	 */
}
