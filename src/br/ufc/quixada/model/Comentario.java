package br.ufc.quixada.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
@NamedQueries({
	@NamedQuery(name="Comentario.todos", query="SELECT c FROM Comentario c ORDER BY c.data")
})
public class Comentario {
	@Id @GeneratedValue
	private Long id;
	@Column(nullable=false, columnDefinition="TEXT")
	private String texto;
	@Column(nullable=false)
	private Date data;
	@ManyToOne(optional=false)
	private Usuario autor;
	@ManyToOne(cascade = CascadeType.ALL, optional=false)
	private Noticia noticia;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
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
	public Noticia getNoticia(){
		return noticia;
	}
	public void setNoticia(Noticia noticia){
		this.noticia = noticia;
	}
}
