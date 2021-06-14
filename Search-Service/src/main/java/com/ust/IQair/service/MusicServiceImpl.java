package com.ust.IQair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.IQair.exception.ArtistNotFoundException;
import com.ust.IQair.exception.SongAlreadyPresentException;
import com.ust.IQair.exception.SongNotFoundException;
import com.ust.IQair.model.City;
import com.ust.IQair.repository.MusicServiceRepository;



@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	MusicServiceRepository poll;

	@Override
	public City addNewCity(City city) throws SongAlreadyPresentException {
		if (poll.findById(city.getCityId()).isPresent()) {
			throw new SongAlreadyPresentException("City with ID already exists");
		}
		return poll.insert(city);
	}

	@Override
	public City getCityByName(String cityName) throws SongNotFoundException {
		try {
			return (City) poll.findByCityName(cityName);
		} catch (SongNotFoundException e) {
			throw new SongNotFoundException("City Not Available");
		}
	}

	@Override
	public List<City> getAllCityByCountry(String countryName) throws ArtistNotFoundException {
		try {
			return poll.findByCountryName(countryName);
		} catch (ArtistNotFoundException e) {
			throw new ArtistNotFoundException("Country Not Available");
		}
	}

	@Override
	public List<City> getAllCity() {
		return poll.findAll();
	}



}
