package com.jjjl.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JlCountyB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JL_COUNTY_B", schema = "JJJL")
public class JlCountyB implements java.io.Serializable {

	// Fields

	private String countyCd;
	private JlCityB jlCityB;
	private String countyNm;	

	
	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "COUNTY_CD", unique = true, nullable = false, length = 6)
	public String getCountyCd() {
		return this.countyCd;
	}

	public void setCountyCd(String countyCd) {
		this.countyCd = countyCd;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CITY_CD", nullable = false)
	public JlCityB getJlCityB() {
		return this.jlCityB;
	}

	public void setJlCityB(JlCityB jlCityB) {
		this.jlCityB = jlCityB;
	}

	@Column(name = "COUNTY_NM", length = 50)
	public String getCountyNm() {
		return this.countyNm;
	}

	public void setCountyNm(String countyNm) {
		this.countyNm = countyNm;
	}
}