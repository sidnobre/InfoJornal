package br.ufc.quixada.control;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.dao.SecaoDAO;
import br.ufc.quixada.model.Secao;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.EditorRule;
import br.ufc.quixada.validator.SecaoValidador;

@Controller
public class SecaoController {
	
	@Inject private SecaoDAO dao;
	@Inject private SecaoValidador validador;
	@Inject private Result result;
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void formulario(){
	}
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
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