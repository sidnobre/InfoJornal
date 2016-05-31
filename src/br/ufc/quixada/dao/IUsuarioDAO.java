package br.ufc.quixada.dao;

import br.ufc.quixada.model.Usuario;

public interface IUsuarioDAO {
	public void adicionar(Usuario usuario);
	public Usuario buscar(Long id);
	public Usuario buscarByLogin(Usuario usuario);
	public Usuario buscarByLoginSenha(Usuario usuario);
}
