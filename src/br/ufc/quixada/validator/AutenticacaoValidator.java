package br.ufc.quixada.validator;

import javax.inject.Inject;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.security.UsuarioSessao;

public class AutenticacaoValidator implements CustomValidationStrategy<UsuarioSessao>{

	@Inject ValidationStrategyHelper helper;
	
	public void addErrors(UsuarioSessao sessao) {
		if(sessao.getUsuario() == null){
			helper.addError("usuario.login.invalido");
			sessao.destruir();
		}else{
			if(sessao.getPapel() == null){
				helper.addError("usuario.tipo.invalido");
				sessao.destruir();
			}else{
				if(!sessao.getUsuario().getPapeis().contains(sessao.getPapel())){
					helper.addError("usuario.permissao.invalida");
					sessao.destruir();
				}
			}
		}
	}
}