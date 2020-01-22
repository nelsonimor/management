package fr.bball.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.CountryBO;
import fr.bball.management.bo.LeagueBO;

public interface CountryDAO extends JpaRepository<CountryBO, Integer> {
	
    public CountryBO findByNameEquals(String name);

}
