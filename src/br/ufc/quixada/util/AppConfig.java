package br.ufc.quixada.util;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.events.VRaptorInitialized;

@ApplicationScoped
public class AppConfig {
	
	public static final String HOME = System.getProperty("user.home");
	private SimpleEmail mailer;

	@SuppressWarnings("deprecation")
	public void config(@Observes VRaptorInitialized initialized){
		File path = new File(HOME, "app-root");
		path.mkdir();
		
		File path2 = new File(path.getAbsolutePath(), "data");
		if(path2.mkdir());
				
		File path3 = new File(path2.getAbsolutePath(), "uploads");
		path3.mkdir();
		
		mailer = new SimpleEmail();
		try {
			mailer.setHostName("smtp.gmail.com");
			mailer.setFrom("no-reply@infojornal.com","Sistema");
			mailer.setAuthentication("", "");
			mailer.setSmtpPort(587);
			mailer.setSSL(true);
			mailer.setTLS(true);
		} catch (EmailException e) {
			System.out.println("VERIFIQUE AS CONFIGURAÇÕES DO SMTP SERVER NA CLASSE:\nbr.ufc.quixada.util.AppConfig");
			//e.printStackTrace();
		}
	}
	
	public SimpleEmail getMailer(){
		return mailer;
	}
}
