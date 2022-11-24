package br.com.nexum.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;


@Service
@Path("/emp")
public class EmpresaService {
	
	
	@POST
	@Path("/cadastrar")
	@Produces({MediaType.APPLICATION_JSON})
	public String cadEmp(@FormParam("id_empresa") String dadosEmp) {
		
		return "O lula não vai subir a rampa";
	} 

}
