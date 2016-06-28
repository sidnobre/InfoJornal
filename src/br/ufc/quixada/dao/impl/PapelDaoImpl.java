package br.ufc.quixada.dao.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.dao.PapelDao;
import br.ufc.quixada.model.Papel;

@RequestScoped
public class PapelDaoImpl implements PapelDao{

	@Inject private EntityManager manager;
	
	public Papel buscar(Long id) {
		return manager.find(Papel.class, id);
	}
	
	public List<Papel> listar() {
		TypedQuery<Papel> query = manager.createNamedQuery("Papel.todos", Papel.class);
		return query.getResultList();
	}	
}