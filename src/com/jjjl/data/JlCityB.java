package com.jjjl.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JlCityB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JL_CITY_B", schema = "JJJL")
public class JlCityB implements java.io.Serializable {

	// Fields

	public String cityCd;
	private String cityNm;	
	
	
	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "CITY_CD", unique = true, nullable = false, length = 4)
	public String getCityCd() {
		return this.cityCd;
	}

	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}

	@Column(name = "CITY_NM", nullable = false, length = 50)
	public String getCityNm() {
		return this.cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

}