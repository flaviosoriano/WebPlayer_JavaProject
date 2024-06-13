package br.ufmg.dcc.luar.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Albumn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Artist artist;

	@Column
	private String title;

	@OneToMany(mappedBy = "albumn")
	private List<Track> tracks;

	@Column(name = "Cover")
	private String coverImageFileUrl;

	public int getId() {
		return id;
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

	public String getCoverImageFileUrl() {
		return coverImageFileUrl;
	}

	public void setCoverImageFileUrl(String coverImageFileUrl) {
		this.coverImageFileUrl = coverImageFileUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, coverImageFileUrl, id, title, tracks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Albumn other = (Albumn) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(coverImageFileUrl, other.coverImageFileUrl)
				&& id == other.id && Objects.equals(title, other.title) && Objects.equals(tracks, other.tracks);
	}

	@Override
	public String toString() {
		return "Albumn [id=" + id + ", artist=" + artist + ", title=" + title + ", tracks=" + tracks
				+ ", coverImageFileUrl=" + coverImageFileUrl + "]";
	}
	
	

}
