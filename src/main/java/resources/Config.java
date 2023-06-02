package resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.UsuarioDao;
import entidad.Usuario;
import negocio.UsuarioNegocio;

@Configuration
public class Config {

	@Bean (initMethod = "initUsuarioBean", destroyMethod = "destroyUsuarioBean")
	public Usuario usuarioPepe() {
		Usuario usuarioPepe = new Usuario();
		usuarioPepe.setUsuario("Pepe");
		usuarioPepe.setContrasenia("123");
		return usuarioPepe;
	}

	@Bean
	public UsuarioNegocio usuarioNegocio() {
		return new UsuarioNegocio();
	}

	@Bean
	public UsuarioDao usuarioDao() {
		return new UsuarioDao();
	}
}
