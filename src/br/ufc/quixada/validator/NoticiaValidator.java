package br.ufc.quixada.validator;

import java.text.SimpleDateFormat;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.model.Noticia;

@RequestScoped
public class NoticiaValidator implements CustomValidationStrategy<Noticia>{
	
	private final String DATA_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";
	@Inject private ValidationStrategyHelper helper;
	
	@Override
	public void addErrors(Noticia noticia){
		if(noticia == null){
			helper.addError("noticia.invalida");
		}else{
			System.out.println("VALIDANDO O FORM DE NOTICIAS");
			
			if(noticia.getSecao() == null){
				helper.addError("noticia.secao.invalida");
			}
			
			if(noticia.getTitulo() == null || noticia.getTitulo().equals("")){
				helper.addError("noticia.titulo.invalido");
			}
			
			if(noticia.getSubtitulo() == null || noticia.getSubtitulo().equals("")) helper.addError("noticia.subtitulo.invalido");
			
			if(noticia.getData() == null){
				helper.addError("noticia.data.invalida");
				noticia.setData(null);
			}else{
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String dataFormatada = format.format(noticia.getData());
				if(!dataFormatada.matches(DATA_REGEX)){
					helper.addError("noticia.data.invalida");
					noticia.setData(null);
				}
			}
			
			if(noticia.getImagem() == null || noticia.getImagem().equals("")) helper.addError("noticia.imagem.invalida");
			
			if(noticia.getTexto() == null || noticia.getTexto().equals("")) helper.addError("noticia.texto.invalido");
		}
	}
}