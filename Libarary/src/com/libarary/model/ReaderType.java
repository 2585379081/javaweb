package com.libarary.model;

public class ReaderType {
	private int rdType;
	private String rdTypeName;
	private int canLendNum;
	private int canLendDay;
	private int canContitueTimes;
	private float punishRate;
	private int dateValid;
	public int getRdType() {
		return rdType;
	}
	public String getRdTypeName() {
		return rdTypeName;
	}
	public int getCanLendNum() {
		return canLendNum;
	}
	public int getCanLendDay() {
		return canLendDay;
	}
	public int getCanContitueTimes() {
		return canContitueTimes;
	}
	public float getPunishRate() {
		return punishRate;
	}
	public int getDateValid() {
		return dateValid;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public void setRdTypeName(String rdTypeName) {
		this.rdTypeName = rdTypeName;
	}
	public void setCanLendNum(int canLendNum) {
		this.canLendNum = canLendNum;
	}
	public void setCanLendDay(int canLendDay) {
		this.canLendDay = canLendDay;
	}
	public void setCanContitueTimes(int canContitueTimes) {
		this.canContitueTimes = canContitueTimes;
	}
	public void setPunishRate(float punishRate) {
		this.punishRate = punishRate;
	}
	public void setDateValid(int dateValid) {
		this.dateValid = dateValid;
	}
}
