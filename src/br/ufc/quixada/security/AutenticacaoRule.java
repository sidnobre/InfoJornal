package br.ufc.quixada.security;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;

@HandledBy(AutenticacaoHandler.class)
public class AutenticacaoRule implements CustomBrutauthRule{
	
	@Inject private UsuarioSessao usuarioSessao;

	public boolean isAllowed() {
		return usuarioSessao.getUsuario() != null && usuarioSessao.getPapel() != null;
	}
}
