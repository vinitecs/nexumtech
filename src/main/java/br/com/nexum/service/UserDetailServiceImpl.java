package br.com.nexum.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.nexum.dto.CredenciaisDTO;
import br.com.nexum.security.UserSS;

public class UserDetailServiceImpl implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if(username == null) {
			// returnar o erro ;
		}
	
		
		CredenciaisDTO cred = new CredenciaisDTO();
		return new UserSS();
	}

}
