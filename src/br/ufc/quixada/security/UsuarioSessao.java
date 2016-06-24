package br.ufc.quixada.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufc.quixada.model.Papel;
import br.ufc.quixada.model.Usuario;

@Named("usuarioSessao")
@SessionScoped
public class UsuarioSessao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Papel papel;
	
	public void criar(Usuario usuario, Papel papel){
		this.usuario = usuario;
		this.papel = papel;
	}
	
	public void destruir(){
		this.usuario = null;
		this.papel = null;
		
	}
	
	public boolean isAutenticado(){
		return usuario != null && papel != null;
	}
	
	public String getNome(){
		return this.usuario.getNome();
	}
	
	public Papel getPapel(){
		return papel;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
}
