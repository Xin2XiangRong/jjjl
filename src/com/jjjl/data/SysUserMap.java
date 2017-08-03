package com.jjjl.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysUserMap entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "SYS_USER_MAP", schema = "JJJL")
public class SysUserMap implements java.io.Serializable {

	// Fields

	private String mapid;
	private Double west;
	private Double north;
	private Double earth;
	private Double south;
	

	// Constructors

	/** default constructor */
	public SysUserMap() {
	}

	

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "MAPID", unique = true, nullable = false, length = 4)
	public String getMapid() {
		return this.mapid;
	}

	public void setMapid(String mapid) {
		this.mapid = mapid;
	}

	@Column(name = "WEST", precision = 38, scale = 16)
	public Double getWest() {
		return this.west;
	}

	public void setWest(Double west) {
		this.west = west;
	}

	@Column(name = "NORTH", precision = 38, scale = 16)
	public Double getNorth() {
		return this.north;
	}

	public void setNorth(Double north) {
		this.north = north;
	}

	@Column(name = "EARTH", precision = 38, scale = 16)
	public Double getEarth() {
		return this.earth;
	}

	public void setEarth(Double earth) {
		this.earth = earth;
	}

	@Column(name = "SOUTH", precision = 38, scale = 16)
	public Double getSouth() {
		return this.south;
	}

	public void setSouth(Double south) {
		this.south = south;
	}
}