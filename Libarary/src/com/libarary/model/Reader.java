package com.libarary.model;

import java.awt.Image;
import java.util.Date;

public class Reader {
	private String rdTypeName;
	private int rdID;
	private String rdName;
	private String rdSex;
	private int rdType;
	private String rdDept;
	private String rdPhone;
	private String rdEmail;
	private Date rdDateReg;
	public String getRdTypeName() {
		return rdTypeName;
	}
	public void setRdTypeName(String rdTypeName) {
		this.rdTypeName = rdTypeName;
	}

	private String rdPhoto;
	private String rdStatus;
	private int rdBorrowNum;
	public String getRdPhoto() {
		return rdPhoto;
	}
	public void setRdPhoto(String rdPhoto) {
		this.rdPhoto = rdPhoto;
	}

	private String rdPwd;
	private int rdAdminRoles;
	public int getRdID() {
		return rdID;
	}
	public String getRdName() {
		return rdName;
	}
	public String getRdSex() {
		return rdSex;
	}
	public int getRdType() {
		return rdType;
	}
	public String getRdDept() {
		return rdDept;
	}
	public String getRdPhone() {
		return rdPhone;
	}
	public String getRdEmail() {
		return rdEmail;
	}
	public Date getRdDateReg() {
		return rdDateReg;
	}

	public String getRdStatus() {
		return rdStatus;
	}
	public int getRdBorrowNum() {
		return rdBorrowNum;
	}
	public String getRdPwd() {
		return rdPwd;
	}
	public int getRdAdminRoles() {
		return rdAdminRoles;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	public void setRdSex(String rdSex) {
		this.rdSex = rdSex;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public void setRdDept(String rdDept) {
		this.rdDept = rdDept;
	}
	public void setRdPhone(String rdPhone) {
		this.rdPhone = rdPhone;
	}
	public void setRdEmail(String rdEmail) {
		this.rdEmail = rdEmail;
	}
	public void setRdDateReg(Date rdDateReg) {
		this.rdDateReg = rdDateReg;
	}

	public void setRdStatus(String rdStatus) {
		this.rdStatus = rdStatus;
	}
	public void setRdBorrowNum(int rdBorrowNum) {
		this.rdBorrowNum = rdBorrowNum;
	}
	public void setRdPwd(String rdPwd) {
		this.rdPwd = rdPwd;
	}
	public void setRdAdminRoles(int rdAdminRoles) {
		this.rdAdminRoles = rdAdminRoles;
	}
	
	public String toString() {
		return rdID+" "+rdName+" "+rdSex+" "+rdType+" "+rdDept+" "+rdPhone+" "+rdEmail+" "+rdStatus+" "+rdBorrowNum+" "+rdDateReg;
	}
	
}
