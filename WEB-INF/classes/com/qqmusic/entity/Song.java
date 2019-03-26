package com.qqmusic.entity;

public class Song {
	private int id;
	private String name;
	private int singer;
	private String file;
	private String language;
	private String style;
	private String lyric;
	private int times;
	private String singername;
	
	public Song(int id,String name, int singer, String file) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.file = file;
	}
	
	public Song(int id,String name, int singer, String file, String language, String style, String lyric ,int times,String singername) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.file = file;
		this.language = language;
		this.style = style;
		this.lyric = lyric;
		this.times = times;
		this.singername = singername;
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
	public int getSinger() {
		return singer;
	}
	public void setSinger(int singer) {
		this.singer = singer;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", singer=" + singer + ", file=" + file + ", language=" + language
				+ ", style=" + style + ", lyric=" + lyric + ", times=" + times + ", singername=" + singername + "]";
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}

	public String getSingername() {
		return singername;
	}

	public void setSingername(String singername) {
		this.singername = singername;
	}
}
