package com.juntos.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "NameInfo")
@Table(name = "nameInfo")
public class Name {

	public Name() {
		super();
	}
	@OneToOne(mappedBy = "name")
	private Cliente cliente;
	
	@Column(name = "first")
	private String first;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	public Long id;
	
	@Column(name = "last")
	private String last;
	@Column(name = "title")
	private String title;

	public Name(String title, String first, String last)
	{
		this.title = title;
		this.first = first;
		this.last = last;
	}
	

	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public String getTitle() {
		return title;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
}
