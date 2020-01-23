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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Country")
public class CountryBO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CONTINENT_ID",nullable = false)
	private ContinentBO continent;
	
	@Column(nullable = false)
	private String codeiso2;
	
	@Column(nullable = false)
	private String codeiso3;
	private String nationality;
	

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
	public ContinentBO getContinent() {
		return continent;
	}
	public void setContinent(ContinentBO continent) {
		this.continent = continent;
	}
	public String getCodeiso2() {
		return codeiso2;
	}
	public void setCodeiso2(String codeiso2) {
		this.codeiso2 = codeiso2;
	}
	public String getCodeiso3() {
		return codeiso3;
	}
	public void setCodeiso3(String codeiso3) {
		this.codeiso3 = codeiso3;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	

}
