package br.ufc.quixada.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.control.AutenticacaoController;

@RequestScoped
public class AutorizacaoHandler implements RuleHandler{
	
	@Inject private Validator validador;
	
	@Override
	public void handle() {
		validador.add(new SimpleMessage("autorizacao.handler", "Este usuário não tem autorização para executar esta ação! Por favor faça login."));
		validador.onErrorUsePageOf(AutenticacaoController.class).formulario();
	}
}
