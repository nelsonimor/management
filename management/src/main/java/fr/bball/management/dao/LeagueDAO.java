package fr.bball.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bball.management.bo.LeagueBO;

public interface LeagueDAO extends JpaRepository<LeagueBO, Integer> {
	
    public List<LeagueBO>findAll();
    public LeagueBO findById(int id);
    public LeagueBO save(LeagueBO product);
    public void deleteById(int id);
    public List<LeagueBO> findByTypeEquals(String type);

}
