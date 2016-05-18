package br.ufc.model.noticia;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class Noticia {

	private int id;
	@NotBlank(message = "*")  @Size(max=150, message = "*")
	private String titulo;
	@NotBlank(message = "*") @Size(max=300, message = "*")
	private String subtitulo;
	@NotBlank(message = "*") @Size(max=2000, message = "*")
	private String texto;
	@NotBlank
	private String autor;
	private Date data;
	private int idsecao;
	private byte imagem;
	
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
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIdsecao() {
		return idsecao;
	}
	public void setIdsecao(int idsecao) {
		this.idsecao = idsecao;
	}
	public byte getImagem() {
		return imagem;
	}
	public void setImagem(byte imagem) {
		this.imagem = imagem;
	}
}
