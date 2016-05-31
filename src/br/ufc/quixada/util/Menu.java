package br.ufc.quixada.util;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufc.quixada.model.Secao;

@Named("menu")
@SessionScoped
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Secao> secoes;

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}
}
