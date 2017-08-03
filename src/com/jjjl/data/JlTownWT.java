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
@Table(name = "JL_TOWN_W_T", schema = "JJJL")
public class JlTownWT implements java.io.Serializable {

	// Fields

	private BigDecimal sysid;
	private JlTownB jlTownB1;
	private JlTownB jlTownB2;
	private Double TW;
	private String pic;
	private String nt;

	// Constructors

	/** default constructor */
	public JlTownWT() {
	}

	
	/** full constructor */
	public JlTownWT(JlTownB jlTownB1, JlTownB jlTownB2, Double TW, String nt) {
		this.jlTownB1 = jlTownB1;
		this.jlTownB2 = jlTownB2;
		this.TW = TW;
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

	@ManyToOne(fetch = FetchType.EAGER,targetEntity=JlTownB.class)
	@JoinColumn(name = "XIANG_CD1", nullable = false)
	public JlTownB getJlTownB1() {
		return this.jlTownB1;
	}

	public void setJlTownB1(JlTownB jlTownB1) {
		this.jlTownB1 = jlTownB1;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity=JlTownB.class)
	@JoinColumn(name = "XIANG_CD2", nullable = false)
	public JlTownB getJlTownB2() {
		return this.jlTownB2;
	}

	public void setJlTownB2(JlTownB jlTownB2) {
		this.jlTownB2 = jlTownB2;
	}

	@Column(name = "T_W", precision = 12, scale = 4)
	public Double getTW() {
		return this.TW;
	}

	public void setTW(Double TW) {
		this.TW = TW;
	}

	@Column(name = "PIC", length = 100)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Column(name = "NT", length = 100)
	public String getNt() {
		return this.nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

}