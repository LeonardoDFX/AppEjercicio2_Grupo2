package principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entidad.Usuario;
import negocio.UsuarioNegocio;
import resources.Config;

public class Main {

	public static void main(String[] args) {
		
     	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
	    UsuarioNegocio usuarioNegocio = (UsuarioNegocio)appContext.getBean("usuarioNegocio");
	    Usuario usuario = (Usuario)appContext.getBean("usuarioPepe");
	    boolean estado= usuarioNegocio.agregarUsuario(usuario);

	    if(estado)
    		{System.out.println("Se agrego correctamente");}
	    else
    		{System.out.println("No se pudo agregar, el usuario ya existe en la BD");}
    
	    ((ConfigurableApplicationContext)(appContext)).close();
	}	
}
