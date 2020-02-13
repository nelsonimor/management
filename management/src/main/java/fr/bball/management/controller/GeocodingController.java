package fr.bball.management.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import compute.NominatimReverseGeocodingJAPI;
import fr.bball.management.ManagementApplication;
import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.CountryBO;
import fr.bball.management.bo.LeagueBO;
import fr.bball.management.dao.CityDAO;
import fr.bball.management.dao.CountryDAO;
import fr.bball.management.dto.City;
import fr.bball.management.dto.GeocodingRequest;
import fr.bball.management.dto.GeocodingResponse;
import fr.bball.management.exception.CountryNotFoundException;
import fr.bball.management.exception.LeagueNotFoundException;
import fr.bball.management.mapper.CityMapper;
import io.swagger.annotations.Api;
import model.Address;

@Api( description="API pour les opérations de geocoding")
@RestController
public class GeocodingController {
	
	static Logger logger = LoggerFactory.getLogger(GeocodingController.class);
	
    @PostMapping(value = "/Geocoding")
    public ResponseEntity<Void> geocoding(@RequestBody @Valid GeocodingRequest geocodingRequest) {

    	System.out.println("GeocodingController.geocoding() : cityName = "+geocodingRequest.getCityName()+" - countryName = "+geocodingRequest.getCountryName());
    	
    	logger.debug("Geocoding : cityName = {} / countryName = {}",geocodingRequest.getCityName(),geocodingRequest.getCountryName());
    	
    	NominatimReverseGeocodingJAPI geocoding = new NominatimReverseGeocodingJAPI();
    	Address address = geocoding.getAdress(geocodingRequest.getCityName(), geocodingRequest.getCountryName());
    	
    	logger.debug("Result : X = {} / Y = {}",address.getLat(),address.getLon());
    	
    	GeocodingResponse geocodingResponse = new GeocodingResponse();
    	geocodingResponse.setAddress(address);
    	
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{address}")
                .buildAndExpand(geocodingResponse.getAddress())
                .toUri();

        return ResponseEntity.created(location).build();	
    }



}
