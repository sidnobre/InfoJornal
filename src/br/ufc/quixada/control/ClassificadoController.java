package br.ufc.quixada.control;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.dao.ClassificadoDAO;
import br.ufc.quixada.dao.SecaoDAO;
import br.ufc.quixada.model.Classificado;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.EditorRule;
import br.ufc.quixada.security.LeitorRule;
import br.ufc.quixada.util.Oferta;
import br.ufc.quixada.validator.ClassificadoValidador;

@Controller
public class ClassificadoController {
	
	@Inject private ClassificadoDAO cdao;
	@Inject private SecaoDAO sdao;
	@Inject private ClassificadoValidador validador;
	@Inject private Result resultado;
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void formulario(){}
	
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void adicionar(Classificado classificado){
		validador.validarFormulario(classificado);
		classificado.setDataOferta(null);
		classificado.setAutorOferta(null);
		classificado.setValorOferta(0.0);
		cdao.adicionar(classificado);
		validador.confirmarValidacao();
		resultado.redirectTo(ClassificadoController.class).listar();
	}
	
	public List<Classificado> listar(){
		resultado.include("secaoList", sdao.listar());
		return cdao.listar();
	};
	
	@CustomBrutauthRules({AutenticacaoRule.class, LeitorRule.class})
	public void ofertar(Classificado classificado, Oferta oferta, Usuario autor){
		classificado = cdao.buscar(classificado.getId());
		oferta.setAutor(autor);
		oferta.setData(new Date());
		validador.validarFormularioOferta(classificado, oferta);
		classificado.setAutorOferta(oferta.getAutor());
		classificado.setDataOferta(oferta.getData());
		classificado.setValorOferta(oferta.getValor());
		cdao.atualizar(classificado);
		validador.confirmarOferta();
		resultado.redirectTo(ClassificadoController.class).listar();
	}
}