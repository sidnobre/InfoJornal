package br.ufc.quixada.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.control.AutenticacaoController;

@RequestScoped
public class AutenticacaoHandler implements RuleHandler{
	
	@Inject private Validator validator;

	@Override
	public void handle() {
		validator.add(new SimpleMessage("autenticacao.handler", "Usuário não autenticado! Por favor faça login."));
		validator.onErrorUsePageOf(AutenticacaoController.class).formulario();
	}

}
