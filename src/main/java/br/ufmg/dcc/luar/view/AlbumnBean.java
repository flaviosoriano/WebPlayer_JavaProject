package br.ufmg.dcc.luar.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.ufmg.dcc.luar.model.Albumn;

@Named
@RequestScoped
public class AlbumnBean {

	private EntityManagerFactory factory;

	private List<Albumn> albumns;

	private Albumn newAlbumn = new Albumn();

	@PostConstruct
	public void init() {
		factory = Persistence.createEntityManagerFactory("WebPlayer_JavaProject");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Albumn> query = manager.createQuery("SELECT a FROM Albumn a", Albumn.class);
		albumns = query.getResultList();
		manager.close();
	}

	public Albumn getNewAlbumn() {
		return newAlbumn;
	}

	public List<Albumn> getAlbumns() {
		return albumns;
	}

	public String listRedirect() {
		return "list?faces-redirect=true";
	}

	@Transactional
	public String addAlbumn() {
    	EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(newAlbumn);
        manager.getTransaction().commit();
        manager.close();
        init();
		newAlbumn = new Albumn();
		return "registerTrack?faces-redirect=true";
	}
	
	@Transactional
	public String deleteAlbumn(int id) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Albumn toBeDeleted = manager.find(Albumn.class, id);
		if (toBeDeleted != null) {
			manager.remove(toBeDeleted);
		}
		manager.getTransaction().commit();
		manager.close();
		init();
		return "index?faces-redirect=true";
	}
}
