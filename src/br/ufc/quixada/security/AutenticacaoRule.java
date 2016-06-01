package br.ufc.quixada.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;

@RequestScoped
@HandledBy(AutenticacaoHandler.class)
public class AutenticacaoRule implements SimpleBrutauthRule{
	@Inject
	private UsuarioSessao usuarioAutenticado;

	public boolean isAllowed(long nivel) {
		System.out.println("INTERCEPTADO: AUTENTICACAO RULE");
		return usuarioAutenticado.isAutenticado();
	}
	
}
