package br.ufc.quixada.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="papeis")
@NamedQuery(name="Papel.todos", query="SELECT p FROM Papel p")
public class Papel {
	@Id @GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String descricao;
	@Column(nullable=false)
	private long nivel;
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Usuario> usuarios;
	
	public static final Long LEITOR_ID = 1L;
	public static final Long JORNALISTA_ID = 2L;
	public static final Long EDITOR_ID = 3L;
	public static final long LEITOR_NIVEL = 1000;
	public static final long JORNALISTA_NIVEL = 2000;
	public static final long EDITOR_NIVEL = 3000;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getNivel() {
		return nivel;
	}
	public void setNivel(long nivel) {
		this.nivel = nivel;
	}
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios){
		this.usuarios = usuarios;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (nivel ^ (nivel >>> 32));
		return result;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Papel)) return false;
		Papel refPapel = (Papel) obj;
		if(this.id!=refPapel.getId()) return false;
		return true;
	}
	
	
}
