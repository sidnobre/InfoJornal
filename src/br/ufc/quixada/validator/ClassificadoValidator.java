package br.ufc.quixada.validator;

import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.model.Classificado;

public class ClassificadoValidator implements CustomValidationStrategy<Classificado>{
	
	private final String CONTATO_REGEX = "^\\([0-9]{2}\\)\\s[0-9]{5}-[0-9]{4}";
	@Inject ValidationStrategyHelper helper;
	
	@Override
	public void addErrors(Classificado classificado) {
		if(classificado == null){
			helper.addError("classificado.invalido");
		}else{
			if(classificado.getTitulo() == null || classificado.getTitulo().equals("") || classificado.getTitulo().length() > 250)
				helper.addError("classificado.titulo.invalido");
			
			if(classificado.getTexto() == null || classificado.getTexto().equals(""))
				helper.addError("classificado.texto.invalido");
			
			if(classificado.getPreco() == null || classificado.getPreco().isNaN() || classificado.getPreco() <= 0)
				helper.addError("classificado.preco.invalido");
			
			if(classificado.getContato() == null || classificado.getContato().equals("") || !classificado.getContato().matches(CONTATO_REGEX))
				helper.addError("classificado.contato.invalido");
		}
	}	
}