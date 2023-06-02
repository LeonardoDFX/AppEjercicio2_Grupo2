package negocio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.UsuarioDao;
import entidad.Usuario;
import resources.Config;

public class UsuarioNegocio {

	private UsuarioDao usuarioDao;
	
	public boolean agregarUsuario(Usuario usuario)
	{
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);

		usuarioDao = (UsuarioDao)appContext.getBean("usuarioDao");
		boolean existe = usuarioDao.Exist(usuario.getUsuario());
		if(existe ==false)
		{
			usuarioDao.Add(usuario);
			((ConfigurableApplicationContext)(appContext)).close();
			return true;
		}
		

		((ConfigurableApplicationContext)(appContext)).close();
		return false;
	}
}
