package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Usuario;

public interface UsuarioDao {
	public void adicionar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public Usuario buscar(Long id);
	public Usuario buscarPorLogin(Usuario usuario);
	public Usuario buscarPorEmail(Usuario usuario);
	public Usuario buscarPorLoginSenha(Usuario usuario);
	public List<Usuario> buscarJornalistas();
	public boolean existeEmail(Usuario usuario);
	public boolean existeLogin(Usuario usuario);
}
