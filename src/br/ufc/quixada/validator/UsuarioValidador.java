package br.ufc.quixada.validator;

import java.util.regex.Pattern;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.control.UsuarioController;
import br.ufc.quixada.model.Usuario;

public class UsuarioValidador {
	
	private final String NOME_REGEX = "^[a-zA-Zà-úÀ-Ú]+[a-zA-Zà-úÀ-Ú ]*$";
	private final String EMAIL_REGEX = "^[a-zA-Z]+[a-zA-Z0-9]*([._-]{0,1}[a-zA-Z0-9]+){0,3}@[a-zA-Z0-9]+.[a-zA-Z]+$";
	private final String LOGIN_REGEX = "^([a-zA-Z]+[a-zA-Z0-9]*){4,20}$";
	@Inject private Validator validador;
	
	public void validarFormulario(Usuario usuario){
		String erroNome = "deve conter apenas letras";
		String erroEmail = "deve ter um formato válido (usuario@exemplo.com)";
		String erroLogin = "deve iniciar com letras e possuir no mínimo 4 caracteres";
		String erroSenha = "deve ser preenchida e possuir no mínimo 6 caracteres";
		
		boolean nomeValido = Pattern.compile(NOME_REGEX).matcher(usuario.getNome()).matches();
		boolean emailValido = Pattern.compile(EMAIL_REGEX).matcher(usuario.getEmail()).matches();
		boolean loginValido = Pattern.compile(LOGIN_REGEX).matcher(usuario.getLogin()).matches();
		boolean senhaValida = usuario.getSenha().length() >= 6;
		
		validador.ensure(nomeValido, new SimpleMessage("usuario.nome.invalido", erroNome, Severity.ERROR));
		validador.ensure(emailValido, new SimpleMessage("usuario.email.invalido", erroEmail, Severity.ERROR));
		validador.ensure(loginValido, new SimpleMessage("usuario.login.invalido", erroLogin, Severity.ERROR));
		validador.ensure(senhaValida, new SimpleMessage("usuario.senha.invalida", erroSenha, Severity.ERROR));
		
		validador.onErrorUsePageOf(UsuarioController.class).formularioLeitor();
	}
	
	public void validarLogin(Usuario usuario){
		String erroLogin = "deve iniciar com letras e possuir no mínimo 4 caracteres";
		boolean loginValido = Pattern.compile(LOGIN_REGEX).matcher(usuario.getLogin()).matches();
		validador.ensure(loginValido, new SimpleMessage("usuario.nome.invalido", erroLogin, Severity.ERROR));
		validador.onErrorUsePageOf(UsuarioController.class).formularioLeitor();
	}
	
	public void validarConta(Usuario usuario){
		String erroConta = "Nenhum usuário cadastrado com este e-mail.";
		boolean contaValida = usuario != null;
		validador.ensure(contaValida, new SimpleMessage("usuario.conta.invalida", erroConta, Severity.ERROR));
		validador.onErrorUsePageOf(UsuarioController.class).esqueciSenha();
	}
	
	public void confirmar(){
		validador.add(new SimpleMessage("usuario.adicionado", "Usuário foi adicionado com sucesso!", Severity.SUCCESS));
	}
	
	public void confirmarReset(){
		validador.add(new SimpleMessage("usuario.senha.resetada", "Uma mensagem contendo a nova senha de acesso foi enviada para seu e-mail.", Severity.SUCCESS));
	}
}