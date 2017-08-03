package com.jjjl.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JlCityWB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JL_CITY_W_B", schema = "JJJL")
public class JlCityWB implements java.io.Serializable {

	// Fields

	private BigDecimal sysid;
	private JlCityB jlCityB;
	private String year;
	private Double PW;
	private String nt;

	// Constructors

	/** default constructor */
	public JlCityWB() {
	}

	/** minimal constructor */
	public JlCityWB(JlCityB jlCityB, String year) {
		this.jlCityB = jlCityB;
		this.year = year;
	}

	/** full constructor */
	public JlCityWB(JlCityB jlCityB, String year, Double PW, String nt) {
		this.jlCityB = jlCityB;
		this.year = year;
		this.PW = PW;
		this.nt = nt;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "SYSID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getSysid() {
		return this.sysid;
	}

	public void setSysid(BigDecimal sysid) {
		this.sysid = sysid;
	}

	@ManyToOne(fetch = FetchType.EAGER,targetEntity=JlCityB.class)
	@JoinColumn(name = "CITY_CD", nullable = false)
	public JlCityB getJlCityB() {
		return this.jlCityB;
	}

	public void setJlCityB(JlCityB jlCityB) {
		this.jlCityB = jlCityB;
	}

	@Column(name = "YEAR", nullable = false, length = 4)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "P_W", precision = 12, scale = 4)
	public Double getPW() {
		return this.PW;
	}

	public void setPW(Double PW) {
		this.PW = PW;
	}

	@Column(name = "NT", length = 100)
	public String getNt() {
		return this.nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

}