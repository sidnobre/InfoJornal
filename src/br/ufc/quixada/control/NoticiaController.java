package br.ufc.quixada.control;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.ufc.quixada.dao.NoticiaDAO;
import br.ufc.quixada.dao.SecaoDAO;
import br.ufc.quixada.dao.UsuarioDAO;
import br.ufc.quixada.model.Noticia;
import br.ufc.quixada.model.Secao;
import br.ufc.quixada.model.Usuario;
import br.ufc.quixada.security.AutenticacaoRule;
import br.ufc.quixada.security.JornalistaEditorRule;
import br.ufc.quixada.security.JornalistaRule;
import br.ufc.quixada.util.AppConfig;
import br.ufc.quixada.validator.NoticiaValidador;

@Controller
public class NoticiaController {
	
	@Inject private SecaoDAO sdao;
	@Inject private NoticiaDAO ndao;
	@Inject private UsuarioDAO udao;
	@Inject private Result resultado;
	@Inject private NoticiaValidador validador;
	
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaRule.class})
	public void formulario(){
		resultado.include("secaoList", sdao.listar());
	}
	
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaEditorRule.class})
	@Path("/noticia/editar/{noticia.id}")
	public Noticia formularioEditar(Noticia noticia){
		resultado.include("secaoList", sdao.listar());
		return ndao.buscar(noticia);
	}
	
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaEditorRule.class})
	public void buscar(){
		List<Usuario> usuarioList = udao.buscarJornalistas();
		resultado.include("usuarioList", usuarioList);
	}
	
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaEditorRule.class})
	@Path("/noticia/buscar/por-data")
	public void buscarPorData(Date dataInicio, Date dataFinal){
		List<Noticia> noticiaList = ndao.buscarPorData(dataInicio, dataFinal);
		resultado.redirectTo(this).resultadoBusca(noticiaList);
	}
	
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaEditorRule.class})
	@Path("/noticia/buscar/por-titulo")
	public void buscarPorTitulo(Noticia noticia){
		List<Noticia> noticiaList = ndao.buscarPorTitulo(noticia);
		resultado.redirectTo(this).resultadoBusca(noticiaList);
	}
	
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaEditorRule.class})
	@Path("/noticia/buscar/por-autor")
	public void buscarPorAutor(Noticia noticia){
		List<Noticia> noticiaList = ndao.buscarPorAutor(noticia);
		resultado.redirectTo(this).resultadoBusca(noticiaList);
	}
	
	public List<Noticia> resultadoBusca(List<Noticia> noticiaList){
		return noticiaList;
	}
	
	
	@Post
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaRule.class})
	public void adicionar(Noticia noticia, Secao secao,Usuario autor, UploadedFile imagem){
		File arquivo = new File(AppConfig.HOME+"/uploads/", imagem.getFileName());
		try {
			imagem.writeTo(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		noticia.setImagem(arquivo.getName());
		noticia.setSecao(secao);
		noticia.setAutor(autor);
		validador.validarFormulario(noticia);
		ndao.adicionar(noticia);
		validador.confirmaValidacao();
		resultado.redirectTo(IndexController.class).index();
	}
	
	@Post
	@Path("/noticia/atualizar")
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaEditorRule.class})
	public void atualizar(Noticia noticia, Secao secao,Usuario autor, UploadedFile imagem){
		if(imagem != null){
			try {
				File arquivo = new File(AppConfig.HOME+"/uploads/", imagem.getFileName());
				imagem.writeTo(arquivo);
				noticia.setImagem(arquivo.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		noticia.setSecao(secao);
		noticia.setAutor(autor);
		validador.validarFormulario(noticia);
		ndao.atualizar(noticia);
		validador.confirmaValidacao();
		resultado.redirectTo(IndexController.class).index();
	}
	
	@Get
	@Path("/noticia/remover/{noticia.id}")
	@CustomBrutauthRules({AutenticacaoRule.class, JornalistaEditorRule.class})
	public void remover(Noticia noticia){
		ndao.remover(ndao.buscar(noticia));
		validador.confirmaRemocao();
		resultado.redirectTo(IndexController.class).index();
	}
	
	@Get
	@Path("/noticia/listar/{secao.id}")
	public List<Noticia> listar(Secao secao){
		List<Noticia> noticiaList = ndao.listar(secao);
		if(!noticiaList.isEmpty()) secao = noticiaList.get(0).getSecao();
		resultado.include("secaoList", sdao.listar());
		resultado.include("secao", secao);
		return noticiaList;
	}
	
	@Get
	@Path("/noticia/ler/{noticia.id}")
	public Noticia ler(Noticia noticia){
		resultado.include("secaoList", sdao.listar());
		return ndao.buscar(noticia);
	}
	
	@Get
	@Path("/noticia/imagem/{noticia.imagem}")
	public File imagemDownloader(Noticia noticia){
		return new File(AppConfig.HOME+"/uploads/", noticia.getImagem());
	}
}