package br.ufc.quixada.validator;

import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.model.Comentario;

public class ComentarioValidator implements CustomValidationStrategy<Comentario>{
	
	@Inject private ValidationStrategyHelper helper;
	
	public void addErrors(Comentario comentario) {
		if(comentario == null)
			helper.addError("comentario.invalido");
	}
	
}
