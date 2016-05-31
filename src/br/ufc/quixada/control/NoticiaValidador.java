package br.ufc.quixada.control;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.model.Noticia;

public class NoticiaValidador {
	private final String DATA_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";
	@Inject private Validator validador;
	
	public void validarFormulario(Noticia noticia){
		String obrigatorioErro = "deve ser preenchido obrigatoriamente.";
		String desautorizado = "Este usuário não possui autorização para publicar notícias.";
		String dataErro = "A data informada é inválida.";
		String secaoErro = "Seleciona uma seção válida.";
		boolean secaoValida = !(noticia.getSecao() == null);
		boolean tituloValido = !noticia.getTitulo().isEmpty();
		boolean subtituloValido = !noticia.getSubtitulo().isEmpty();
		boolean textoValido = !noticia.getSubtitulo().isEmpty();
		boolean autorValido = !(noticia.getAutor() == null);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataTexto = format.format(noticia.getData());
		boolean dataValida = Pattern.compile(DATA_REGEX).matcher(dataTexto).matches();
		boolean imagemValida = !noticia.getImagem().isEmpty();
		
		validador.ensure(secaoValida, new SimpleMessage("noticia.secao.invalida", secaoErro, Severity.ERROR));
		validador.ensure(tituloValido, new SimpleMessage("noticia.titulo.invalido", obrigatorioErro, Severity.ERROR));
		validador.ensure(subtituloValido, new SimpleMessage("noticia.subtitulo.invalido", obrigatorioErro, Severity.ERROR));
		validador.ensure(textoValido, new SimpleMessage("noticia.texto.invalido", obrigatorioErro, Severity.ERROR));
		validador.ensure(autorValido, new SimpleMessage("noticia.autor.invalido", desautorizado, Severity.ERROR));
		validador.ensure(dataValida, new SimpleMessage("noticia.data.invalida", dataErro, Severity.ERROR));
		validador.ensure(imagemValida, new SimpleMessage("noticia.imagem.invalida", obrigatorioErro, Severity.ERROR));
		
		validador.onErrorUsePageOf(NoticiaController.class).formulario();
	}
	
	public void confirmaValidacao(){
		validador.add(new SimpleMessage("noticia.adicionada", "Notícia adicionada com sucesso!", Severity.SUCCESS));
	}
	
	public void confirmaRemocao(){
		validador.add(new SimpleMessage("noticia.removida", "Notícia removida com sucesso!", Severity.SUCCESS));
	}
}