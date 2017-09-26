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
 * SysUserB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "SYS_USER_B", schema = "JJJL")
public class SysUserB implements java.io.Serializable {

	// Fields

	private String userid;
	private SysUserMap sysUserMap;
	private String username;
	private String password;
	private String telphone;
	private String policy;
	private Timestamp ts;
	private String nt;

	// Constructors

	/** default constructor */
	public SysUserB() {
	}

	/** minimal constructor */
	public SysUserB(SysUserMap sysUserMap, String username, String password,
			String telphone,Timestamp ts) {
		this.sysUserMap = sysUserMap;
		this.username = username;
		this.password = password;
		this.telphone = telphone;
		//this.policy = policy;
		this.ts = ts;
	}

	/** full constructor */
	public SysUserB(SysUserMap sysUserMap, String username, String password,
			String telphone,  Timestamp ts, String nt) {
		this.sysUserMap = sysUserMap;
		this.username = username;
		this.password = password;
		this.telphone = telphone;
		//this.policy = policy;
		this.ts = ts;
		this.nt = nt;
	}

	// Property accessors
	@Id
	//@GeneratedValue
	@Column(name = "USERID", unique = true, nullable = false, length = 20)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MAPID", nullable = false)
	public SysUserMap getSysUserMap() {
		return this.sysUserMap;
	}

	public void setSysUserMap(SysUserMap sysUserMap) {
		this.sysUserMap = sysUserMap;
	}

	@Column(name = "USERNAME", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "TELPHONE", nullable = false, length = 15)
	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "POLICY", nullable = false, length = 1)
	public String getPolicy() {
		return this.policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	@Column(name = "TS",  length = 11)
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