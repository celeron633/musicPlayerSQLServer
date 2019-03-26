package com.qqmusic.entity;

public class Listq {
	private int id;
	private String name;
	private int uid;
	private String style;
	private String info;
	private int times;
	private Boolean open;
	private String uname;
	
	public Listq(int id, String name, int uid, String style, String info, int times, Boolean open, String uname) {
		super();
		this.id = id;
		this.name = name;
		this.uid = uid;
		this.style = style;
		this.info = info;
		this.times = times;
		this.open = open;
		this.uname = uname;
	}
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "List [id=" + id + ", name=" + name + ", uid=" + uid + ", style=" + style + ", info=" + info + ", times="
				+ times + ", open=" + open + ", uname=" + uname + "]";
	}
}
