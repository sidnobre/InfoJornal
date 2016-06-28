package br.ufc.quixada.dao.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.dao.ClassificadoDao;
import br.ufc.quixada.model.Classificado;

@RequestScoped
public class ClassificadoDaoImpl implements ClassificadoDao{
	
	@Inject private EntityManager manager;

	public void adicionar(Classificado classificado) {
		manager.persist(classificado);
	}
	
	public void atualizar(Classificado classificado){
		manager.merge(classificado);
	}

	public Classificado buscar(Long id) {
		return manager.find(Classificado.class, id);
	}

	public List<Classificado> listar() {
		TypedQuery<Classificado> query = manager.createNamedQuery("Classificado.todos",Classificado.class);
		return query.getResultList();
	}

}
