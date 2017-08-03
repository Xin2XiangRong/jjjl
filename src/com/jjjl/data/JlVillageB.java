package com.jjjl.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JlVillageB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JL_VILLAGE_B", schema = "JJJL")
public class JlVillageB implements java.io.Serializable {

	// Fields

	private String villageid;
	private JlTownB jlTownB;
	private String villagenm;
	private Set<JlExchWellB> jlExchWellBs = new HashSet<JlExchWellB>(0);

	// Constructors

	/** default constructor */
	public JlVillageB() {
	}

	/** minimal constructor */
	public JlVillageB(JlTownB jlTownB, String villagenm) {
		this.jlTownB = jlTownB;
		this.villagenm = villagenm;
	}

	

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "VILLAGEID", unique = true, nullable = false, length = 12)
	public String getVillageid() {
		return this.villageid;
	}

	public void setVillageid(String villageid) {
		this.villageid = villageid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "XIANG_CD", nullable = false)
	public JlTownB getJlTownB() {
		return this.jlTownB;
	}

	public void setJlTownB(JlTownB jlTownB) {
		this.jlTownB = jlTownB;
	}

	@Column(name = "VILLAGENM", nullable = false, length = 100)
	public String getVillagenm() {
		return this.villagenm;
	}

	public void setVillagenm(String villagenm) {
		this.villagenm = villagenm;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jlVillageB")
	public Set<JlExchWellB> getJlExchWellBs() {
		return this.jlExchWellBs;
	}

	public void setJlExchWellBs(Set<JlExchWellB> jlExchWellBs) {
		this.jlExchWellBs = jlExchWellBs;
	}

}