package principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entidad.Usuario;
import negocio.UsuarioNegocio;
import resources.Config;

public class Main {

	private static ApplicationContext appContext;
	
	public static void main(String[] args) {
		
		appContext = new AnnotationConfigApplicationContext(Config.class);
		
		Usuario usuario = (Usuario)appContext.getBean("usuarioPepe");
		
	    UsuarioNegocio usuarioNegocio = (UsuarioNegocio)appContext.getBean("usuarioNegocio");
	    UsuarioNegocio.setAppContext(appContext); /// Se setea instancia del appContext actual al negocio - Evita init y destroy duplicados.
	    boolean estado= usuarioNegocio.agregarUsuario(usuario);
	    
	    ((ConfigurableApplicationContext)(appContext)).close();
	    if(estado)
    		{System.out.println("Se agrego correctamente");}
	    else
    		{System.out.println("No se pudo agregar, el usuario ya existe en la BD");}
	}	
}
