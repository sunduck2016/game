package com.game.vo;

public class MapleInfoVO {
	
	private int miNum;
	private String miName;
	private String miServer;
	private String miJob;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
	private String searchStr;
	private String searchType;
	public int getMiNum() {
		return miNum;
	}
	public void setMiNum(int miNum) {
		this.miNum = miNum;
	}
	public String getMiName() {
		return miName;
	}
	public void setMiName(String miName) {
		this.miName = miName;
	}
	public String getMiServer() {
		return miServer;
	}
	public void setMiServer(String miServer) {
		this.miServer = miServer;
	}
	public String getMiJob() {
		return miJob;
	}
	public void setMiJob(String miJob) {
		this.miJob = miJob;
	}
	public String getCredat() {
		return credat;
	}
	public void setCredat(String credat) {
		this.credat = credat;
	}
	public String getCretim() {
		return cretim;
	}
	public void setCretim(String cretim) {
		this.cretim = cretim;
	}
	public String getLmodat() {
		return lmodat;
	}
	public void setLmodat(String lmodat) {
		this.lmodat = lmodat;
	}
	public String getLmotim() {
		return lmotim;
	}
	public void setLmotim(String lmotim) {
		this.lmotim = lmotim;
	}
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	@Override
	public String toString() {
		return "MapleInfoVO [miNum=" + miNum + ", miName=" + miName + ", miServer=" + miServer + ", miJob=" + miJob
				+ ", credat=" + credat + ", cretim=" + cretim + ", lmodat=" + lmodat + ", lmotim=" + lmotim
				+ ", searchStr=" + searchStr + ", searchType=" + searchType + "]";
	}
}
