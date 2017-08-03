package com.jjjl.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JlTownB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JL_TOWN_B", schema = "JJJL")
public class JlTownB implements java.io.Serializable {

	// Fields

	private String xiangCd;
	private JlCountyB jlCountyB;
	private String xiangNm;	

	// Constructors

	/** default constructor */
	public JlTownB() {
	}

	/** minimal constructor */
	public JlTownB(JlCountyB jlCountyB, String xiangNm) {
		this.jlCountyB = jlCountyB;
		this.xiangNm = xiangNm;
	}

	

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "XIANG_CD", unique = true, nullable = false, length = 9)
	public String getXiangCd() {
		return this.xiangCd;
	}

	public void setXiangCd(String xiangCd) {
		this.xiangCd = xiangCd;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COUNTY_CD", nullable = false)
	public JlCountyB getJlCountyB() {
		return this.jlCountyB;
	}

	public void setJlCountyB(JlCountyB jlCountyB) {
		this.jlCountyB = jlCountyB;
	}

	@Column(name = "XIANG_NM", nullable = false, length = 100)
	public String getXiangNm() {
		return this.xiangNm;
	}

	public void setXiangNm(String xiangNm) {
		this.xiangNm = xiangNm;
	}

}