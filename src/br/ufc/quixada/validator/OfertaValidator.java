package br.ufc.quixada.validator;

import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.util.Oferta;

public class OfertaValidator implements CustomValidationStrategy<Oferta>{

	@Inject private ValidationStrategyHelper helper;
	
	@Override
	public void addErrors(Oferta oferta) {
		if(oferta == null){
			helper.addError("oferta.invalida");
		}else{
			if(oferta.getAutor() == null)
				helper.addError("oferta.autor.invalido");
			
			if(oferta.getData() == null)
				helper.addError("oferta.data.invalida");
			
			if(oferta.getValor() == null || oferta.getValor().isNaN() || oferta.getValor() <= oferta.getUltimaOferta())
				helper.addError("oferta.valor.invalido");
		}
	}
	
}
