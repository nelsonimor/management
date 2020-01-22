package fr.bball.management.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Arena")
public class ArenaBO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	@Column(name = "name",unique = true)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CITY_ID",nullable = false)
	private CityBO city;
	
	private int capacity;
	private int yearcreation;
	

	public ArenaBO() {
		// TODO Auto-generated constructor stub
	}
	
	public ArenaBO(int id,String name,int capacity,int yearcreation) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.yearcreation = yearcreation;
	}
	
	@PreRemove
	public void preRemove() {
	    setCity(null);
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

	public CityBO getCity() {
		return city;
	}

	public void setCity(CityBO city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getYearcreation() {
		return yearcreation;
	}

	public void setYearcreation(int yearcreation) {
		this.yearcreation = yearcreation;
	}


	

	

}
