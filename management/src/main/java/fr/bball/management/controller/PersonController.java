package fr.bball.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.bball.management.bo.PersonBO;
import fr.bball.management.bo.TeamBO;
import fr.bball.management.dao.PersonDAO;
import fr.bball.management.dao.TeamDAO;
import io.swagger.annotations.Api;

@Api( description="API pour les opérations CRUD sur les players")
@RestController
public class PersonController {

    @Autowired
    private PersonDAO personDAO;
    
	@RequestMapping(value="/Persons", method=RequestMethod.GET)
	public List<PersonBO> listTeams() {
		List<PersonBO> persons = personDAO.findAll();
		return persons;
	}




}
