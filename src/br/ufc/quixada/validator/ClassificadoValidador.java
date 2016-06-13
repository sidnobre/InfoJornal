package br.ufc.quixada.validator;

import java.util.regex.Pattern;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.control.ClassificadoController;
import br.ufc.quixada.model.Classificado;
import br.ufc.quixada.util.Oferta;

public class ClassificadoValidador {
	
	private final String CONTATO_REGEX = "^\\([0-9]{2}\\)\\s[0-9]{5}-[0-9]{4}";
	@Inject private Validator validador;
	
	public void validarFormulario(Classificado classificado){
		boolean textoValido = !classificado.getTexto().isEmpty();
		boolean tituloValido = !classificado.getTitulo().isEmpty();
		boolean precoValido = !classificado.getPreco().isNaN() && classificado.getPreco()>=0;
		boolean contatoValido = Pattern.compile(CONTATO_REGEX).matcher(classificado.getContato()).matches();
		
		validador.ensure(textoValido, new SimpleMessage("classificado.texto.invalido", "deve ser preenchido obrigatoriamente.", Severity.ERROR));
		validador.ensure(tituloValido, new SimpleMessage("classificado.titulo.invalido", "deve ser preenchido obrigatoriamente.", Severity.ERROR));
		validador.ensure(precoValido, new SimpleMessage("classificado.preco.invalido", "deve ser preenchido obrigatoriamente (mínimo=0,00)", Severity.ERROR));
		validador.ensure(contatoValido, new SimpleMessage("classificado.contato.invalido", "deve ser preenchido obrigatoriamente. Formato: (99) 99999-9999", Severity.ERROR));
		validador.onErrorRedirectTo(ClassificadoController.class).formulario();
	}
	
	public void validarFormularioOferta(Classificado classificado, Oferta oferta){
		boolean valorValido = !oferta.getValor().isNaN() && oferta.getValor() > classificado.getValorOferta();
		boolean autorValido = oferta.getAutor() != null;
		boolean dataValida = oferta.getData() != null;
		
		validador.ensure(valorValido, new SimpleMessage("oferta.valor.invalido", "deve ser maior que o valor da última oferta.", Severity.ERROR));
		validador.ensure(autorValido, new SimpleMessage("oferta.autor.invalido", "somente leitores autenticados podem realizar uma oferta.", Severity.ERROR));
		validador.ensure(dataValida, new SimpleMessage("oferta.data.invalida", "Data Inválida", Severity.ERROR));
		validador.onErrorRedirectTo(ClassificadoController.class).listar();
	}
	
	public void confirmarValidacao(){
		validador.add(new SimpleMessage("classificado.adicionado", "Classificado foi adicionado com sucesso!", Severity.SUCCESS));
	}
	
	public void confirmarOferta(){
		validador.add(new SimpleMessage("oferta.adicionada", "Oferta foi adicionada com sucesso!", Severity.SUCCESS));
	}
}
