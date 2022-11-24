package br.com.nexum.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    
    public JerseyConfig() {
    	System.out.println("passou com jersey");
    	packages("br.com.nexum");    	
        
    }
}
