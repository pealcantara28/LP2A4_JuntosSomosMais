package com.juntos.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {

	public Location() {
		super();
	}
	@Column(name = "city")
	private String city;
	@OneToOne(mappedBy = "location")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coordinates_id", referencedColumnName = "id")
	private Coordinates coordinates;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	public Long id;
	
	@Column(name = "postcode")
	private int postcode;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "street")
	private String street;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "timezones_id", referencedColumnName = "id")
	private Timezone timezone;
	
	
	public Location(String street, String city, String state, int postcode, String region, Timezone timezone)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.region = region;
		this.timezone = timezone;
	}


	public String getCity() {
		return city;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public int getPostcode() {
		return postcode;
	}
	public String getRegion() {
		return region;
	}
	public String getState() {
		return state;
	}
	public String getStreet() {
		return street;
	}
	public Timezone getTimezones() {
		return timezone;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setTimezone(Timezone timezones) {
		this.timezone = timezones;
	}

	
	
	
}
