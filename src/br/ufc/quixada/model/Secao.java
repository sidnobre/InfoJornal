package br.ufc.quixada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="secoes")
@NamedQueries({
	@NamedQuery(name="Secao.todas", query="SELECT s FROM Secao s ORDER BY s.titulo")
})
public class Secao {
	
	@Id @GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false)
	private String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}