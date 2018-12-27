package com.libarary.po;

public class ReturnVo {
	private String rdID;
	private String bkID;
	private String idOverDay;
	private float idOverMoney;
	private String operatorRet;
	public String getRdID() {
		return rdID;
	}
	public String getIdOverDay() {
		return idOverDay;
	}
	public void setIdOverDay(String idOverDay) {
		this.idOverDay = idOverDay;
	}

	public float getIdOverMoney() {
		return idOverMoney;
	}
	public void setIdOverMoney(float idOverMoney) {
		this.idOverMoney = idOverMoney;
	}
	public String getOperatorRet() {
		return operatorRet;
	}
	public void setOperatorRet(String operatorRet) {
		this.operatorRet = operatorRet;
	}
	public void setRdID(String rdID) {
		this.rdID = rdID;
	}
	public String getBkID() {
		return bkID;
	}
	public void setBkID(String bkID) {
		this.bkID = bkID;
	}

}
