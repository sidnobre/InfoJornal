package br.ufc.quixada.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.simplemail.Mailer;

@RequestScoped
public class EmailSender {
	
	@Inject private Mailer mail;
	
	public void enviar(String destino, String login, String novaSenha){
		Email email = new SimpleEmail();
        email.setSubject("Nova senha de acesso");
        try {
			email.addTo(destino);
			email.setMsg("Para acessar o sistema utilize:\n\nUsuario: "+login+"\n\nSenha: "+novaSenha);
	        mail.send(email);
		} catch (EmailException e) {
			e.printStackTrace();
		}
		/*SimpleEmail mailer = new SimpleEmail();
		mailer.setHostName("smtp.gmail.com");
		try {
			mailer.addTo(email);
			mailer.setFrom("no-reply@infojornal.com","Sistema");
			mailer.setSubject("Nova senha de acesso");
			mailer.setMsg("Para acessar o sistema utilize:\n\nUsuario: "+login+"\n\nSenha: "+novaSenha);
			mailer.setAuthentication("usuario do email", "senha do email");
			mailer.setSmtpPort(465);
			mailer.setSSL(true);
			mailer.setTLS(true);
			mailer.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}*/	
	}
}
