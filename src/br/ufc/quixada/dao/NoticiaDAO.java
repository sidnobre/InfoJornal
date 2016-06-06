package br.ufc.quixada.dao;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.quixada.model.Noticia;
import br.ufc.quixada.model.Secao;

@RequestScoped
public class NoticiaDAO implements INoticiaDAO{
	
	@Inject
	private EntityManager manager;

	public void adicionar(Noticia noticia) {
		manager.persist(noticia);
	}

	public void remover(Noticia noticia) {
		manager.remove(noticia);
	}

	public Noticia buscar(Long id) {
		return manager.find(Noticia.class, id);
	}
	
	public List<Noticia> buscarPorData(Date dataInicio, Date dataFinal){
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.porData", Noticia.class);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFinal", dataFinal);
		return query.getResultList();
	}
	
	public List<Noticia> buscarPorTitulo(Noticia noticia){
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.porTitulo", Noticia.class);
		query.setParameter("titulo", "%"+noticia.getTitulo()+"%");
		return query.getResultList();
	}
	
	public List<Noticia> buscarPorAutor(Noticia noticia){
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.porAutor", Noticia.class);
		query.setParameter("autor", noticia.getAutor());
		return query.getResultList();
	}

	public List<Noticia> listar() {
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.todas",Noticia.class);
		return query.getResultList();
	}
	
	public List<Noticia> listar(Secao secao){
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.porSecao", Noticia.class);
		query.setParameter("secao", secao);
		return query.getResultList();
	}
	
	public List<Noticia> ultimaPorSecao(){
		TypedQuery<Noticia> query = manager.createNamedQuery("Noticia.ultimaPorSecao", Noticia.class);
		return query.getResultList();
	}
}