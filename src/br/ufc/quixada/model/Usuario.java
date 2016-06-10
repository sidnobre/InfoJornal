package br.ufc.quixada.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
@NamedQueries({
	@NamedQuery(name="Usuario.porLogin",query="SELECT u FROM Usuario u WHERE u.login = :login"),
	@NamedQuery(name="Usuario.porLoginSenha", query="SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha"),
	@NamedQuery(name="Usuario.jornalistas",query="SELECT u FROM Usuario u INNER JOIN u.papeis p WHERE p.id = :papel")
	
})
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	@Column(nullable=false ,unique=true)
	private String login;
	@Column(nullable=false)
	private String senha;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false, unique=true)
	private String email;
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Papel> papeis;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
}