package com.juntos.domain.viewmodel;

import com.juntos.domain.entities.*;

public class TempCliente {
	public TempCliente() {
		super();
	}

	private String Cell;

	private Dates Dob;
	private String Email;
	private String gender;
	private Location Location;
	private Name Name;
	private String Phone;
	private Picture Picture;
	private Dates Registered;

	public TempCliente(String gender, Name name, Location location, String email, Dates dob, Dates registered,
			String phone, String cell, Picture picture) {
		super();
		this.gender = gender;
		this.Name = name;
		this.Location = location;
		this.Email = email;
		this.Dob = dob;
		this.Registered = registered;
		this.Phone = phone;
		this.Cell = cell;
		this.Picture = picture;
	}

	public String getCell() {
		return Cell;
	}

	public Dates getDob() {
		return Dob;
	}

	public String getEmail() {
		return Email;
	}

	public String getGender() {
		return gender;
	}

	public Location getLocation() {
		return Location;
	}

	public Name getName() {
		return Name;
	}

	public String getPhone() {
		return Phone;
	}

	public Picture getPicture() {
		return Picture;
	}

	public Dates getRegistered() {
		return Registered;
	}

	public void setCell(String cell) {
		Cell = cell;
	}

	public void setDob(Dates dob) {
		Dob = dob;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLocation(Location location) {
		Location = location;
	}

	public void setName(Name name) {
		Name = name;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setPicture(Picture picture) {
		Picture = picture;
	}

	public void setRegistered(Dates registered) {
		Registered = registered;
	}
}
