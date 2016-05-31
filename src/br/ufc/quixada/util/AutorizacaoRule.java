package br.ufc.quixada.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;

@RequestScoped
@HandledBy(AutorizacaoHandler.class)
public class AutorizacaoRule implements SimpleBrutauthRule{
	@Inject
	private UsuarioSessao usuarioAutenticado;

	@Override
	public boolean isAllowed(long nivel) {
		//if(usuarioAutenticado==null) return false;
		System.out.println("INTERCEPTADO: AUTORIZACAO RULE");
		return usuarioAutenticado.isPermitido(nivel);
	}
}
