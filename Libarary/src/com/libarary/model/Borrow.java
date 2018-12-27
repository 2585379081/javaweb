package com.libarary.model;

public class Borrow {
	private float borrowID;
	private int rdID;
	private int bkID;
	private int idContitueTimes;
	private String idDateOut;
	private String idDateRetPlan;
	private String idDateRetAct;
	private int idOverDay;
	private float idOverMoney;
	private float idPunishMoney;
	public float getBorrowID() {
		return borrowID;
	}
	public int getRdID() {
		return rdID;
	}
	public int getBkID() {
		return bkID;
	}
	public int getIdContitueTimes() {
		return idContitueTimes;
	}
	public String getIdDateOut() {
		return idDateOut;
	}
	public String getIdDateRetPlan() {
		return idDateRetPlan;
	}
	public String getIdDateRetAct() {
		return idDateRetAct;
	}
	public int getIdOverDay() {
		return idOverDay;
	}
	public float getIdOverMoney() {
		return idOverMoney;
	}
	public float getIdPunishMoney() {
		return idPunishMoney;
	}
	public boolean isHashReturn() {
		return isHashReturn;
	}
	public String getOperatorLend() {
		return operatorLend;
	}
	public String getOperatorRet() {
		return operatorRet;
	}
	public void setBorrowID(float borrowID) {
		this.borrowID = borrowID;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
	public void setIdContitueTimes(int idContitueTimes) {
		this.idContitueTimes = idContitueTimes;
	}
	public void setIdDateOut(String idDateOut) {
		this.idDateOut = idDateOut;
	}
	public void setIdDateRetPlan(String idDateRetPlan) {
		this.idDateRetPlan = idDateRetPlan;
	}
	public void setIdDateRetAct(String idDateRetAct) {
		this.idDateRetAct = idDateRetAct;
	}
	public void setIdOverDay(int idOverDay) {
		this.idOverDay = idOverDay;
	}
	public void setIdOverMoney(float idOverMoney) {
		this.idOverMoney = idOverMoney;
	}
	public void setIdPunishMoney(float idPunishMoney) {
		this.idPunishMoney = idPunishMoney;
	}
	public void setHashReturn(boolean isHashReturn) {
		this.isHashReturn = isHashReturn;
	}
	public void setOperatorLend(String operatorLend) {
		this.operatorLend = operatorLend;
	}
	public void setOperatorRet(String operatorRet) {
		this.operatorRet = operatorRet;
	}
	private boolean isHashReturn;
	private String operatorLend;
	private String operatorRet;
	

}
