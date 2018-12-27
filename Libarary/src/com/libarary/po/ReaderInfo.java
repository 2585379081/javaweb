package com.libarary.po;

public class ReaderInfo {

	private int rdID;
	private String rdName;
	private int rdType;
	private int canLendNum;
	public String getRdDept() {
		return rdDept;
	}
	public void setRdDept(String rdDept) {
		this.rdDept = rdDept;
	}
	private int canLendDay;
	private String rdDept;
	public int getRdID() {
		return rdID;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public String getRdName() {
		return rdName;
	}
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public int getCanLendNum() {
		return canLendNum;
	}
	public void setCanLendNum(int canLendNum) {
		this.canLendNum = canLendNum;
	}
	public int getCanLendDay() {
		return canLendDay;
	}
	public void setCanLendDay(int canLendDay) {
		this.canLendDay = canLendDay;
	}
	public int getLendedNum() {
		return LendedNum;
	}
	public void setLendedNum(int lendedNum) {
		LendedNum = lendedNum;
	}
	private int LendedNum;
	
}
