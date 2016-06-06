package br.ufc.quixada.control;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.AccessLevel;
import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.ufc.quixada.annotation.MenuSecoes;
import br.ufc.quixada.dao.NoticiaDAO;
import br.ufc.quixada.model.Noticia;
import br.ufc.quixada.model.Secao;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.AutorizacaoRule;

@Controller
public class NoticiaController {
	
	@Inject
	private NoticiaDAO dao;
	@Inject
	private Result resultado;
	@Inject
	private NoticiaValidador validador;
	
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(2000)
	@MenuSecoes
	public void formulario(){
	}
	
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(2000)
	public void buscar(){
	}
	
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(2000)
	@Path("/noticia/buscar/data")
	public List<Noticia> buscarPorData(Date dataInicio, Date dataFinal){
		List<Noticia> noticiaList = dao.buscarPorData(dataInicio, dataFinal);
		for(Noticia n: noticiaList)
			System.out.println(n.getTitulo());
		return noticiaList;
	}
	
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(2000)
	@Path("/noticia/buscar/titulo")
	public void buscarPorTitulo(Noticia noticia){
		
	}
	
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(2000)
	@Path("/noticia/buscar/autor")
	public void buscarPorAutor(Noticia noticia){
		
	}
	
	
	@Post
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(2000)
	public void adicionar(Noticia noticia, Secao secao,Usuario autor, UploadedFile imagem){
		File arquivo = new File("/home/ederson/uploads/", imagem.getFileName());
		//File arquivo = new File(context.getRealPath("uploads/"), imagem.getFileName());
		try {
			imagem.writeTo(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		noticia.setImagem(arquivo.getName());
		noticia.setSecao(secao);
		noticia.setAutor(autor);
		validador.validarFormulario(noticia);
		dao.adicionar(noticia);
		validador.confirmaValidacao();
		resultado.redirectTo(IndexController.class).index();
	}
	
	@Get
	@Path("/noticia/remover/{noticia.id}")
	@SimpleBrutauthRules({AutenticacaoRule.class, AutorizacaoRule.class})
	@AccessLevel(2000)
	public void remover(Noticia noticia){
		dao.remover(dao.buscar(noticia.getId()));
		validador.confirmaRemocao();
		resultado.redirectTo(IndexController.class).index();
	}
	
	@Get
	@Path("/noticia/listar/{secao.id}")
	@MenuSecoes
	public List<Noticia> listar(Secao secao){
		List<Noticia> noticiaList = dao.listar(secao);
		if(!noticiaList.isEmpty()) secao = noticiaList.get(0).getSecao();
		resultado.include("secao", secao);
		return noticiaList;
	}
	
	@Get
	@Path("/noticia/ler/{noticia.id}")
	@MenuSecoes
	public Noticia ler(Noticia noticia){
		return dao.buscar(noticia.getId());
	}
	
	@Get
	@Path("/noticia/imagem/{noticia.imagem}")
	public File imagemDownloader(Noticia noticia){
		return new File("/home/ederson/uploads", noticia.getImagem());
	}
}
