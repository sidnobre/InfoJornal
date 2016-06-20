package br.ufc.quixada.security;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;

@HandledBy(AutorizacaoHandler.class)
public class AutorizacaoRule implements SimpleBrutauthRule{
	
	@Inject private UsuarioSessao usuarioSessao;

	@Override
	public boolean isAllowed(long nivel) {
		return usuarioSessao.getPapel().getNivel() == nivel;
	}
}
