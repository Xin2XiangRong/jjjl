package com.jjjl.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * JlTownXuKe entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JL_TOWN_XUKE", schema = "JJJL")
public class JlTownXuKe implements java.io.Serializable {

	// Fields

	private String sysid;
	private JlTownB jlTownB;
	private String year;
	private Double xukeW;

	// Constructors

	/** default constructor */
	public JlTownXuKe() {
	}

	/** full constructor */
	public JlTownXuKe(JlTownB jlTownB, String year, Double xukeW) {
		this.jlTownB = jlTownB;
		this.year = year;
		this.xukeW = xukeW;
	}

	// Property accessors
	@SequenceGenerator(name = "generator")
	@Id
	//@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "SYSID", unique = true, nullable = false, length = 22)
	public String getSysid() {
		return this.sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "XIANG_CD", nullable = false)
	public JlTownB getJlTownB() {
		return this.jlTownB;
	}

	public void setJlTownB(JlTownB jlTownB) {
		this.jlTownB = jlTownB;
	}

	@Column(name = "YEAR", nullable = false, length = 4)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "XUKE_W", nullable = false, precision = 10)
	public Double getXukeW() {
		return this.xukeW;
	}

	public void setXukeW(Double xukeW) {
		this.xukeW = xukeW;
	}

}