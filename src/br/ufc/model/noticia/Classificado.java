package br.ufc.model.noticia;

import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;


public class Classificado {
	
	private int id;
	@NotBlank
	private String titulo;
	@NotBlank
	private String texto;
	private float preco;
	private String telefone;
	private float melhorOferta;
	private Date dataOferta;
	private String autorOferta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public float getMelhorOferta() {
		return melhorOferta;
	}
	public void setMelhorOferta(float melhorOferta) {
		this.melhorOferta = melhorOferta;
	}
	public Date getDataOferta() {
		return dataOferta;
	}
	public void setDataOferta(Date date) {
		this.dataOferta = date;
	}
	public String getAutorOferta() {
		return autorOferta;
	}
	public void setAutorOferta(String autorOferta) {
		this.autorOferta = autorOferta;
	}
}
