package fr.bball.management.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.LeagueBO;
import fr.bball.management.dao.CityDAO;
import fr.bball.management.dao.LeagueDAO;
import fr.bball.management.exception.LeagueNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( description="API pour les opérations CRUD sur les leagues")
@RestController
public class LeagueController {
	
	Logger logger = LoggerFactory.getLogger(LeagueController.class);
	
    @Autowired
    private LeagueDAO leagueDAO;
    
    @Autowired
    private CityDAO cityDAO;
    
    
    @ApiOperation(value = "Récupère l'ensemble des leagues présentes dans le système")
	@RequestMapping(value="/Leagues", method=RequestMethod.GET)
	public List<LeagueBO> listLeagues() {
		logger.debug("-> List all leagues");
		List<LeagueBO> leagues = leagueDAO.findAll();
		logger.debug("-> List all leagues : {} leagues found",leagues.size());
		return leagues;
	}
	
	@RequestMapping(value="/Leagues/count", method=RequestMethod.GET)
	public long count() {
		return leagueDAO.count();
	}

	@GetMapping(value="/Leagues/{id}")
	public LeagueBO showLeagueById(@PathVariable int id) {
		
		LeagueBO league = leagueDAO.findById(id);;
		
		if(league==null) {
			throw new LeagueNotFoundException("No league found with id : "+id);
		}
		
		return league;
	}
	
	@DeleteMapping(value="/Leagues/{id}")
	public void delLeagueById(@PathVariable int id) {
		leagueDAO.deleteById(id);
	}
	
    @PostMapping(value = "/Leagues")
    public ResponseEntity<Void> addLeague(@RequestBody @Valid LeagueBO league) {
    	System.out.println("LeagueController.addLeague()");
    	
    	if(league.getCity()!=null) {
    		CityBO city = cityDAO.findByNameEquals(league.getCity().getName());
    		if(city!=null) {
    			System.out.println("City ["+league.getCity().getName()+"] already exists");
    			league.setCity(city);
    		}
    	}
    	
    	LeagueBO leagueAdded = leagueDAO.save(league);
    	
        if (leagueAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(leagueAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    	
    }
    
	@GetMapping(value="/Leagues/type/{type}")
	public List<LeagueBO> getLeaguesByType(@PathVariable String type) {
		System.out.println("LeagueController.getLeaguesByType() type = "+type);
		return leagueDAO.findByTypeEquals(type);
	}
	




}
