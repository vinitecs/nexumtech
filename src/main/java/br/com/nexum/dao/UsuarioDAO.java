package br.com.nexum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.nexum.Enum.Perfil;
import br.com.nexum.base.Bean;
import br.com.nexum.base.DAO;
import br.com.nexum.dto.CredenciaisDTO;

@Repository
public class UsuarioDAO extends DAO {
	
	private final RowMapper<CredenciaisDTO> rowMapper = new RowMapper<CredenciaisDTO>(){
	     

		public CredenciaisDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CredenciaisDTO usr = new CredenciaisDTO();
        	
        	usr.setId(rs.getInt("usuario_id"));
        	usr.setUser(rs.getString("usuario"));
        	usr.setPassword(rs.getString("senha"));        	
        	usr.setEmail(rs.getString("email"));        
        	usr.setPerfis(Perfil.getCod(rs.getInt("perfil")));    
  
      	
        	return usr;
        }
	};
	

	@Override
	protected Object post(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object insert(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object update(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getAll(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object findById(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<?> getByFilter(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Bean object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillParameters(Bean object) {
		// TODO Auto-generated method stub
		
	}
	public CredenciaisDTO Auth(String user) {
		String sql= "";
		
		return jdbcTemplate.query(sql , RowMapper);
	}

}
