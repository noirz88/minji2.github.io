package com.shop.model;

import java.util.Date;

public class NikonNoticeVO {
	private int seq;
	private String nname;
	private String ntit;
	private String ncon;
	private Date regdate;
	private int visited;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNtit() {
		return ntit;
	}
	public void setNtit(String ntit) {
		this.ntit = ntit;
	}
	public String getNcon() {
		return ncon;
	}
	public void setNcon(String ncon) {
		this.ncon = ncon;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
	
	
}
