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
import br.ufc.quixada.dao.PapelDao;
import br.ufc.quixada.dao.UsuarioDao;
import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.EditorRule;
import br.ufc.quixada.util.EmailSender;
import br.ufc.quixada.util.GeradorDeSenha;
import br.ufc.quixada.validator.EmailValidator;
import br.ufc.quixada.validator.SenhaValidator;
import br.ufc.quixada.validator.UsuarioValidator;

@Controller
public class UsuarioController {
	
	@Inject private UsuarioDao udao;
	@Inject private PapelDao pdao;
	@Inject private Result resultado;
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
	
	
	@CustomBrutauthRules(AutenticacaoRule.class)
	public void alterarSenha(){}
	
	
	@CustomBrutauthRules(AutenticacaoRule.class)
	public void alterarEmail(){}
	
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
	
	@Post
	@CustomBrutauthRules(AutenticacaoRule.class)
	public void atualizarSenha(Usuario usuario, Usuario usuarioAtual, String novaSenha){
		usuario = udao.buscar(usuario.getId());
		validator.validate(usuarioAtual, SenhaValidator.class)
			.onSuccessAddConfirmation("usuario.senha.atualizada.sucesso")
			.onErrorRedirectTo(this).alterarSenha();
		usuario.setSenha(DigestUtils.sha256Hex(novaSenha));
		udao.atualizar(usuario);
		resultado.redirectTo(this).perfil();
	}
	
	@Post
	@CustomBrutauthRules(AutenticacaoRule.class)
	public void atualizarEmail(Usuario usuario, Usuario usuarioAtual, String novoEmail){
		usuario = udao.buscar(usuario.getId());
		validator.validate(usuarioAtual, SenhaValidator.class)
			.onSuccessAddConfirmation("usuario.email.atualizado.sucesso")
			.onErrorRedirectTo(this).alterarEmail();
		usuario.setEmail(novoEmail);
		udao.atualizar(usuario);
		resultado.redirectTo(this).perfil();
	}
	
	public void resetarSenha(Usuario usuario){
		validator.validate(usuario, EmailValidator.class)
			.onSuccessAddConfirmation("usuario.senha.redefinida")
			.onErrorRedirectTo(this).esqueciSenha();
		Usuario usuarioCarregado = udao.buscarPorEmail(usuario);
		String novaSenha = GeradorDeSenha.gerarSenha();
		String novoHash = DigestUtils.sha256Hex(novaSenha);
		usuarioCarregado.setSenha(novoHash);
		udao.atualizar(usuarioCarregado);
		mailer.enviar(usuarioCarregado.getEmail(), usuarioCarregado.getLogin(), novaSenha);
		resultado.redirectTo(IndexController.class).index();
	}
}