package br.ufc.quixada.util;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;


public class AppConfig {
	
	public static final String HOME = System.getProperty("user.home");

	@ApplicationScoped
	public void config(@Observes VRaptorInitialized initialized){
		System.out.println("INICIANDO A CONFIGURAÇÃO NECESSÁRIA PARA A APLICAÇÃO. . .");
		File path = new File(HOME, "uploads");
		path.mkdir();
		System.out.println("CONFIGURAÇÃO DA APLICAÇÃO FINALIZADA.");
	}
}
