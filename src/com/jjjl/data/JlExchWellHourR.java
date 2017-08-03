package com.jjjl.data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JlExchWellHourR entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JLEXCH_WELL_HOUR_R", schema = "JJJL")
public class JlExchWellHourR implements java.io.Serializable {

	// Fields

	private BigDecimal sysid;
	private JlExchWellB jlExchWellB;
	private Timestamp tm;
	private Double hourW;
	private Timestamp ts;

	// Constructors

	/** default constructor */
	public JlExchWellHourR() {
	}

	/** minimal constructor */
	public JlExchWellHourR(JlExchWellB jlExchWellB) {
		this.jlExchWellB = jlExchWellB;
	}

	/** full constructor */
	public JlExchWellHourR(JlExchWellB jlExchWellB, Timestamp tm, Double hourW,
			Timestamp ts) {
		this.jlExchWellB = jlExchWellB;
		this.tm = tm;
		this.hourW = hourW;
		this.ts = ts;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WELL_CD", nullable = false)
	public JlExchWellB getJlExchWellB() {
		return this.jlExchWellB;
	}

	public void setJlExchWellB(JlExchWellB jlExchWellB) {
		this.jlExchWellB = jlExchWellB;
	}

	@Column(name = "TM", length = 7)
	public Timestamp getTm() {
		return this.tm;
	}

	public void setTm(Timestamp tm) {
		this.tm = tm;
	}

	@Column(name = "HOUR_W", precision = 10)
	public Double getHourW() {
		return this.hourW;
	}

	public void setHourW(Double hourW) {
		this.hourW = hourW;
	}

	@Column(name = "TS", length = 11)
	public Timestamp getTs() {
		return this.ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

}