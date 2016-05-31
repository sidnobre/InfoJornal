package br.ufc.quixada.dao;

import java.util.List;

import br.ufc.quixada.model.Papel;

public interface IPapelDAO {
	public Papel buscar(Long id);
	public List<Papel> listar();
}
