package fr.bball.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bball.management.bo.PersonSeasonBO;
import fr.bball.management.bo.SeasonBO;

public interface PersonSeasonDAO extends JpaRepository<PersonSeasonBO, Integer> {
	
    public List<PersonSeasonBO>findBySeason(SeasonBO seasonBO);
    



}
