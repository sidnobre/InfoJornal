package br.ufc.quixada.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.brutauth.auth.annotations.AccessLevel;
import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.annotation.NoPageCache;
import br.ufc.quixada.dao.PapelDAO;
import br.ufc.quixada.dao.UsuarioDAO;
import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.AutorizacaoRule;

@Controller
public class UsuarioController {
	
	@Inject private UsuarioDAO udao;
	@Inject private PapelDAO pdao;
	@Inject private Result resultado;
	@Inject private UsuarioValidador usuarioValidador;
	
	@NoPageCache
	public void formularioLeitor(){}
	
	@NoPageCache
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(3000)
	public void formularioJornalista(){}
	
	@Post
	@NoPageCache
	public void adicionarLeitor(Usuario usuario){
		usuarioValidador.validarFormulario(usuario);
		String hash = DigestUtils.sha256Hex(usuario.getSenha());
		System.out.println(hash);
		usuario.setSenha(hash);
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(pdao.buscar(1L));
		usuario.setPapeis(papeis);
		udao.adicionar(usuario);
		usuarioValidador.confirmar();
		resultado.redirectTo(IndexController.class).index();
	}
	
	@Post
	@NoPageCache
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(3000)
	public void adicionarJornalista(Usuario usuario){
		Usuario carregado = udao.buscarByLogin(usuario);
		if(carregado!=null){
			usuarioValidador.validarLogin(carregado);
			carregado.getPapeis().add(pdao.buscar(2L));
			udao.adicionar(carregado);
		}else{
			String hash = DigestUtils.sha256Hex(usuario.getSenha());
			usuario.setSenha(hash);
			usuarioValidador.validarFormulario(usuario);
			List<Papel> papeis = new ArrayList<Papel>();
			papeis.add(pdao.buscar(1L));
			papeis.add(pdao.buscar(2L));
			usuario.setPapeis(papeis);
			udao.adicionar(usuario);
		}
		usuarioValidador.confirmar();
		resultado.redirectTo(IndexController.class).index();
	}
}