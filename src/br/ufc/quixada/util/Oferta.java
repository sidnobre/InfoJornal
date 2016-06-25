package br.ufc.quixada.util;

import java.util.Date;

import br.ufc.quixada.model.Usuario;

public class Oferta {
	private Double valor;
	private Date data;
	private Usuario autor;
	private Double ultimaOferta;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Double getUltimaOferta(){
		return ultimaOferta;
	}
	public void setUltimaOferta(Double ultimaOferta){
		this.ultimaOferta = ultimaOferta;
	}
}
