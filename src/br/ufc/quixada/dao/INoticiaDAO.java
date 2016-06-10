package br.ufc.quixada.dao;

import java.util.Date;
import java.util.List;

import br.ufc.quixada.model.Noticia;
import br.ufc.quixada.model.Secao;

public interface INoticiaDAO {
	public void adicionar(Noticia noticia);
	public void remover(Noticia noticia);
	public Noticia buscar(Noticia noticia);
	public void atualizar(Noticia noticia);
	public List<Noticia> listar();
	public List<Noticia> listar(Secao secao);
	public List<Noticia> ultimaPorSecao();
	public List<Noticia> buscarPorData(Date dataInicio, Date dataFinal);
	public List<Noticia> buscarPorTitulo(Noticia noticia);
	public List<Noticia> buscarPorAutor(Noticia noticia);
}
