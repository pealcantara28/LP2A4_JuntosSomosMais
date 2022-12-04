package com.juntos.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name= "Cliente")
@Table(name = "clientes")
public class Cliente {

	
	public Cliente() {
		super();
	}

	@Column(name ="cellPhone")
	private String cellPhone;

	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private char gender;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nameInfo_id", referencedColumnName = "id")
	private Name name;
	
	@Column(name = "nationality")
	private String nationality;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "picture_id", referencedColumnName = "id")
	private Picture pictureInfo;
	
	@Column(name = "registeredDate")
	private Date registeredDate;
	
	
	@Column(name = "telePhone")
	private String telePhone;
	

	@Column(name = "type")
	private String type;
	
	public Cliente(char gender, String email, String type, Date dateOfBirth, Date registeredDate,
			String telePhone, String cellPhone, Location location, Picture pictureInfo, Name name,
			String nationality) {
		super();
		this.gender = gender;
		this.email = email;
		this.type = type;
		this.dateOfBirth = dateOfBirth;
		this.registeredDate = registeredDate;
		this.telePhone = telePhone;
		this.cellPhone = cellPhone;
		this.location = location;
		this.pictureInfo = pictureInfo;
		this.name = name;
		this.nationality = nationality;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public char getGender() {
		return gender;
	}

	public Long getId() {
		return id;
	}

	public Location getLocation() {
		return location;
	}

	public Name getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public Picture getPictureInfo() {
		return pictureInfo;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	
	public String getTelePhone() {
		return telePhone;
	}

	public String getType() {
		return type;
	}
	
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setPictureInfo(Picture pictureInfo) {
		this.pictureInfo = pictureInfo;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	
	
}
