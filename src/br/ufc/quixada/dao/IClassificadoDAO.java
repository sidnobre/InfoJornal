package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Classificado;

public interface IClassificadoDAO {
	public void adicionar(Classificado classificado);
	public Classificado buscar(Long id);
	public List<Classificado> listar();
}