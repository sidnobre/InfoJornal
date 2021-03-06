package br.ufc.quixada.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="noticias")
@NamedQueries({
	@NamedQuery(name="Noticia.todas", query="SELECT n FROM Noticia n"),
	@NamedQuery(name="Noticia.porSecao",query="SELECT n FROM Noticia n WHERE n.secao = :secao"),
	@NamedQuery(
			name="Noticia.ultimaPorSecao",
			query="SELECT n1 FROM Noticia n1 "
					+ "WHERE n1.data = (SELECT MAX(n2.data) FROM Noticia n2 WHERE n2.secao = n1.secao) "
					+ "ORDER BY n1.data"),
	@NamedQuery(name="Noticia.porData",query="SELECT n FROM Noticia n WHERE n.data BETWEEN :dataInicio AND :dataFinal"),
	@NamedQuery(name="Noticia.porTitulo",query="SELECT n FROM Noticia n WHERE n.titulo LIKE :titulo"),
	@NamedQuery(name="Noticia.porAutor",query="SELECT n FROM Noticia n WHERE n.autor = :autor")
})
public class Noticia {
	@Id @GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false)
	private String subtitulo;
	@Column(columnDefinition="TEXT", nullable=false)
	private String texto;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	@Column(nullable=false)
	private String imagem;
	@ManyToOne(optional=false)
	private Secao secao;
	@ManyToOne(optional=false)
	private Usuario autor;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="noticia")
	private List<Comentario> comentarios;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Secao getSecao() {
		return secao;
	}
	public void setSecao(Secao secao) {
		this.secao = secao;
	}
	public Usuario getAutor(){
		return autor;
	}
	public void setAutor(Usuario autor){
		this.autor = autor;
	}
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios){
		this.comentarios = comentarios;
	}
}