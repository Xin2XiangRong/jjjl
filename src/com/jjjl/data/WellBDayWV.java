package com.jjjl.data;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WellBDayWV entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "WELLB_DAYW_V", schema = "JJJL")
public class WellBDayWV implements java.io.Serializable {

	// Fields

	private String wellCd;
	private String day;
	private BigDecimal dayW;

	// Constructors

	/** default constructor */
	public WellBDayWV() {
	}

	/** full constructor */
	public WellBDayWV(String day, BigDecimal dayW) {
		this.day = day;
		this.dayW = dayW;
	}

	// Property accessors
	@Id
	//@GeneratedValue
	@Column(name = "WELL_CD", nullable = false, length = 12)
	public String getWellCd() {
		return this.wellCd;
	}

	public void setWellCd(String wellCd) {
		this.wellCd = wellCd;
	}

	@Column(name = "DAY", length = 10)
	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Column(name = "DAY_W", precision = 22, scale = 0)
	public BigDecimal getDayW() {
		return this.dayW;
	}

	public void setDayW(BigDecimal dayW) {
		this.dayW = dayW;
	}

}