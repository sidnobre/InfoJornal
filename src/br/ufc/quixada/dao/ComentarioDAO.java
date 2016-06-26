package br.ufc.quixada.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.model.Comentario;

public class ComentarioDAO implements IComentarioDAO{
	
	@Inject EntityManager manager;

	public void adicionar(Comentario comentario) {
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