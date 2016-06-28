package br.ufc.quixada.util;

import javax.enterprise.context.RequestScoped;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@RequestScoped
public class EmailSender {
	
	@SuppressWarnings("deprecation")
	public void enviar(String destino, String login, String novaSenha){
		try {
			SimpleEmail mailer = new SimpleEmail();
			mailer.setFrom("no-reply@infojornal.com","Sistema");
			mailer.addTo(destino);
			mailer.setSubject("Nova senha de acesso");
			mailer.setMsg("Para acessar o sistema utilize:\n\nUsuario: "+login+"\n\nSenha: "+novaSenha);
			mailer.setHostName("smtp.gmail.com");
			mailer.setAuthentication("", "");
			mailer.setSmtpPort(587);
			mailer.setSSL(true);
			mailer.setTLS(true);
			mailer.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
