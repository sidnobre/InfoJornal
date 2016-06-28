package br.ufc.quixada.validator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.dao.UsuarioDao;
import br.ufc.quixada.model.Usuario;

@RequestScoped
public class UsuarioValidator implements CustomValidationStrategy<Usuario> {
	
	private final String NOME_REGEX = "^[a-zA-Zà-úÀ-Ú]+[a-zA-Zà-úÀ-Ú ]*$";
	private final String EMAIL_REGEX = "^[a-zA-Z]+[a-zA-Z0-9]*([._-]{0,1}[a-zA-Z0-9]+){0,3}@[a-zA-Z0-9]+.[a-zA-Z]+$";
	private final String LOGIN_REGEX = "^([a-zA-Z]+[a-zA-Z0-9]*){4,20}$";
	@Inject private ValidationStrategyHelper helper;
	@Inject private UsuarioDao udao;
	
	public void addErrors(Usuario usuario) {
		if(usuario == null){
			helper.addError("usuario.invalido");
		}else{
			if(usuario.getNome() == null || usuario.getNome() == "" || !usuario.getNome().matches(NOME_REGEX))
				helper.addError("usuario.nome.invalido");
			
			if(usuario.getEmail() == null || usuario.getEmail() == "" || !usuario.getEmail().matches(EMAIL_REGEX))
				helper.addError("usuario.email.invalido");
			
			if(udao.existeEmail(usuario))
				helper.addError("usuario.email.indisponivel");
			
			if(usuario.getLogin() == null || usuario.getLogin() == "" || !usuario.getLogin().matches(LOGIN_REGEX))
				helper.addError("usuario.login.invalido");
			
			if(udao.existeLogin(usuario))
				helper.addError("usuario.login.indisponivel");
			
			if(usuario.getSenha() == null || usuario.getSenha() == "" || usuario.getSenha().length() < 6)
				helper.addError("usuario.senha.invalida");
		}
	}
}
