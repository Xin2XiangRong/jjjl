package com.jjjl.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WellBMonthWV entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "WELLB_MONTHW_V", schema = "JJJL")
public class WellBMonthWV implements java.io.Serializable {

	// Fields

	private String wellCd;
	private String yearmonth;
	private BigDecimal monthW;

	// Constructors

		/** default constructor */
		public WellBMonthWV() {
		}

		/** full constructor */
		public WellBMonthWV(String yearmonth, BigDecimal monthW) {
			this.yearmonth = yearmonth;
			this.monthW = monthW;
		}
		
		public WellBMonthWV(String wellCd,String yearmonth, BigDecimal monthW) {
			this.yearmonth = yearmonth;
			this.monthW = monthW;
			this.wellCd=wellCd;
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

	@Column(name = "YEARMONTH", length = 7)
	public String getYearmonth() {
		return this.yearmonth;
	}

	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}


	@Column(name = "MONTH_W", precision = 22, scale = 0)
	public BigDecimal getMonthW() {
		return monthW;
	}

	public void setMonthW(BigDecimal monthW) {
		this.monthW = monthW;
	}

}