package com.telusko.demorests;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Timetable 
{

	private String twon;
	private String areacode;
	private String date;
	private String catagary;
	private String time;
	
	public String getTwon() {
		return twon;
	}
	public void setTwon(String twon) {
		this.twon = twon;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCatagary() {
		return catagary;
	}
	public void setCatagary(String catagary) {
		this.catagary = catagary;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Timetable [twon=" + twon + ", areacode=" + areacode + ", date=" + date + ", catagary=" + catagary
				+ ", time=" + time + "]";
	}
}
