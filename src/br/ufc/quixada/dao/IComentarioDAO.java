package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Comentario;

public interface IComentarioDAO {
	public void adicionar(Comentario comentario);
	public List<Comentario> listar();
	public List<Comentario> recentes();
	public void remover(Comentario comentario);
}