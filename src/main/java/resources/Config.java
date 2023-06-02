package resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import entidad.Usuario;
import negocio.UsuarioNegocio;

@Configuration
public class Config {

	@Bean
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
}
