package fr.bball.management.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.CountryBO;
import fr.bball.management.bo.LeagueBO;
import fr.bball.management.bo.TeamBO;
import fr.bball.management.dao.CityDAO;
import fr.bball.management.dao.CountryDAO;
import fr.bball.management.dao.TeamDAO;
import io.swagger.annotations.Api;

@Api( description="API pour les opérations CRUD sur les équipes")
@RestController
public class TeamController {
	
	static Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamDAO teamDAO;
    
    @Autowired
    private CityDAO cityDAO;
    
    @Autowired
    private CountryDAO countryDAO;
    
	@RequestMapping(value="/Teams", method=RequestMethod.GET)
	public List<TeamBO> listTeams() {
		List<TeamBO> teams = teamDAO.findAll();
		return teams;
	}
	
	@GetMapping(value="/Teams/city/{cityName}")
	public List<TeamBO> getTeamsByCity(@PathVariable String cityName) {
		CityBO cityBO = cityDAO.findByNameEquals(cityName);
		List<TeamBO> teams = teamDAO.findByCity1(cityBO);
		return teams;
	}
	
	@GetMapping(value="/Teams/country/{countryName}")
	public List<TeamBO> getTeamsByCountry(@PathVariable String countryName) {
		CountryBO country = countryDAO.findByNameEquals(countryName);
		List<CityBO> cities = cityDAO.findByCountry(country);
		List<TeamBO> teams = new ArrayList<TeamBO>();
		for (Iterator iterator = cities.iterator(); iterator.hasNext();) {
			CityBO city1 = (CityBO) iterator.next();
			List<TeamBO> ts = teamDAO.findByCity1(city1);
			for (Iterator iterator2 = ts.iterator(); iterator2.hasNext();) {
				TeamBO teamBO = (TeamBO) iterator2.next();
				teams.add(teamBO);
			}
			
		}
		return teams;
	}




}
