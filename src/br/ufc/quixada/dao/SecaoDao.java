package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Secao;

public interface SecaoDao {
	public void adicionar(Secao secao);
	public Secao buscar(Long id);
	public List<Secao> listar();
}
