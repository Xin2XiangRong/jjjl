package com.jjjl.data;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WellBYearWV entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "WELLB_YEARW_V", schema = "JJJL")
public class WellBYearWV implements java.io.Serializable {

	// Fields

	private String wellCd;
	private String year;
	private BigDecimal yearW;

	// Constructors

	/** default constructor */
	public WellBYearWV() {
	}

	/** full constructor */
	public WellBYearWV(String year, BigDecimal yearW) {
		this.year = year;
		this.yearW = yearW;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "WELL_CD", nullable = false, length = 12)
	public String getWellCd() {
		return this.wellCd;
	}

	public void setWellCd(String wellCd) {
		this.wellCd = wellCd;
	}

	@Column(name = "YEAR", length = 4)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "YEAR_W", precision = 22, scale = 0)
	public BigDecimal getYearW() {
		return this.yearW;
	}

	public void setYearW(BigDecimal yearW) {
		this.yearW = yearW;
	}

}