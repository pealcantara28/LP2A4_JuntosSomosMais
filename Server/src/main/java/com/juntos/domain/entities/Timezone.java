package com.juntos.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "Timezone")
@Table(name = "timezone")
public class Timezone {

	public Timezone() {
		super();
	}

	@Column(name = "description")
	private String description;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@OneToOne(mappedBy = "timezone")
	private Location location;
	
	@Column(name = "offset")
	private String offset;
	
	
	public Timezone(String offset, String description)
	{
		this.offset = offset;
		this.description = description;
	}


	public String getDescription() {
		return description;
	}

	public String getOffset() {
		return offset;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}
	
	
	
}
