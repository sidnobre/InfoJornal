package br.ufc.quixada.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.dao.UsuarioDao;
import br.ufc.quixada.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	
	@Inject private EntityManager manager;

	public void adicionar(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public void atualizar(Usuario usuario){
		manager.merge(usuario);
	}

	public Usuario buscar(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	public boolean existeLogin(Usuario usuario){
		if(buscarPorLogin(usuario) != null)
			return true;
		return false;
	}
	
	public boolean existeEmail(Usuario usuario){
		if(buscarPorEmail(usuario) != null)
			return true;
		return false;
	}
	
	public Usuario buscarPorLogin(Usuario usuario){
		TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.porLogin", Usuario.class);
		query.setParameter("login", usuario.getLogin());
		if(query.getResultList().isEmpty()) return null;
		return query.getSingleResult();
	}
	
	public Usuario buscarPorEmail(Usuario usuario){
		TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.porEmail", Usuario.class);
		query.setParameter("email", usuario.getEmail());
		if(query.getResultList().isEmpty()) return null;
		return query.getSingleResult();
	}
	
	public Usuario buscarPorLoginSenha(Usuario usuario){
		TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.porLoginSenha", Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		if(query.getResultList().isEmpty()) return null;
		return query.getSingleResult();
	}
	
	public List<Usuario> buscarJornalistas(){
		TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.jornalistas",Usuario.class);
		query.setParameter("papel", 2L);
		return query.getResultList();
	}
}