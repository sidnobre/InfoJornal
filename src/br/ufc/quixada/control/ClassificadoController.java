package br.ufc.quixada.control;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplevalidator.SimpleValidator;
import br.ufc.quixada.dao.ClassificadoDao;
import br.ufc.quixada.dao.SecaoDao;
import br.ufc.quixada.model.Classificado;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.EditorRule;
import br.ufc.quixada.security.LeitorRule;
import br.ufc.quixada.util.Oferta;
import br.ufc.quixada.validator.ClassificadoValidator;
import br.ufc.quixada.validator.OfertaValidator;

@Controller
public class ClassificadoController {
	
	@Inject private ClassificadoDao cdao;
	@Inject private SecaoDao sdao;
	@Inject private SimpleValidator validator;
	@Inject private Result resultado;
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void formulario(){}
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void adicionar(Classificado classificado){
		classificado.setDataOferta(null);
		classificado.setAutorOferta(null);
		classificado.setValorOferta(0.0);
		validator.validate(classificado, ClassificadoValidator.class)
			.onSuccessAddConfirmation("classificado.adicionado.sucesso")
			.onErrorRedirectTo(this).formulario();
		cdao.adicionar(classificado);
		resultado.redirectTo(ClassificadoController.class).listar();
	}
	
	public List<Classificado> listar(){
		resultado.include("secaoList", sdao.listar());
		return cdao.listar();
	};
	
	@CustomBrutauthRules({AutenticacaoRule.class, LeitorRule.class})
	public void ofertar(Classificado classificado, Oferta oferta){
		classificado = cdao.buscar(classificado.getId());
		oferta.setData(new Date());
		oferta.setUltimaOferta(classificado.getValorOferta());
		
		validator.validate(oferta, OfertaValidator.class)
			.onSuccessAddConfirmation("oferta.adicionada.sucesso")
			.onErrorRedirectTo(this).listar();
		
		classificado.setAutorOferta(oferta.getAutor());
		classificado.setDataOferta(oferta.getData());
		classificado.setValorOferta(oferta.getValor());
		cdao.atualizar(classificado);
		
		resultado.redirectTo(ClassificadoController.class).listar();
	}
}