package br.ufc.quixada.validator;

import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.dao.UsuarioDao;
import br.ufc.quixada.model.Usuario;

public class EmailValidator implements CustomValidationStrategy<Usuario>{

	@Inject private UsuarioDao udao;
	@Inject private ValidationStrategyHelper helper;
	
	public void addErrors(Usuario usuario) {
		if(usuario == null){
			helper.addError("usuario.invalido");
		}else{
			if(!udao.existeEmail(usuario)){
				helper.addError("usuario.email.inexistente");
			}
		}
	}
	
}
