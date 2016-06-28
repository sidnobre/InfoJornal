package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Classificado;

public interface ClassificadoDao {
	public void adicionar(Classificado classificado);
	public Classificado buscar(Long id);
	public void atualizar(Classificado classificado);
	public List<Classificado> listar();
}