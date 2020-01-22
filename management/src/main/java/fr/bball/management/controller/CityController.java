package fr.bball.management.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import compute.NominatimReverseGeocodingJAPI;
import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.CountryBO;
import fr.bball.management.bo.LeagueBO;
import fr.bball.management.dao.CityDAO;
import fr.bball.management.dao.CountryDAO;
import fr.bball.management.dto.City;
import fr.bball.management.exception.CountryNotFoundException;
import fr.bball.management.exception.LeagueNotFoundException;
import fr.bball.management.mapper.CityMapper;
import io.swagger.annotations.Api;
import model.Address;

@Api( description="API pour les opérations CRUD sur les villes")
@RestController
public class CityController {
	

    @Autowired
    private CityDAO cityDAO;
    
    @Autowired
    private CountryDAO countryDAO;
    
   
	@RequestMapping(value="/Cities", method=RequestMethod.GET)
	public List<City> listCities() {
		List<CityBO> citites = cityDAO.findAll();
		
		List<City> result = new ArrayList<City>();
		for (Iterator iterator = citites.iterator(); iterator.hasNext();) {
			CityBO city = (CityBO) iterator.next();
			result.add(CityMapper.boToDto(city));
		}
		
		return result;
	}
	
    @PostMapping(value = "/Cities")
    public ResponseEntity<Void> addCity(@RequestBody @Valid City city) {

    	
    	NominatimReverseGeocodingJAPI geocoding = new NominatimReverseGeocodingJAPI();
    	Address address = geocoding.getAdress(city.getName(), city.getCountryName());
    	
    	
    	CountryBO countryBO = countryDAO.findByNameEquals(city.getCountryName());
		if(countryBO==null) {
			throw new CountryNotFoundException("No country found with name : "+city.getCountryName());
		}
    	
    	CityBO cityBO = CityMapper.dtoToBo(city, countryBO,address.getLon(),address.getLat());

    	CityBO cityBOAdded = cityDAO.save(cityBO);
    	
        if (cityBOAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cityBOAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();	
    }



}
