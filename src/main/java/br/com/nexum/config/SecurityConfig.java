package br.com.nexum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.nexum.security.JWTAuthenticationFilter;
//import br.com.lab.security.JWTAuthenticationFilter;
//import br.com.lab.security.JWTAuthorizationFilter;
import br.com.nexum.security.JWTUtil;
import br.com.nexum.security.UserSS;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled =  true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	private static String[] PUBLIC_ANY_MATCHERS = {
			
	};
	private static String[] PUBLIC_MATCHERS_GET = {
			
	};
	private static String[] PUBLIC_MATCHERS_POST = {
			"/rest/**",
			"/**"
	} ;
	
	@Override
	protected  void configure (HttpSecurity http) throws Exception{
		
		http.cors().and().csrf().disable();
		http.authorizeHttpRequests()		
		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
		.antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll()
		.antMatchers(PUBLIC_ANY_MATCHERS).permitAll()
		.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(),jwtUtil));
		//http.addFilter(new JWTAuthorizationFilter(authenticationManager(),jwtUtil,userDetaislService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
	

	
	@Bean
	UrlBasedCorsConfigurationSource CorsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}


	@Bean 
	BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder(); 
	}
	
}
