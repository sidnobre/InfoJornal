package br.ufc.quixada.security;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;
import br.ufc.quixada.model.Papel;

//@RequestScoped
@HandledBy(AutorizacaoHandler.class)
public class LeitorRule implements CustomBrutauthRule{
	
	@Inject private UsuarioSessao usuarioSessao;

	public boolean isAllowed() {
		return usuarioSessao.getPapel().getNivel() == Papel.LEITOR_NIVEL;
	}
}
