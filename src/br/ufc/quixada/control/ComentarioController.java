package br.ufc.quixada.control;

import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplevalidator.SimpleValidator;
import br.ufc.quixada.dao.IComentarioDAO;
import br.ufc.quixada.model.Comentario;
import br.ufc.quixada.validator.ComentarioValidator;

@Controller
public class ComentarioController {
	@Inject private IComentarioDAO cdao;
	@Inject private Result resultado;
	@Inject private SimpleValidator validator;
	
	public void adicionar(Comentario comentario){
		comentario.setData(new Date());
		validator.validate(comentario, ComentarioValidator.class)
			.onSuccessAddConfirmation("comentario.adicionado.sucesso")
			.onErrorRedirectTo(NoticiaController.class).ler(comentario.getNoticia());
		cdao.adicionar(comentario);
		resultado.redirectTo(NoticiaController.class).ler(comentario.getNoticia());
	}
	
	public void remover(Comentario comentario){
		cdao.remover(comentario);
	}
}