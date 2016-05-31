package br.ufc.quixada.control;

import java.util.regex.Pattern;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.model.Secao;

public class SecaoValidador{
	
	private final String TEXTO_REGEX = "^([a-zA-Zà-úÀ-Ú])+([a-zA-Zà-úÀ-Ú ])*$";
	@Inject private Validator validador;
	
	public void validarFormulario(Secao secao){
		String textoErro = "deve conter apenas letras. No mínimo 2 à no máximo 250 caracteres";
		boolean tituloValido = Pattern.compile(TEXTO_REGEX).matcher(secao.getTitulo()).matches();
		boolean descricaoValida = Pattern.compile(TEXTO_REGEX).matcher(secao.getDescricao()).matches();
		
		validador.ensure(tituloValido, new SimpleMessage("secao.titulo.invalido", textoErro, Severity.ERROR));
		validador.ensure(descricaoValida, new SimpleMessage("secao.descricao.invalida", textoErro, Severity.ERROR));
		
		validador.onErrorRedirectTo(SecaoController.class).formulario();
	}
	
	public void confirmarValidacao(){
		validador.add(new SimpleMessage("secao.adicionada", "Seção foi adicionada com sucesso!", Severity.SUCCESS));
	}
}
