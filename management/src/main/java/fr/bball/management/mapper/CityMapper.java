package fr.bball.management.mapper;

import fr.bball.management.bo.CityBO;
import fr.bball.management.bo.CountryBO;
import fr.bball.management.dto.City;

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
	
	public static CityBO dtoToBo(City  city,CountryBO countryBo,double longitude,double latitude) {
		CityBO cityBo = new CityBO();
		cityBo.setId(city.getId());
		cityBo.setName(city.getName());
		cityBo.setCountry(countryBo);
		cityBo.setLongitude(longitude);
		cityBo.setLatitude(latitude);
		return cityBo;
	}

}
