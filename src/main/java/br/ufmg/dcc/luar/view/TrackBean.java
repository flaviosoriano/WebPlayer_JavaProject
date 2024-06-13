package br.ufmg.dcc.luar.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.ufmg.dcc.luar.model.Track;

@Named("trackBean")
@RequestScoped
public class TrackBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManagerFactory factory;

	private List<Track> tracks;

	private Track newTrack = new Track();

	@PostConstruct
	public void init() {
		factory = Persistence.createEntityManagerFactory("WebPlayer_JavaProject");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Track> query = manager.createQuery("SELECT t FROM Track t", Track.class);
		tracks = query.getResultList();
		manager.close();
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Track getNewTrack() {
		return newTrack;
	}

	public String voltar() {
		return "index?faces-redirect=true";
	}

	@Transactional
	public String addTrack() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(newTrack);
		manager.getTransaction().commit();
		manager.close();
		init();
		newTrack = new Track();
		return "index?faces-redirect=true";
	}

	@Transactional
	public String deleteTrack(int id) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Track toBeDeleted = manager.find(Track.class, id);
		if (toBeDeleted != null) {
			manager.remove(toBeDeleted);
		}
		manager.getTransaction().commit();
		manager.close();
		init();
		return "index?faces-redirect=true";
	}
}
