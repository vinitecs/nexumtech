package br.com.nexum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.nexum.dao.UsuarioDAO;
import br.com.nexum.dto.CredenciaisDTO;
import br.com.nexum.security.UserSS;
@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UsuarioDAO dao ;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if(username == null) {
			// returnar o erro ;
		}
	
		
		CredenciaisDTO user  =(CredenciaisDTO) dao.Auth(username);
		
		
		
		return new UserSS(user.getId(),user.getUsuario(),user.getSenha(), user.getPerfis());
	}

}
