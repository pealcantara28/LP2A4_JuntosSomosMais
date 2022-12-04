package com.juntos.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Coordinates")
public class Coordinates {

	public Coordinates() {
		super();
	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	
	@Column(name = "latitude")
	private Double latitude;
	
	@OneToOne(mappedBy = "coordinates")
	private Location location;
	
	@Column(name = "longitude")
	private Double longitude;
	
	
	public Coordinates(String latitude, String longitude)
	{
		this.latitude = Double.parseDouble(latitude);
		this.longitude =  Double.parseDouble(longitude);
	}


	public Double getLatitude() {
		return latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
