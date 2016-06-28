package br.ufc.quixada.validator;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.simplevalidator.CustomValidationStrategy;
import br.com.caelum.vraptor.simplevalidator.ValidationStrategyHelper;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.UsuarioSessao;

public class SenhaValidator implements CustomValidationStrategy<Usuario>{
	@Inject private ValidationStrategyHelper helper;
	@Inject private UsuarioSessao usuarioSessao;

	public void addErrors(Usuario usuario) {
		if(usuario == null){
			helper.addError("usuario.invalido");
		}else{
			if(usuario.getSenha() == null || usuario.getSenha().equals("") || usuario.getSenha().length() < 6){
				helper.addError("usuario.senha.invalida");
			}else{
				String hash = DigestUtils.sha256Hex(usuario.getSenha());
				if(!usuarioSessao.getUsuario().getSenha().equals(hash)){
					helper.addError("usuario.sessao.invalida");
				}
			}
		}
	}
}
