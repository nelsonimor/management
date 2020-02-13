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


@Entity
@Table(name = "Team")
public class TeamBO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CITY1_ID",nullable = true)
	private CityBO city1;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CITY2_ID",nullable = true)
	private CityBO city2;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_CITY3_ID",nullable = true)
	private CityBO city3;

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

	public CityBO getCity1() {
		return city1;
	}

	public void setCity1(CityBO city1) {
		this.city1 = city1;
	}

	public CityBO getCity2() {
		return city2;
	}

	public void setCity2(CityBO city2) {
		this.city2 = city2;
	}

	public CityBO getCity3() {
		return city3;
	}

	public void setCity3(CityBO city3) {
		this.city3 = city3;
	}

}
