package fr.bball.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.LeagueBO;
import fr.bball.management.bo.TeamBO;

public interface TeamDAO extends JpaRepository<TeamBO, Integer> {
	
    public List<TeamBO>findAll();
    
    public List<TeamBO>findByCity1(CityBO city);
    
    public TeamBO findByName(String name);

}
