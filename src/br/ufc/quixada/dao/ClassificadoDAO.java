package br.ufc.quixada.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.model.Classificado;

@RequestScoped
public class ClassificadoDAO implements IClassificadoDAO{
	
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
