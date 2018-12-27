package com.libarary.po;

import java.io.Serializable;

public class BookInfo implements Serializable{
	private String bkID;
	private String bkName;
	private String bkAuthor;
	private String idContitueTimes;
	private String idDateOut;
	private String idDateRetPlan;
	public String getBkID() {
		return bkID;
	}
	public void setBkID(String bkID) {
		this.bkID = bkID;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public String getBkAuthor() {
		return bkAuthor;
	}
	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
	public String getIdContitueTimes() {
		return idContitueTimes;
	}
	public void setIdContitueTimes(String idContitueTimes) {
		this.idContitueTimes = idContitueTimes;
	}
	public String getIdDateOut() {
		return idDateOut;
	}
	public void setIdDateOut(String idDateOut) {
		this.idDateOut = idDateOut;
	}
	public String getIdDateRetPlan() {
		return idDateRetPlan;
	}
	public void setIdDateRetPlan(String idDateRetPlan) {
		this.idDateRetPlan = idDateRetPlan;
	}
	public String getIdOverDay() {
		return idOverDay;
	}
	public String getIdOverMoney() {
		return idOverMoney;
	}
	public void setIdOverMoney(String idOverMoney) {
		this.idOverMoney = idOverMoney;
	}
	public void setIdOverDay(String idOverDay) {
		this.idOverDay = idOverDay;
	}
	private String idOverDay;
	private String idOverMoney;
	

}
