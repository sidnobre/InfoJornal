package br.ufc.quixada.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufc.quixada.control.IndexController;

@RequestScoped
public class AutorizacaoHandler implements RuleHandler{

	@Inject private Result resultado;
	@Inject private Validator validador;
	
	@Override
	public void handle() {
		validador.add(new SimpleMessage("autorizacao.invalida", "Este usuário não tem permissão para executar esta ação! Por favor faça login.", Severity.ERROR));
		resultado.forwardTo(IndexController.class).index();
	}
}
