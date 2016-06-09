package br.ufc.quixada.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.model.Usuario;

public class UsuarioDAO implements IUsuarioDAO{
	
	@Inject
	private EntityManager manager;

	public void adicionar(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario buscar(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	public Usuario buscarByLogin(Usuario usuario){
		TypedQuery<Usuario> query = manager.createNamedQuery("usuario.porLogin", Usuario.class);
		query.setParameter("login", usuario.getLogin());
		if(query.getResultList().isEmpty()) return null;
		return query.getSingleResult();
	}
	
	public Usuario buscarByLoginSenha(Usuario usuario){
		TypedQuery<Usuario> query = manager.createNamedQuery("usuario.porLoginSenha", Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		if(query.getResultList().isEmpty()) return null;
		return query.getSingleResult();
	}
	
	public List<Usuario> buscarJornalistas(){
		TypedQuery<Usuario> query = manager.createNamedQuery("usuario.jornalistas",Usuario.class);
		query.setParameter("papel", 2L);
		return query.getResultList();
	}
}
