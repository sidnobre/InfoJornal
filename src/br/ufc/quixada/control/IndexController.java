package br.ufc.quixada.control;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.dao.NoticiaDAO;
import br.ufc.quixada.dao.SecaoDAO;
import br.ufc.quixada.model.Noticia;

@Controller
public class IndexController {

	@Inject private SecaoDAO sdao;
	@Inject private NoticiaDAO ndao;
	@Inject private Result resultado;
	
	@Path("/")
	public void index(){
		List<Noticia> noticiaList = ndao.ultimaPorSecao();
		resultado.include("secaoList", sdao.listar());
		resultado.include("noticiaList", noticiaList);
	}
}