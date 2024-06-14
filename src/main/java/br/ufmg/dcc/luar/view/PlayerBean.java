package br.ufmg.dcc.luar.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufmg.dcc.luar.model.Track;

@Named
@RequestScoped
public class PlayerBean {
	
	private int trackId;
	private EntityManagerFactory factory;
	
	private Track playedTrack;
	
	
	public void init() {
		factory = Persistence.createEntityManagerFactory("WebPlayer_JavaProject");
		EntityManager manager = factory.createEntityManager();
		playedTrack = manager.find(Track.class, trackId);
		manager.close();
		System.out.println("funcionou");
	}
	
	
	
	
	

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public Track getPlayedTrack() {
		return playedTrack;
	}

	public void setPlayedTrack(Track playedTrack) {
		this.playedTrack = playedTrack;
	}
	
	

}
