
package br.ufc.quixada.control;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplevalidator.SimpleValidator;
import br.ufc.quixada.dao.PapelDao;
import br.ufc.quixada.dao.UsuarioDao;
import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.UsuarioSessao;
import br.ufc.quixada.validator.AutenticacaoValidator;

@Controller
public class AutenticacaoController {
	
	@Inject private UsuarioDao udao;
	@Inject private PapelDao pdao;
	@Inject private UsuarioSessao usuarioSessao;
	@Inject private SimpleValidator validator;
	@Inject private Result resultado;

	public void formulario(){}
	
	@Post
	public void login(Usuario usuario, Long papel){
		String hash = DigestUtils.sha256Hex(usuario.getSenha());
		usuario.setSenha(hash);
		Usuario usuarioCarregado = udao.buscarPorLoginSenha(usuario);
		Papel papelCarregado = pdao.buscar(papel);
		usuarioSessao.criar(usuarioCarregado, papelCarregado);
		validator.validate(usuarioSessao, AutenticacaoValidator.class)
			.onSuccessAddConfirmation("usuario.login.sucesso")
			.onErrorRedirectTo(this).formulario();
		resultado.redirectTo(IndexController.class).index();
	}
	
	public void logout(){
		usuarioSessao.destruir();
		resultado.redirectTo(this).formulario();
	}
}