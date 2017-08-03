package com.jjjl.util;

import java.util.List;

import com.jjjl.data.JlCityXuKe;
import com.jjjl.data.JlCountyXuKe;
@SuppressWarnings("all")
public class HtmlConvertUtil {

	public static String ListConvertHtml(List<JlCityXuKe> list)throws Exception{
		String table="<div class='tb_blue2'>";
		table=table+"<table id='pageTable' width='100%' border='0' cellspacing='0' cellpadding='0' class='border0'>";
		table+="<thead><tr><th>序号</th><th>行政区编码</th><th>名称</th><th>年许可取水量(m<sup>3</sup>)</th><th>月度汇总(m<sup>3</sup>)</th><th>年度汇总(m<sup>3</sup>)</th></tr></thead>";
		
		double total=0;
		for(int i=0;i<list.size();i++){
			total+=list.get(i).getXukeW();
			table+="<tr>";
			table+="<td>"+(i+1)+"</td>";
			table+="<td>"+list.get(i).getJlCityB().getCityCd()+"</td>";
			table+="<td>"+list.get(i).getJlCityB().getCityNm()+"</td>";
			table+="<td>"+list.get(i).getXukeW()+"</td>";
			table+="<td><div class='but_blue' onclick='queryMonth("+list.get(i).getJlCityB().getCityCd()+")'>M</div></td>";
			table+="<td><div class='but_blue' onclick='queryYear("+list.get(i).getJlCityB().getCityCd()+")'>Y</div></td>";
			table+="</tr>";
		}
		
		table+="<tr><td>"+(list.size()+1)+"</td><td></td><td>全省统计</td><td>"+total+"</td>";
		table+="<td><div class='but_blue' onclick='queryMonth(14)'>M</div></td>";
		table+="<td><div class='but_blue' onclick='queryYear(14)'>Y</div></td>";
		table+="</tr>";
		table+="</table>";
		table=table+"</div>";
		return table;		
	};
	
	public static String ListConvertCityHtml(List<JlCountyXuKe> list)throws Exception{
		String table="<div class='tb_blue2'>";
		table=table+"<table id='pageTable' width='100%' border='0' cellspacing='0' cellpadding='0' class='border0'>";
		table+="<thead><tr><th>序号</th><th>行政区编码</th><th>名称</th><th>年许可取水量(m<sup>3</sup>)</th><th>月度汇总(m<sup>3</sup>)</th><th>年度汇总(m<sup>3</sup>)</th></tr></thead>";
		
		double total=0;
		for(int i=0;i<list.size();i++){
			total+=list.get(i).getXukeW();
			table+="<tr>";
			table+="<td>"+(i+1)+"</td>";
			table+="<td>"+list.get(i).getJlCountyB().getCountyCd()+"</td>";
			table+="<td>"+list.get(i).getJlCountyB().getCountyNm()+"</td>";
			table+="<td>"+list.get(i).getXukeW()+"</td>";
			table+="<td><div class='but_blue' onclick='queryMonth("+list.get(i).getJlCountyB().getCountyCd()+")'>M</div></td>";
			table+="<td><div class='but_blue' onclick='queryYear("+list.get(i).getJlCountyB().getCountyCd()+")'>Y</div></td>";
			table+="</tr>";
		}		
		table+="<tr><td>"+(list.size()+1)+"</td><td></td><td>全市统计</td><td>"+total+"</td>";
		table+="<td><div class='but_blue' onclick='queryMonth("+list.get(0).getJlCountyB().getJlCityB().getCityCd()+")'>M</div></td>";
		table+="<td><div class='but_blue' onclick='queryYear("+list.get(0).getJlCountyB().getJlCityB().getCityCd()+")'>Y</div></td>";
		table+="</tr>";
		table+="</table>";
		table=table+"</div>";
		return table;
	}
}
