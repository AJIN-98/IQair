package com.ust.IQair.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.IQair.exception.ArtistNotFoundException;
import com.ust.IQair.exception.SongNotFoundException;
import com.ust.IQair.model.City;

@Repository
public interface MusicServiceRepository extends MongoRepository<City, String>{
	
	public City findByCityName(String cityName) throws SongNotFoundException;

	public List<City> findByCountryName(String countryName) throws ArtistNotFoundException;

}
