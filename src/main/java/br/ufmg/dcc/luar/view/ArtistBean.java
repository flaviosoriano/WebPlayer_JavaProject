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

import br.ufmg.dcc.luar.model.Artist;

@Named
@RequestScoped
public class ArtistBean {

	private EntityManagerFactory factory;

	private List<Artist> artists;

	private Artist newArtist = new Artist();

	@PostConstruct
	public void init() {
		factory = Persistence.createEntityManagerFactory("WebPlayer_JavaProject");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Artist> query = manager.createQuery("SELECT a FROM Artist a", Artist.class);
		artists = query.getResultList();
	}

	public Artist getNewArtist() {
		return newArtist;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public String listRedirect() {
		return "list?faces-redirect=true";
	}

	@Transactional
	public String addArtist() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(newArtist);
		manager.getTransaction().commit();
		manager.close();
		init();
		newArtist = new Artist();
		return "registerAlbumn?faces-redirect=true";
	}
	
	@Transactional
	public void loadArtist(int id) {
	    EntityManager manager = factory.createEntityManager();
	    newArtist = manager.find(Artist.class, id);
	    manager.close();
	}
	@Transactional
	public String updateArtist() {
	    EntityManager manager = factory.createEntityManager();
	    manager.getTransaction().begin();
	    manager.merge(newArtist);
	    manager.getTransaction().commit();
	    manager.close();
	    init();
	    newArtist = new Artist();
	    return "index?faces-redirect=true";
	}



	@Transactional
	public String deleteArtist(int id) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Artist toBeDeleted = manager.find(Artist.class, id);
		if (toBeDeleted != null) {
			manager.remove(toBeDeleted);
		}
		manager.getTransaction().commit();
		manager.close();
		init();
		return "index?faces-redirect=true";
	}
}
