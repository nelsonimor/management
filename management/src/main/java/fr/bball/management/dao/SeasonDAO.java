package fr.bball.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bball.management.bo.LeagueBO;
import fr.bball.management.bo.SeasonBO;
import fr.bball.management.bo.TeamBO;

public interface SeasonDAO extends JpaRepository<SeasonBO, Integer> {
	
    public List<SeasonBO>findAll();
    
    public List<SeasonBO>findByTeam(TeamBO team);


}
