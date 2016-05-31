package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Noticia;

public interface INoticiaDAO {
	public void adicionar(Noticia noticia);
	public void remover(Noticia noticia);
	public Noticia buscar(Long id);
	public List<Noticia> listar();
}
