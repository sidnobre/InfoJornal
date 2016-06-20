package br.ufc.quixada.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.control.IndexController;

@RequestScoped
public class AutenticacaoHandler implements RuleHandler{
	
	@Inject private Validator validador;

	@Override
	public void handle() {
		validador.add(new SimpleMessage("autenticacao.invalida", "Usuário não autenticado! Por favor faça login.", Severity.ERROR));
		validador.onErrorUsePageOf(IndexController.class).index();
	}

}
