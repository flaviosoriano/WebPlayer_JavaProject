package br.ufmg.dcc.luar.model;

import java.io.Serializable;

public class Albumn implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String title;
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
	
}
