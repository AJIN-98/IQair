package com.ust.IQair.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CityDetails")
public class City {

	@Id
	private String cityId;
	private String cityName;
	private String pollutionRate;
	private String countryName;

	public City() {
		super();
	}

	public City(String cityId, String cityName, String pollutionRate, String countryName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.pollutionRate = pollutionRate;
		this.countryName = countryName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setSongName(String cityName) {
		this.cityName = cityName;
	}

	public String getpollutionRate() {
		return pollutionRate;
	}

	public void setpollutionRate(String pollutionRate) {
		this.pollutionRate = pollutionRate;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "IQairApp [CityId=" + cityId + ", CityName=" + cityName + ", pollutionRate=" + pollutionRate + ", CountryName="
				+ countryName + "]";
	}

}
