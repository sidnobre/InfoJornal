package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Usuario;

public interface IUsuarioDAO {
	public void adicionar(Usuario usuario);
	public Usuario buscar(Long id);
	public Usuario buscarPorLogin(Usuario usuario);
	public Usuario buscarPorLoginSenha(Usuario usuario);
	public List<Usuario> buscarJornalistas();
}
