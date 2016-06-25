package br.ufc.quixada.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="classificados")
@NamedQueries({
		@NamedQuery(name="Classificado.todos",query="SELECT c FROM Classificado c")
})
public class Classificado {
	@Id @GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String titulo;
	@Column(columnDefinition="TEXT", nullable=false)
	//@Column(nullable=false)
	private String texto;
	@Column(nullable=false)
	private Double preco;
	@Column(nullable=false)
	private String contato;
	@Column(name="valor_oferta")
	private Double valorOferta;
	@Column(name="data_oferta")
	private Date dataOferta;
	@ManyToOne(optional=true)
	@JoinColumn(name="autor_oferta")
	private Usuario autorOferta;
	
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public Double getValorOferta() {
		return valorOferta;
	}
	public void setValorOferta(Double valorOferta) {
		this.valorOferta = valorOferta;
	}
	public Date getDataOferta() {
		return dataOferta;
	}
	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}
	public Usuario getAutorOferta() {
		return autorOferta;
	}
	public void setAutorOferta(Usuario autorOferta) {
		this.autorOferta = autorOferta;
	}
}
