package br.ufc.quixada.control;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.AccessLevel;
import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.dao.SecaoDAO;
import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Secao;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.AutorizacaoRule;
import br.ufc.quixada.validator.SecaoValidador;

@Controller
public class SecaoController {
	
	@Inject private SecaoDAO dao;
	@Inject private SecaoValidador validador;
	@Inject private Result result;
	
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(Papel.EDITOR_NIVEL)
	public void formulario(){
	}
	
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(Papel.EDITOR_NIVEL)
	public void adicionar(Secao secao){
		validador.validarFormulario(secao);
		dao.adicionar(secao);
		validador.confirmarValidacao();
		result.redirectTo(IndexController.class).index();
	}
	
	public List<Secao> listar(){
		return dao.listar();
	}
}