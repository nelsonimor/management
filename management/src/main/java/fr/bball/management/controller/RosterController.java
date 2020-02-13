package fr.bball.management.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.bball.management.bo.PersonSeasonBO;
import fr.bball.management.bo.SeasonBO;
import fr.bball.management.dao.PersonSeasonDAO;
import fr.bball.management.dao.SeasonDAO;
import fr.bball.management.dto.Person;
import fr.bball.management.dto.Roster;
import fr.bball.management.dto.RosterItem;
import fr.bball.management.dto.Team;
import io.swagger.annotations.Api;

@Api( description="API pour les opérations CRUD sur les seasons")
@RestController
public class RosterController {
	
	static Logger logger = LoggerFactory.getLogger(RosterController.class);

    @Autowired
    private SeasonDAO seasonDAO;
    
    @Autowired
    private PersonSeasonDAO personSeasonDAO;

	@GetMapping(value="/Rosters/seasonId/{seasonId}")
	public Roster getRosterBySeasonId(@PathVariable Integer seasonId) {
		Optional<SeasonBO> seasonBO = seasonDAO.findById(seasonId);
		List<PersonSeasonBO> personSeasonBos = personSeasonDAO.findBySeason(seasonBO.get());
		
		Roster roster = new Roster();
		roster.setStart(seasonBO.get().getStartDate());
		roster.setEnd(seasonBO.get().getEndDate());
		
		Team team = new Team();
		team.setName(seasonBO.get().getTeam().getName());
		team.setCityName(seasonBO.get().getTeam().getCity1().getName());
		team.setCountryName(seasonBO.get().getTeam().getCity1().getCountry().getName());
		roster.setTeam(team);
		
		
		for (Iterator iterator = personSeasonBos.iterator(); iterator.hasNext();) {
			PersonSeasonBO personSeasonBO = (PersonSeasonBO) iterator.next();
			RosterItem rosterItem = new RosterItem();
			Person person = new Person();
			person.setFirstname(personSeasonBO.getPerson().getFirstname());
			person.setLastname(personSeasonBO.getPerson().getLastname());
			rosterItem.setPerson(person);
			
			if(personSeasonBO.getStartDate()==null && personSeasonBO.getEndDate()==null) {
				rosterItem.setStatus("Active");
			}
			else if(personSeasonBO.getStartDate()==null && personSeasonBO.getEndDate()!=null) {
				rosterItem.setStatus("Removed");
			}
			else if(personSeasonBO.getStartDate()!=null && personSeasonBO.getEndDate()==null) {
				rosterItem.setStatus("Inserted");
			}
			
			
			

			roster.addItem(rosterItem);
		}
		
		
		return roster;
	}




}
