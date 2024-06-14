package br.ufmg.dcc.luar.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Albumn albumn;

	@Column
	private String title;

	@Column
	private String genre;

	@Lob
	private byte[] audioFile;

	public int getId() {
		return id;
	}

	public Albumn getAlbumn() {
		return albumn;
	}

	public void setAlbumn(Albumn albumn) {
		this.albumn = albumn;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public byte[] getAudioFile() {
		return audioFile;
	}

	public void setAudioFile(byte[] audioFile) {
		this.audioFile = audioFile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumn, genre, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		return Objects.equals(albumn, other.albumn) && Objects.equals(genre, other.genre) && id == other.id
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", albumn=" + albumn + ", title=" + title + ", genre=" + genre + "]";
	}

}
