package br.com.nexum.dto;

import java.util.HashSet;
import java.util.Set;

public class CredenciaisDTO {
	
	private Integer id;
	private String user;
	private String password;
	private String email;
	private Set<Integer> perfis = new HashSet<>();
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Integer> getPerfis() {
		return perfis;
	}
	public void setPerfis(Set<Integer> perfis) {
		perfis.add(perfis.getCod());
	}
	
	

}
