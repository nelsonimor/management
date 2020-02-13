package fr.bball.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.bball.management.bo.LeagueBO;
import fr.bball.management.bo.SeasonBO;
import fr.bball.management.bo.TeamBO;
import fr.bball.management.dao.SeasonDAO;
import fr.bball.management.dao.TeamDAO;
import io.swagger.annotations.Api;

@Api( description="API pour les opérations CRUD sur les seasons")
@RestController
public class SeasonController {
	
	
	static Logger logger = LoggerFactory.getLogger(SeasonController.class);

    @Autowired
    private SeasonDAO seasonDAO;
    
    @Autowired
    private TeamDAO teamDAO;
    
	@RequestMapping(value="/Seasons", method=RequestMethod.GET)
	public List<SeasonBO> listSeasons() {
		List<SeasonBO> seasonBOs = seasonDAO.findAll();
		return seasonBOs;
	}
	
	@GetMapping(value="/Seasons/team/{teamName}")
	public List<SeasonBO> getSeasonsByTeam(@PathVariable String teamName) {
		TeamBO team = teamDAO.findByName(teamName);
		return seasonDAO.findByTeam(team);
	}




}
