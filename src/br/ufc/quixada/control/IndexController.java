package br.ufc.quixada.control;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.annotation.MenuSecoes;
import br.ufc.quixada.dao.NoticiaDAO;
//import br.ufc.quixada.dao.SecaoDAO;
import br.ufc.quixada.model.Noticia;
//import br.ufc.quixada.util.Menu;

@Controller
public class IndexController {

	//@Inject
	//private SecaoDAO sdao;
	@Inject
	private NoticiaDAO ndao;
	//@Inject
	//private Menu menu;
	@Inject
	private Result resultado;
	
	
	@Path("/")
	@MenuSecoes
	public void index(){
		//menu.setSecoes(sdao.listar());
		List<Noticia> noticiaList = ndao.ultimaPorSecao();
		resultado.include("noticiaList", noticiaList);
	}
}