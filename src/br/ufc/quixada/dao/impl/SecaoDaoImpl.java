package br.ufc.quixada.dao.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.dao.SecaoDao;
import br.ufc.quixada.model.Secao;

@RequestScoped
public class SecaoDaoImpl implements SecaoDao{
	
	@Inject private EntityManager manager;

	public void adicionar(Secao secao) {
		manager.persist(secao);
	}

	public Secao buscar(Long id) {
		return manager.find(Secao.class, id);
	}

	public List<Secao> listar() {
		TypedQuery<Secao> query = manager.createNamedQuery("Secao.todas", Secao.class);
		return query.getResultList();
	}
}