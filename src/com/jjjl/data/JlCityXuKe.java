package com.jjjl.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * JlCityXuKe entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JL_CITY_XUKE", schema = "JJJL")
public class JlCityXuKe implements java.io.Serializable {

	// Fields

	private BigDecimal sysid;
	private JlCityB jlCityB;
	private String year;
	private Double xukeW;

	// Constructors

	/** default constructor */
	public JlCityXuKe() {
	}

	/** full constructor */
	public JlCityXuKe(JlCityB jlCityB, String year, Double xukeW) {
		this.jlCityB = jlCityB;
		this.year = year;
		this.xukeW = xukeW;
	}

	// Property accessors
	@SequenceGenerator(name = "generator")
	@Id
	//@GeneratedValue(strategy = SEQUENCE, generator = "generator")
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

	@Column(name = "XUKE_W", nullable = false, precision = 10,scale = 4)
	public Double getXukeW() {
		return this.xukeW;
	}

	public void setXukeW(Double xukeW) {
		this.xukeW = xukeW;
	}

}