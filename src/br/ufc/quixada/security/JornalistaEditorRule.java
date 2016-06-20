package br.ufc.quixada.security;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;
import br.ufc.quixada.model.Papel;

@HandledBy(AutorizacaoHandler.class)
public class JornalistaEditorRule implements CustomBrutauthRule{
	
	@Inject private UsuarioSessao usuarioSessao;

	public boolean isAllowed() {
		return usuarioSessao.getPapel().getNivel() == Papel.JORNALISTA_NIVEL || usuarioSessao.getPapel().getNivel() == Papel.EDITOR_NIVEL;
	}
}
