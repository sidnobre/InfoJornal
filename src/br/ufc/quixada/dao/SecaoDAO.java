package br.ufc.quixada.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.model.Secao;

@RequestScoped
public class SecaoDAO implements ISecaoDAO{
	
	@Inject
	private EntityManager manager;

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