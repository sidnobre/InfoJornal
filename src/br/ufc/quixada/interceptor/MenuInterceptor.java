package br.ufc.quixada.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.ufc.quixada.annotation.MenuSecoes;
import br.ufc.quixada.dao.SecaoDAO;

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(MenuSecoes.class)
public class MenuInterceptor {

	@Inject
	private SecaoDAO sdao;
	@Inject
	private Result resultado;
	
	@BeforeCall
	public void before(){
		resultado.include("secaoList", sdao.listar());
	}
}
