package br.ufc.quixada.control;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplevalidator.SimpleValidator;
import br.ufc.quixada.dao.SecaoDao;
import br.ufc.quixada.model.Secao;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.EditorRule;
import br.ufc.quixada.validator.SecaoValidator;

@Controller
public class SecaoController {
	
	@Inject private SecaoDao sdao;
	@Inject private SimpleValidator validator;
	@Inject private Result result;
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void formulario(){
	}
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void adicionar(Secao secao){
		
		validator.validate(secao, SecaoValidator.class)
			.onSuccessAddConfirmation("secao.adicionada.sucesso")
			.onErrorRedirectTo(this).formulario();
		sdao.adicionar(secao);
		result.redirectTo(IndexController.class).index();
	}
	
	public List<Secao> listar(){
		return sdao.listar();
	}
}