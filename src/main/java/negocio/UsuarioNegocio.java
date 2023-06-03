package negocio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import dao.UsuarioDao;
import entidad.Usuario;

public class UsuarioNegocio {

	private UsuarioDao usuarioDao;
	static ApplicationContext appContext;
	
	public boolean agregarUsuario(Usuario usuario)
	{
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
	
	public static ApplicationContext getAppContext() {
		return appContext;
	}

	public static void setAppContext(ApplicationContext appContext) {
		UsuarioNegocio.appContext = appContext;
	}

	public void initBeanUsuarioNeg() {
		System.out.println("Se inicia el Bean Usuario Negocio.");
	}
	
	public void destroyBeanUsuarioNeg() {
		System.out.println("Se destruye el Bean Usuario Negocio.");
	}
}
