package br.ufc.quixada.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.dao.ComentarioDao;
import br.ufc.quixada.model.Comentario;
import br.ufc.quixada.model.Noticia;

public class ComentarioDaoImpl implements ComentarioDao{
	
	@Inject EntityManager manager;

	public void adicionar(Comentario comentario) {
		comentario.setNoticia(manager.find(Noticia.class, comentario.getNoticia().getId()));
		manager.persist(comentario);
	}

	public List<Comentario> listar() {
		TypedQuery<Comentario> query = manager.createNamedQuery("Comentario.todos",Comentario.class);
		return query.getResultList();
	}

	public List<Comentario> recentes() {
		TypedQuery<Comentario> query = manager.createNamedQuery("Comentario.recentes",Comentario.class);
		query.setMaxResults(5);
		return query.getResultList();
	}

	public void remover(Comentario comentario) {
		manager.remove(comentario);
	}
}