package com.jjjl.data;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JlExchAutoWellB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JLEXCH_AUTOWELL_B", schema = "JJJL")
public class JlExchAutoWellB implements java.io.Serializable {

	// Fields

	private String wellCd;
	private JlExchWellB jlExchWellB;
	private String sim;
	private String wellAddress;
	private String estYm;
	private String runCoun;
	private String engMan;
	private Timestamp ts;
	private String nt;

	// Constructors

	/** default constructor */
	public JlExchAutoWellB() {
	}

	/** minimal constructor */
	public JlExchAutoWellB(JlExchWellB jlExchWellB, String sim) {
		this.jlExchWellB = jlExchWellB;
		this.sim = sim;
	}

	/** full constructor */
	public JlExchAutoWellB(JlExchWellB jlExchWellB, String sim,
			String wellAddress, String estYm, String runCoun, String engMan,
			Timestamp ts, String nt) {
		this.jlExchWellB = jlExchWellB;
		this.sim = sim;
		this.wellAddress = wellAddress;
		this.estYm = estYm;
		this.runCoun = runCoun;
		this.engMan = engMan;
		this.ts = ts;
		this.nt = nt;
	}

	// Property accessors
	@Id
	//@GeneratedValue
	@Column(name = "WELL_CD", unique = true, nullable = false, length = 12)
	public String getWellCd() {
		return this.wellCd;
	}

	public void setWellCd(String wellCd) {
		this.wellCd = wellCd;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "WELL_CD", unique = true, nullable = false, insertable = false, updatable = false)
	public JlExchWellB getJlExchWellB() {
		return this.jlExchWellB;
	}

	public void setJlExchWellB(JlExchWellB jlExchWellB) {
		this.jlExchWellB = jlExchWellB;
	}

	@Column(name = "SIM", nullable = false, length = 11)
	public String getSim() {
		return this.sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	@Column(name = "WELL_ADDRESS", length = 10)
	public String getWellAddress() {
		return this.wellAddress;
	}

	public void setWellAddress(String wellAddress) {
		this.wellAddress = wellAddress;
	}

	@Column(name = "EST_YM", length = 6)
	public String getEstYm() {
		return this.estYm;
	}

	public void setEstYm(String estYm) {
		this.estYm = estYm;
	}

	@Column(name = "RUN_COUN", length = 1)
	public String getRunCoun() {
		return this.runCoun;
	}

	public void setRunCoun(String runCoun) {
		this.runCoun = runCoun;
	}

	@Column(name = "ENG_MAN", length = 10)
	public String getEngMan() {
		return this.engMan;
	}

	public void setEngMan(String engMan) {
		this.engMan = engMan;
	}

	@Column(name = "TS", length = 11)
	public Timestamp getTs() {
		return this.ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	@Column(name = "NT", length = 100)
	public String getNt() {
		return this.nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

}