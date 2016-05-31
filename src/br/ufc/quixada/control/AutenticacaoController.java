package br.ufc.quixada.control;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.dao.PapelDAO;
import br.ufc.quixada.dao.UsuarioDAO;
import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.util.UsuarioSessao;

@Controller
public class AutenticacaoController {
	
	@Inject private UsuarioDAO udao;
	@Inject private PapelDAO pdao;
	@Inject private UsuarioSessao usuarioSessao;
	@Inject private AutenticacaoValidador validador;
	@Inject private Result resultado;

	@Post
	public void login(Usuario usuario, Long papel){
		String hash = DigestUtils.sha256Hex(usuario.getSenha());
		usuario.setSenha(hash);
		Usuario usuarioCarregado = udao.buscarByLoginSenha(usuario);
		Papel papelCarregado = pdao.buscar(papel);
		validador.validarAutenticacao(usuarioCarregado,papelCarregado);
		
		usuarioSessao.autenticar(usuarioCarregado, papelCarregado);
		validador.confirmarLogin();
		
		resultado.redirectTo(IndexController.class).index();
	};
	
	public void logout(){
		usuarioSessao.desautenticar();
		validador.confirmarLogout();
		resultado.redirectTo(IndexController.class).index();
	}
}
