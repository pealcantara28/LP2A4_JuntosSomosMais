package com.juntos.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Picture")
public class Picture {
	
	public Picture() {
		super();
	}
	@OneToOne(mappedBy = "pictureInfo")
	private Cliente cliente;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	public Long id;
	
	@Column(name ="large")
	private String large;
	
	@Column(name ="medium")
	private String medium;
	
	@Column(name ="thumbnail")
	private String thumbnail;
	
	
	public Picture(String large, String medium, String thumbnail)
	{
		this.large = large;
		this.medium = medium;
		this.thumbnail = thumbnail;
	}
	
	public String getLarge() {
		return large;
	}
	public String getMedium() {
		return medium;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setLarge(String large) {
		this.large = large;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
}
