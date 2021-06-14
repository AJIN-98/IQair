package com.ust.IQair.model;

import java.util.List;

public class CityList {

	private List<City> citys;

	public CityList() {
		super();
	}

	public CityList(List<City> citys) {
		super();
		this.citys = citys;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setSongs(List<City> citys) {
		this.citys = citys;
	}

}
