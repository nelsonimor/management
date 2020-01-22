package fr.bball.management.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "League")
public class LeagueBO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	@Length(min=3, max=20)
	private String name;
	
	private String type;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CITY_ID",nullable = true)
	private CityBO city;
	
	public LeagueBO() {
		// TODO Auto-generated constructor stub
	}
	
	@PreRemove
	public void preRemove() {
	    setCity(null);
	}

	
	public LeagueBO(int id,String name,String type,CityBO city) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.city = city;
	}
	
	public CityBO getCity() {
		return city;
	}

	public void setCity(CityBO city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	

}
