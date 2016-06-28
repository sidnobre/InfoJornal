package br.ufc.quixada.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@RequestScoped
public class EmailSender {
	
	@Inject private AppConfig system;
	
	public void enviar(String destino, String login, String novaSenha){
		SimpleEmail mailer = system.getMailer();
		try {
			mailer.addTo(destino);
			mailer.setSubject("Nova senha de acesso");
			mailer.setMsg("Para acessar o sistema utilize:\n\nUsuario: "+login+"\n\nSenha: "+novaSenha);
			mailer.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
