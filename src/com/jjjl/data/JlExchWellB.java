package com.jjjl.data;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JlExchWellB entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
@Entity
@Table(name = "JLEXCH_WELL_B", schema = "JJJL")
public class JlExchWellB implements java.io.Serializable {

	// Fields
	private static DecimalFormat df2 = new DecimalFormat("0.00");
	private static DecimalFormat df3 = new DecimalFormat("0.000");
	private static DecimalFormat df4 = new DecimalFormat("0.0000");
	private String wellCd;
	private JlTownB jlTownB;
	private JlVillageB jlVillageB;
	private String wellNm;
	private String loc;
	private Short edegrees;
	private Byte eminutes;
	private Double eseconds;
	private Short ndegrees;
	private Byte nminutes;
	private Double nseconds;
	private String p801052;
	private String p801003;
	private Double p801004;
	private Double p801005;
	private String p801006;
	private Integer p801020;
	private String p801007;
	private String p801008;
	private String p801009;
	private Double p801010;
	private Double p801011;
	private Double p801012;
	private String p801013;
	private String p801014;
	private String p801015;
	private String p801017;
	private String p801018;
	private String p801019;
	private String p801021;
	private String p801027;
	private String p801022;
	private Integer p801023;
	private String p801024;
	private Integer p801025;
	private Integer p801026;
	private String p801028;
	private Short p801016;
	private String p801034;
	private String p801035;
	private Integer p801036;
	private Integer p801037;
	private Short p801038;
	private Double p801039;
	private Double p801040;
	private Double p801041;
	private Double p801042;
	private Double p801043;
	private Double p801044;
	private Double p801045;
	private String p801029;
	private String p801030;
	private Double p801031;
	private String p801054;
	private String p801056;
	private Double p801057;
	private Double p801058;
	private String p801032;
	private String p801033;
	private Timestamp ts;
	private String nt;	

	

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

	@ManyToOne(fetch = FetchType.EAGER,targetEntity=JlTownB.class)
	@JoinColumn(name = "XIANG_CD", nullable = false)
	public JlTownB getJlTownB() {
		return this.jlTownB;
	}

	public void setJlTownB(JlTownB jlTownB) {
		this.jlTownB = jlTownB;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGEID", nullable = false)
	public JlVillageB getJlVillageB() {
		return this.jlVillageB;
	}

	public void setJlVillageB(JlVillageB jlVillageB) {
		this.jlVillageB = jlVillageB;
	}

	@Column(name = "WELL_NM", nullable = false, length = 100)
	public String getWellNm() {
		return this.wellNm;
	}

	public void setWellNm(String wellNm) {
		this.wellNm = wellNm;
	}

	@Column(name = "LOC", length = 200)
	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Column(name = "EDEGREES", precision = 3, scale = 0)
	public Short getEdegrees() {
		return this.edegrees;
	}

	public void setEdegrees(Short edegrees) {
		this.edegrees = edegrees;
	}

	@Column(name = "EMINUTES", precision = 2, scale = 0)
	public Byte getEminutes() {
		return this.eminutes;
	}

	public void setEminutes(Byte eminutes) {
		this.eminutes = eminutes;
	}

	@Column(name = "ESECONDS", precision = 3, scale = 1)
	public Double getEseconds() {
		return this.eseconds;
	}

	public void setEseconds(Double eseconds) {
		this.eseconds = eseconds;
	}

	@Column(name = "NDEGREES", precision = 3, scale = 0)
	public Short getNdegrees() {
		return this.ndegrees;
	}

	public void setNdegrees(Short ndegrees) {
		this.ndegrees = ndegrees;
	}

	@Column(name = "NMINUTES", precision = 2, scale = 0)
	public Byte getNminutes() {
		return this.nminutes;
	}

	public void setNminutes(Byte nminutes) {
		this.nminutes = nminutes;
	}

	@Column(name = "NSECONDS", precision = 3, scale = 1)
	public Double getNseconds() {
		return this.nseconds;
	}

	public void setNseconds(Double nseconds) {
		this.nseconds = nseconds;
	}

	@Column(name = "P801_052", length = 1)
	public String getP801052() {
		return this.p801052;
	}

	public void setP801052(String p801052) {
		this.p801052 = p801052;
	}

	@Column(name = "P801_003", length = 4)
	public String getP801003() {
		return this.p801003;
	}

	public void setP801003(String p801003) {
		this.p801003 = p801003;
	}

	@Column(name = "P801_004", precision = 6)
	public Double getP801004() {
		return this.p801004;
	}

	public void setP801004(Double p801004) {
		this.p801004 = p801004;
	}

	@Column(name = "P801_005", precision = 6)
	public Double getP801005() {
		return this.p801005;
	}

	public void setP801005(Double p801005) {
		this.p801005 = p801005;
	}

	@Column(name = "P801_006", length = 1)
	public String getP801006() {
		return this.p801006;
	}

	public void setP801006(String p801006) {
		this.p801006 = p801006;
	}

	@Column(name = "P801_020", precision = 8, scale = 0)
	public Integer getP801020() {
		return this.p801020;
	}

	public void setP801020(Integer p801020) {
		this.p801020 = p801020;
	}

	@Column(name = "P801_007", length = 1)
	public String getP801007() {
		return this.p801007;
	}

	public void setP801007(String p801007) {
		this.p801007 = p801007;
	}

	@Column(name = "P801_008", length = 1)
	public String getP801008() {
		return this.p801008;
	}

	public void setP801008(String p801008) {
		this.p801008 = p801008;
	}

	@Column(name = "P801_009", length = 50)
	public String getP801009() {
		return this.p801009;
	}

	public void setP801009(String p801009) {
		this.p801009 = p801009;
	}

	@Column(name = "P801_010", precision = 6)
	public Double getP801010() {
		return this.p801010;
	}

	public void setP801010(Double p801010) {
		this.p801010 = p801010;
	}

	@Column(name = "P801_011", precision = 8, scale = 3)
	public Double getP801011() {
		return this.p801011;
	}

	public void setP801011(Double p801011) {
		this.p801011 = p801011;
	}

	@Column(name = "P801_012", precision = 8, scale = 3)
	public Double getP801012() {
		return this.p801012;
	}

	public void setP801012(Double p801012) {
		this.p801012 = p801012;
	}

	@Column(name = "P801_013", length = 1)
	public String getP801013() {
		return this.p801013;
	}

	public void setP801013(String p801013) {
		this.p801013 = p801013;
	}

	@Column(name = "P801_014", length = 10)
	public String getP801014() {
		return this.p801014;
	}

	public void setP801014(String p801014) {
		this.p801014 = p801014;
	}

	@Column(name = "P801_015", length = 1)
	public String getP801015() {
		return this.p801015;
	}

	public void setP801015(String p801015) {
		this.p801015 = p801015;
	}

	@Column(name = "P801_017", length = 100)
	public String getP801017() {
		return this.p801017;
	}

	public void setP801017(String p801017) {
		this.p801017 = p801017;
	}

	@Column(name = "P801_018", length = 1)
	public String getP801018() {
		return this.p801018;
	}

	public void setP801018(String p801018) {
		this.p801018 = p801018;
	}

	@Column(name = "P801_019", length = 1)
	public String getP801019() {
		return this.p801019;
	}

	public void setP801019(String p801019) {
		this.p801019 = p801019;
	}

	@Column(name = "P801_021", length = 100)
	public String getP801021() {
		return this.p801021;
	}

	public void setP801021(String p801021) {
		this.p801021 = p801021;
	}

	@Column(name = "P801_027", length = 1)
	public String getP801027() {
		return this.p801027;
	}

	public void setP801027(String p801027) {
		this.p801027 = p801027;
	}

	@Column(name = "P801_022", length = 1)
	public String getP801022() {
		return this.p801022;
	}

	public void setP801022(String p801022) {
		this.p801022 = p801022;
	}

	@Column(name = "P801_023", precision = 6, scale = 0)
	public Integer getP801023() {
		return this.p801023;
	}

	public void setP801023(Integer p801023) {
		this.p801023 = p801023;
	}

	@Column(name = "P801_024", length = 1)
	public String getP801024() {
		return this.p801024;
	}

	public void setP801024(String p801024) {
		this.p801024 = p801024;
	}

	@Column(name = "P801_025", precision = 6, scale = 0)
	public Integer getP801025() {
		return this.p801025;
	}

	public void setP801025(Integer p801025) {
		this.p801025 = p801025;
	}

	@Column(name = "P801_026", precision = 6, scale = 0)
	public Integer getP801026() {
		return this.p801026;
	}

	public void setP801026(Integer p801026) {
		this.p801026 = p801026;
	}

	@Column(name = "P801_028", length = 1)
	public String getP801028() {
		return this.p801028;
	}

	public void setP801028(String p801028) {
		this.p801028 = p801028;
	}

	@Column(name = "P801_016", precision = 3, scale = 0)
	public Short getP801016() {
		return this.p801016;
	}

	public void setP801016(Short p801016) {
		this.p801016 = p801016;
	}

	@Column(name = "P801_034", length = 1)
	public String getP801034() {
		return this.p801034;
	}

	public void setP801034(String p801034) {
		this.p801034 = p801034;
	}

	@Column(name = "P801_035", length = 1)
	public String getP801035() {
		return this.p801035;
	}

	public void setP801035(String p801035) {
		this.p801035 = p801035;
	}

	@Column(name = "P801_036", precision = 8, scale = 0)
	public Integer getP801036() {
		return this.p801036;
	}

	public void setP801036(Integer p801036) {
		this.p801036 = p801036;
	}

	@Column(name = "P801_037", precision = 8, scale = 0)
	public Integer getP801037() {
		return this.p801037;
	}

	public void setP801037(Integer p801037) {
		this.p801037 = p801037;
	}

	@Column(name = "P801_038", precision = 4, scale = 0)
	public Short getP801038() {
		return this.p801038;
	}

	public void setP801038(Short p801038) {
		this.p801038 = p801038;
	}

	@Column(name = "P801_039", precision = 6)
	public Double getP801039() {
		return this.p801039;
	}

	public void setP801039(Double p801039) {
		this.p801039 = p801039;
	}

	@Column(name = "P801_040", precision = 6)
	public Double getP801040() {
		return this.p801040;
	}

	public void setP801040(Double p801040) {
		this.p801040 = p801040;
	}

	@Column(name = "P801_041", precision = 6)
	public Double getP801041() {
		return this.p801041;
	}

	public void setP801041(Double p801041) {
		this.p801041 = p801041;
	}

	@Column(name = "P801_042", precision = 10, scale = 5)
	public Double getP801042() {
		return this.p801042;
	}

	public void setP801042(Double p801042) {
		this.p801042 = p801042;
	}

	@Column(name = "P801_043", precision = 10, scale = 5)
	public Double getP801043() {
		return this.p801043;
	}

	public void setP801043(Double p801043) {
		this.p801043 = p801043;
	}

	@Column(name = "P801_044", precision = 10, scale = 5)
	public Double getP801044() {
		return this.p801044;
	}

	public void setP801044(Double p801044) {
		this.p801044 = p801044;
	}

	@Column(name = "P801_045", precision = 10, scale = 5)
	public Double getP801045() {
		return this.p801045;
	}

	public void setP801045(Double p801045) {
		this.p801045 = p801045;
	}

	@Column(name = "P801_029", length = 1)
	public String getP801029() {
		return this.p801029;
	}

	public void setP801029(String p801029) {
		this.p801029 = p801029;
	}

	@Column(name = "P801_030", length = 50)
	public String getP801030() {
		return this.p801030;
	}

	public void setP801030(String p801030) {
		this.p801030 = p801030;
	}

	@Column(name = "P801_031", precision = 8)
	public Double getP801031() {
		return this.p801031;
	}

	public void setP801031(Double p801031) {
		this.p801031 = p801031;
	}

	@Column(name = "P801_054", length = 1)
	public String getP801054() {
		return this.p801054;
	}

	public void setP801054(String p801054) {
		this.p801054 = p801054;
	}

	@Column(name = "P801_056", length = 50)
	public String getP801056() {
		return this.p801056;
	}

	public void setP801056(String p801056) {
		this.p801056 = p801056;
	}

	@Column(name = "P801_057", precision = 6)
	public Double getP801057() {
		return this.p801057;
	}

	public void setP801057(Double p801057) {
		this.p801057 = p801057;
	}

	@Column(name = "P801_058", precision = 8, scale = 4)
	public Double getP801058() {
		return this.p801058;
	}

	public void setP801058(Double p801058) {
		this.p801058 = p801058;
	}

	@Column(name = "P801_032", length = 100)
	public String getP801032() {
		return this.p801032;
	}

	public void setP801032(String p801032) {
		this.p801032 = p801032;
	}

	@Column(name = "P801_033", length = 1)
	public String getP801033() {
		return this.p801033;
	}

	public void setP801033(String p801033) {
		this.p801033 = p801033;
	}

	@Column(name = "TS", length = 11)
	public Timestamp getTs() {
		return this.ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	@Column(name = "NT", length = 256)
	public String getNt() {
		return this.nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
    
	
	public String p801004Str(){
		return df2.format(p801004);
	}
	
	public String p801005Str(){
		return df2.format(p801005);
	}
	
	public String p801006Str(){
		if("0".equals(p801006))
			return "否";
		else if("1".equals(p801006))
			return "是";
		else
			return "";
	}
	
	public String p801052Str(){
		if("1".equals(p801052))
			return "钢管";
		else if("2".equals(p801052))
			return "混凝土管";
		else if("3".equals(p801052))
			return "钢筋混凝土管";
		else if("4".equals(p801052))
			return "铸铁管";
		else if("5".equals(p801052))
			return "塑料管";
		else if("9".equals(p801052))
			return "其他";
		else
			return "";
	}
	
	public String p801007Str(){
		if("1".equals(p801007))
			return "日常使用";
		else if("2".equals(p801007))
			return "应急备用";
		else
			return "";
	}
	
	public String p801008Str(){
		if("1".equals(p801008))
			return "是";
		else if("0".equals(p801008))
			return "否";
		else
			return "";
	}
	
	public String p801010Str(){
		return df2.format(p801010);
	}
	public String p801011Str(){
		return df3.format(p801011);
	}
	
	public String p801012Str(){
		return df3.format(p801012);
	}
	
	public String p801013Str(){
		if("0".equals(p801013))
			return "否";
		else if("1".equals(p801013))
			return "是";
		else
			return "";
	}
	
	public String p801014Str(){
		if("1".equals(p801014))
			return "水表";
		else if("2".equals(p801014))
			return "流速仪";
		else if("3".equals(p801014))
			return "堰槽";
		else if("9".equals(p801014))
			return "其他";
		else
			return "";
	}
	
	public String p801015Str(){
		if("0".equals(p801015))
			return "否";
		else if("1".equals(p801015))
			return "是";
		else
			return "";
	}
	
	public String p801018Str(){
		if("1".equals(p801018))
			return "山丘区";
		else if("2".equals(p801018))
			return "平原区";
		else
			return "";
	}
	
	public String p801019Str(){
		if("1".equals(p801019))
			return "浅层地下水";
		else if("2".equals(p801019))
			return "深层承压水";
		else
			return "";
	}
	
	public String p801027Str(){
		if("1".equals(p801027))
			return "地下水";
		else if("2".equals(p801027))
			return "矿泉水";
		else if("3".equals(p801027))
			return "地热水";
		else
			return "";
	}		
	
	public String p801022Str(){
		if("1".equals(p801022))
			return "城镇生活";
		else if("2".equals(p801022))
			return "乡村生活";
		else if("3".equals(p801022))
			return "工业";
		else if("4".equals(p801022))
			return "农业灌溉";
		else
			return "";
	}
	
	public String p801028Str(){
		if("1".equals(p801028))
			return "饮用（生活）";
		else if("2".equals(p801028))
			return "饮用（商业）";
		else if("3".equals(p801028))
			return "医疗";
		else if("9".equals(p801028))
			return "其他";
		else
			return "";
	}
	
	public String p801024Str(){
		if("1".equals(p801024))
			return "井灌区";
		else if("2".equals(p801024))
			return "井渠结合灌区";
		else
			return "";
	}
	
	public String p801034Str(){
		if("1".equals(p801034))
			return "供暖";
		else if("2".equals(p801034))
			return "发电";
		else if("3".equals(p801034))
			return "医疗";
		else if("9".equals(p801034))
			return "其他";
		else
			return "";
	}
	
	public String p801029Str(){
		if("1".equals(p801029))
			return "是";
		else if("0".equals(p801029))
			return "否";
		else
			return "";
	}
	
	public String p801031Str(){
		return df2.format(p801031);
	}
	
	public String p801054Str(){
		if("1".equals(p801054))
			return "是";
		else if("0".equals(p801054))
			return "否";
		else
			return "";
	}
	
	public String p801057Str(){
		return df2.format(p801057);
	}
	public String p801058Str(){
		return df4.format(p801058);
	}
	
	public String p801033Str(){
		if("1".equals(p801033))
			return "中央";
		else if("2".equals(p801033))
			return "省";
		else if("3".equals(p801033))
			return "地";
		else if("4".equals(p801033))
			return "县";
		else if("5".equals(p801033))
			return "乡";
		else if("9".equals(p801033))
			return "其他";
		else
			return "";
	}
}