package br.ufc.quixada.util;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;

@ApplicationScoped
public class AppConfig {
	
	public static final String HOME = System.getProperty("user.home");

	public void config(@Observes VRaptorInitialized initialized){
		File path = new File(HOME, "uploads");
		path.mkdir();
	}
}
