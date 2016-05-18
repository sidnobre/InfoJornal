package br.ufc.model.noticia;

import org.hibernate.validator.constraints.NotBlank;


public class Comentario {

	private int id;
	@NotBlank
	private int idNoticia;
	@NotBlank
	private String autor;
	@NotBlank
	private String texto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
