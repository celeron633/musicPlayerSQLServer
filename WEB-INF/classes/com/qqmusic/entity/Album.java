package com.qqmusic.entity;

import java.sql.Date;

public class Album {
	public Album(int id, String name, String style, String language, Date date, String company) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
		this.language = language;
		this.date = date;
		this.company = company;
	}
	private int id;
	private String name;
	private String style;
	private String language;
	private Date date; 
	private String company;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", style=" + style + ", language=" + language + ", date=" + date
				+ ", company=" + company + "]";
	}
}
