package fr.bball.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bball.management.bo.CityBO;

public interface CityDAO extends JpaRepository<CityBO, Integer> {
	
    public CityBO findByNameEquals(String name);

}
