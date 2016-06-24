package br.ufc.quixada.validator;

import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.model.Secao;

public class SecaoValidator implements CustomValidationStrategy<Secao>{

	private final String TEXTO_REGEX = "^([a-zA-Zà-úÀ-Ú])+([a-zA-Zà-úÀ-Ú -/])*$";
	@Inject ValidationStrategyHelper helper;
	
	@Override
	public void addErrors(Secao secao) {
		
		if(secao == null){
			helper.addError("secao.invalida");
		}else{
			if(!secao.getTitulo().matches(TEXTO_REGEX))
				helper.addError("secao.titulo.invalido");
			
			if(!secao.getDescricao().matches(TEXTO_REGEX))
				helper.addError("secao.descricao.invalida");
		}
	}
	
}
