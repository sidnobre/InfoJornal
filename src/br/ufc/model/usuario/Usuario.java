package br.ufc.model.usuario;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

//Classe pai dos modelos dependentes de Ususario onde os filhos modificam apenas a variavel tipo

public class Usuario {
	private int id;
	
	@NotBlank(message = "*")
	private String nome;	
	

	@NotBlank(message = "*")
	@Size(min=6, message="*")	
	private String login;
	

	@NotBlank(message = "*")
	@Size(min=6, message="*")
	private String senha;
	

	@NotBlank(message = "*")
	private String email;
	
	private String tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
}
