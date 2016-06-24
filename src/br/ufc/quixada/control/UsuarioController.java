package br.ufc.quixada.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplevalidator.SimpleValidator;
import br.ufc.quixada.annotation.NoPageCache;
import br.ufc.quixada.dao.PapelDAO;
import br.ufc.quixada.dao.UsuarioDAO;
import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.EditorRule;
import br.ufc.quixada.util.EmailSender;
import br.ufc.quixada.util.GeradorDeSenha;
import br.ufc.quixada.validator.UsuarioValidador;
import br.ufc.quixada.validator.UsuarioValidator;

@Controller
public class UsuarioController {
	
	@Inject private UsuarioDAO udao;
	@Inject private PapelDAO pdao;
	@Inject private Result resultado;
	@Inject private UsuarioValidador usuarioValidador;
	@Inject private SimpleValidator validator;
	@Inject private EmailSender mailer;
	
	@NoPageCache
	public void formularioLeitor(){}
	
	@NoPageCache
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void formularioJornalista(){}
	
	@NoPageCache
	public void perfil(){}
	
	public void esqueciSenha(){}
	
	@Post
	@NoPageCache
	public void adicionarLeitor(Usuario usuario){
		validator.validate(usuario, UsuarioValidator.class)
			.onSuccessAddConfirmation("usuario.adicionado.sucesso")
			.onErrorRedirectTo(this).formularioLeitor();
		String hash = DigestUtils.sha256Hex(usuario.getSenha());
		usuario.setSenha(hash);
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(pdao.buscar(Papel.LEITOR_ID));
		usuario.setPapeis(papeis);
		udao.adicionar(usuario);
		resultado.redirectTo(IndexController.class).index();
	}
	
	@Post
	@NoPageCache
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void adicionarJornalista(Usuario usuario){
		validator.validate(usuario, UsuarioValidator.class)
			.onSuccessAddConfirmation("usuario.adicionado.sucesso")
			.onErrorRedirectTo(this).formularioJornalista();
		String hash = DigestUtils.sha256Hex(usuario.getSenha());
		usuario.setSenha(hash);
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(pdao.buscar(Papel.LEITOR_ID));
		papeis.add(pdao.buscar(Papel.JORNALISTA_ID));
		usuario.setPapeis(papeis);
		udao.adicionar(usuario);
		resultado.redirectTo(IndexController.class).index();
	}
	
	/*@Post
	@NoPageCache
	@CustomBrutauthRules({AutenticacaoRule.class, EditorRule.class})
	public void adicionarEditor(Usuario usuario){
		prepare(usuario);
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(pdao.buscar(Papel.LEITOR_ID));
		papeis.add(pdao.buscar(Papel.JORNALISTA_ID));
		papeis.add(pdao.buscar(Papel.EDITOR_ID));
		usuario.setPapeis(papeis);
		udao.adicionar(usuario);
		resultado.redirectTo(IndexController.class).index();
	}*/
	
	public void atualizarLeitor(){}
	
	public void atualizarJornalista(){}
	
	public void resetarSenha(Usuario usuario){
		Usuario usuarioCarregado = udao.buscarPorEmail(usuario);
		usuarioValidador.validarConta(usuarioCarregado);
		String novaSenha = GeradorDeSenha.gerarSenha();
		String hash = DigestUtils.sha256Hex(novaSenha);
		usuarioCarregado.setSenha(hash);
		udao.atualizar(usuarioCarregado);
		mailer.enviar(usuarioCarregado.getEmail(), usuarioCarregado.getLogin(), novaSenha);
		usuarioValidador.confirmarReset();
		resultado.redirectTo(IndexController.class).index();
	}
}