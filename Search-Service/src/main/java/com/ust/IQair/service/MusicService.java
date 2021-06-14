package com.ust.IQair.service;

import java.util.List;

import com.ust.IQair.exception.ArtistNotFoundException;
import com.ust.IQair.exception.SongAlreadyPresentException;
import com.ust.IQair.exception.SongNotFoundException;
import com.ust.IQair.model.City;

public interface MusicService {
	public City addNewCity(City city) throws SongAlreadyPresentException;
	
	public City getCityByName(String cityName) throws SongNotFoundException;

	public List<City> getAllCityByCountry(String countryName) throws ArtistNotFoundException;
	
	public List<City> getAllCity();


}
