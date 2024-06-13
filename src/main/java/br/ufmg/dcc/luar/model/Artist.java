package br.ufmg.dcc.luar.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "artist")
	private List<Albumn> albumns;

	public List<Albumn> getAlbumns() {
		return albumns;
	}

	public void setAlbumns(List<Albumn> albumns) {
		this.albumns = albumns;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumns, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		return Objects.equals(albumns, other.albumns) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", albumns=" + albumns + "]";
	}
	
	

}
