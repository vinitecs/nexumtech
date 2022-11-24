package br.com.nexum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

//import br.com.lab.security.JWTAuthenticationFilter;
//import br.com.lab.security.JWTAuthorizationFilter;
import br.com.nexum.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =  true)
public class SecurityConfig {
	@Autowired
	JWTUtil jwtUtil;
	
	private static String[] PUBLIC_ANY_MATCHERS = {
			"/rest/**"
	};
	@Bean
	protected  SecurityFilterChain configure (HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable();
		http.authorizeHttpRequests()		
		//.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
		//.antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll()
		.antMatchers(PUBLIC_ANY_MATCHERS).permitAll()
		.anyRequest().authenticated();
	//	http.addFilter(new JWTAuthenticationFilter(authenticationManager(),jwtUtil));
		//http.addFilter(new JWTAuthorizationFilter(authenticationManager(),jwtUtil,userDetaislService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
	
	
	@Bean
	UrlBasedCorsConfigurationSource CorsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}	
	
	
	@Bean 
	BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder(); 
	}

	
}
