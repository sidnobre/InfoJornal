package br.ufc.quixada.control;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Usuario;

public class AutenticacaoValidador {
	
	@Inject private Validator validador;
	
	public void validarAutenticacao(Usuario usuario, Papel papel){
		boolean autenticado = !(usuario == null || papel == null);
		boolean autorizado = false;
		if(autenticado) autorizado = usuario.getPapeis().contains(papel);
		
		validador.ensure(autenticado, new SimpleMessage("usuario.nao.autenticado","Usuario e/ou senha inválidos."));
		validador.onErrorUsePageOf(IndexController.class).index();
		validador.ensure(autorizado, new SimpleMessage("papel.nao.autorizado", "Tipo não autorizado para este usuário."));
		validador.onErrorUsePageOf(IndexController.class).index();
	}
	
	public void confirmarLogin(){
		validador.add(new SimpleMessage("usuario.autenticado","Usuario foi autenticado com sucesso!",Severity.INFO));
	}
	
	public void confirmarLogout(){
		validador.add(new SimpleMessage("usuario.desautenticado","Usuario foi desautenticado com sucesso!",Severity.INFO));
	}
}