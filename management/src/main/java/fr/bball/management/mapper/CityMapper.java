package fr.bball.management.mapper;

import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.CountryBO;
import fr.bball.management.dto.City;
import model.Address;

public class CityMapper {
	
	public static City boToDto(CityBO cityBo) {
		City city = new City();
		city.setId(cityBo.getId());
		city.setName(cityBo.getName());
		city.setLongitude(cityBo.getLongitude());
		city.setLatitude(cityBo.getLatitude());
		if(cityBo.getCountry()!=null) {
			city.setCountryName(cityBo.getCountry().getName());
		}
		return city;
	}
	
	public static CityBO dtoToBo(City  city,CountryBO countryBo,Address address) {
		CityBO cityBo = new CityBO();
		cityBo.setId(city.getId());
		cityBo.setName(city.getName());
		cityBo.setCountry(countryBo);
		cityBo.setLongitude(address.getLon());
		cityBo.setLatitude(address.getLat());
		cityBo.setCounty(address.getCounty());
		cityBo.setZip(address.getPostcode());
		cityBo.setState(address.getState());
		return cityBo;
	}

}
