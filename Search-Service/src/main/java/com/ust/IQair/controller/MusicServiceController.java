package com.ust.IQair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ust.IQair.exception.ArtistNotFoundException;
import com.ust.IQair.exception.SongAlreadyPresentException;
import com.ust.IQair.exception.SongNotFoundException;
import com.ust.IQair.model.City;
import com.ust.IQair.model.CityList;
import com.ust.IQair.service.MusicService;
import io.swagger.annotations.Api;


@RestController
@Api
public class MusicServiceController {

	@Autowired
	MusicService service;

	@PostMapping("/city")
	public ResponseEntity<?> addNewCity(@RequestBody City city) {
		try {
			service.addNewCity(city);
			return new ResponseEntity<String>("Created", HttpStatus.CREATED);
		} catch (SongAlreadyPresentException e) {
			return new ResponseEntity<String>("Already Exist", HttpStatus.CONFLICT);
		}catch(Exception e) {
			return new ResponseEntity<String>("Already Exist", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/city/find/{cityName}")
	public ResponseEntity<?> getcityById(@PathVariable String cityName) {
		try {
			return new ResponseEntity<City>(service.getCityByName(cityName), HttpStatus.FOUND);
		} catch (SongNotFoundException e) {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/city/country/{countryName}")
	public ResponseEntity<?> getCityByCountry(@PathVariable String countryName) {
		CityList citys = new CityList();
		try {
			citys.setSongs(service.getAllCityByCountry(countryName));
			return new ResponseEntity<CityList>(citys, HttpStatus.CREATED);
		} catch (ArtistNotFoundException e) {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/city")
	public ResponseEntity<List<City>> getAllCity() {
		List<City> citys = service.getAllCity();
		return new ResponseEntity<List<City>>(citys, HttpStatus.OK);
	}

}
