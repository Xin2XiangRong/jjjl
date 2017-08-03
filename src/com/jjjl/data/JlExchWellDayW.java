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
 * JlExchWellDayW entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JLEXCH_WELL_DAY_W", schema = "JJJL")
public class JlExchWellDayW implements java.io.Serializable {

	// Fields

	private BigDecimal sysid;
	private JlExchWellB jlExchWellB;
	private Timestamp dt;
	private Double dayW;
	private Timestamp ts;

	// Constructors

	/** default constructor */
	public JlExchWellDayW() {
	}

	/** full constructor */
	public JlExchWellDayW(JlExchWellB jlExchWellB, Timestamp dt, Double dayW,
			Timestamp ts) {
		this.jlExchWellB = jlExchWellB;
		this.dt = dt;
		this.dayW = dayW;
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

	@Column(name = "DT", nullable = false, length = 7)
	public Timestamp getDt() {
		return this.dt;
	}

	public void setDt(Timestamp dt) {
		this.dt = dt;
	}

	@Column(name = "DAY_W", nullable = false, precision = 12)
	public Double getDayW() {
		return this.dayW;
	}

	public void setDayW(Double dayW) {
		this.dayW = dayW;
	}

	@Column(name = "TS", nullable = false, length = 11)
	public Timestamp getTs() {
		return this.ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

}