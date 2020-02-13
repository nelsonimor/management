package fr.bball.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bball.management.bo.PersonBO;

public interface PersonDAO extends JpaRepository<PersonBO, Integer> {
	
    public List<PersonBO> findAll();


}
