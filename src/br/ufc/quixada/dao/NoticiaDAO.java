package br.ufc.quixada.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.model.Noticia;
import br.ufc.quixada.model.Secao;

@RequestScoped
public class NoticiaDAO implements INoticiaDAO{
	
	@Inject
	private EntityManager manager;

	public void adicionar(Noticia noticia) {
		manager.persist(noticia);
	}

	public void remover(Noticia noticia) {
		manager.remove(noticia);
	}

	public Noticia buscar(Long id) {
		return manager.find(Noticia.class, id);
	}

	public List<Noticia> listar() {
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.todas",Noticia.class);
		return query.getResultList();
	}
	
	public List<Noticia> listar(Secao secao){
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.porSecao", Noticia.class);
		query.setParameter("secao", secao);
		return query.getResultList();
	}
	
	public List<Noticia> ultimaPorSecao(){
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.ultimaPorSecao", Noticia.class);
		return query.getResultList();
	}
}