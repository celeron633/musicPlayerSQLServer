package com.qqmusic.entity;

import java.sql.Date;

public class Singer {
	private int id;
	private String name;
	private String introduction;
	private Boolean sex;
	private Date birthday;
	private String hometown;
	private String nation;
	private String image;
	
	public Singer(int id,String name, String introduction) {
		super();
		this.id = id;
		this.name = name;
		this.introduction = introduction;
	}
	
	public Singer(int id,String name, String introduction,Boolean sex,Date birthday,String nation,String hometown,String image) {
		super();
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.sex = sex;
		this.birthday = birthday;
		this.nation = nation;
		this.hometown = hometown;
		this.image=image;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	


	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}



	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Singer [id=" + id + ", name=" + name + ", introduction=" + introduction + ", sex=" + sex + ", birthday="
				+ birthday + ", hometown=" + hometown + ", nation=" + nation + ", image=" + image + "]";
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
