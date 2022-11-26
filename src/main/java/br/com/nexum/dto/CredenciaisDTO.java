package br.com.nexum.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.nexum.Enum.Perfil;

public class CredenciaisDTO {
	
	private Integer id;
	private String usuario;
	private String senha;
	private Set<Integer> perfis = new HashSet<>();
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String user) {
		this.usuario = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String password) {
		this.senha = password;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		
		perfis.add(perfil.getCod());
	}
	
	

}
