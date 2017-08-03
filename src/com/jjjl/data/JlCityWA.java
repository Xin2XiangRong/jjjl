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
@Table(name = "JL_CITY_W_A", schema = "JJJL")
public class JlCityWA implements java.io.Serializable {

	// Fields

	private BigDecimal sysid;
	private JlCityB jlCityB;
	private String year;
	private Double TW;
	private Double FW;
	private Double IW;
	private Double LW;
	private String nt;

	// Constructors

	/** default constructor */
	public JlCityWA() {
	}

	/** minimal constructor */
	public JlCityWA(JlCityB jlCityB, String year) {
		this.jlCityB = jlCityB;
		this.year = year;
	}

	/** full constructor */
	public JlCityWA(JlCityB jlCityB, String year, Double TW,
		Double FW, Double IW, Double LW, String nt) {
		this.jlCityB = jlCityB;
		this.year = year;
		this.TW = TW;
		this.FW = FW;
		this.IW = IW;
		this.LW = LW;
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

	@Column(name = "TOTAL_W", precision = 12, scale = 4)
	public Double getTW() {
		return this.TW;
	}

	public void setTW(Double TW) {
		this.TW = TW;
	}

	@Column(name = "F_W", precision = 12, scale = 4)
	public Double getFW() {
		return this.FW;
	}

	public void setFW(Double FW) {
		this.FW = FW;
	}

	@Column(name = "I_W", precision = 12, scale = 4)
	public Double getIW() {
		return this.IW;
	}

	public void setIW(Double IW) {
		this.IW = IW;
	}

	@Column(name = "L_W", precision = 12, scale = 4)
	public Double getLW() {
		return this.LW;
	}

	public void setLW(Double LW) {
		this.LW = LW;
	}

	@Column(name = "NT", length = 100)
	public String getNt() {
		return this.nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

}