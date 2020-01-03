package com.fh.entity;

import java.io.Serializable;

public class DataTable implements Serializable{
	private static final long serialVersionUID = 3520594881115970282L;
	private Integer drew;
    private Integer start;
    private Integer length;
	public Integer getDrew() {
		return drew;
	}
	public void setDrew(Integer drew) {
		this.drew = drew;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
}
