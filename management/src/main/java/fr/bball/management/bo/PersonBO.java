package fr.bball.management.bo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import fr.bball.management.dto.City;

@Entity
@Table(name = "Person")
public class PersonBO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false)
	private String firstname;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_COUNTRY1_ID",nullable = false)
	private CountryBO nat1;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_COUNTRY2_ID",nullable = true)
	private CountryBO nat2;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CITY_ID",nullable = true)
	private CityBO birthcity;
	
	@Column(nullable = false)
	private Date birthdate;
	
	@Column(nullable = false)
	private int height;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public CountryBO getNat1() {
		return nat1;
	}

	public void setNat1(CountryBO nat1) {
		this.nat1 = nat1;
	}

	public CountryBO getNat2() {
		return nat2;
	}

	public void setNat2(CountryBO nat2) {
		this.nat2 = nat2;
	}



	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public CityBO getBirthcity() {
		return birthcity;
	}

	public void setBirthcity(CityBO birthcity) {
		this.birthcity = birthcity;
	}

}
