package br.ufc.quixada.validator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.model.Noticia;

@RequestScoped
public class NoticiaValidator implements CustomValidationStrategy<Noticia>{
	
	@Inject private ValidationStrategyHelper helper;
	
	@Override
	public void addErrors(Noticia noticia){
		if(noticia == null){
			helper.addError("noticia.invalida");
		}else{
			
			if(noticia.getSecao() == null)
				helper.addError("noticia.secao.invalida");
			
			if(noticia.getTitulo() == null || noticia.getTitulo().equals(""))
				helper.addError("noticia.titulo.invalido");
			
			if(noticia.getSubtitulo() == null || noticia.getSubtitulo().equals(""))
				helper.addError("noticia.subtitulo.invalido");
			
			if(noticia.getData() == null)
				helper.addError("noticia.data.invalida");
			
			if(noticia.getImagem() == null || noticia.getImagem().equals(""))
				helper.addError("noticia.imagem.invalida");
			
			if(noticia.getTexto() == null || noticia.getTexto().equals(""))
				helper.addError("noticia.texto.invalido");
		}
	}
}