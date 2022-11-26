package br.com.nexum.Enum;

public enum Perfil {
	
			USUARIO(1,"ROLE_USUARIO"),
			GERENTE(2,"ROLE_GERENTE"),
			ADMINISTRADOR(3,"ROLE_ADMINISTRADOR");
			
			
			
			private Integer cod;
			private String descricao;
			
			
			private  Perfil(Integer cod, String descricao) {
				this.cod =cod;
				this.descricao = descricao;
			}

			public Integer getCod() {
				return cod;
			}
			
			public String getDescricao() {
				return descricao;
			}
			
			public static Perfil toEnum(Integer cod) {
				
				if(cod == null) {
					return null;
				}
				for(Perfil per: Perfil.values()) {
					if(per.getCod() == cod) {
						return per;
					}
					
				}
				throw new IllegalArgumentException("Id inválido: " + cod);
			}
}
