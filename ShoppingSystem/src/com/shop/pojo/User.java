package com.shop.pojo;


public class User 
{
	//用户实体类
	private String userId;//用户ID
	private String userPwd;//用户密码
	private String nickName;//用户昵称
	private int    isVip;  //此处取三个值。0:普通用户。1：会员用户 2：管理员
	private String phone;//用户电话
	private String userAddress;//用户收获地址
	private byte[] userImage;//用户头像
	private String payPwd;//用户支付密码
	
	
	
	//一键生成 get/set
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getIsVip() {
		return isVip;
	}
	public void setIsVip(int isVip) {
		this.isVip = isVip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public byte[] getUserImage() {
		return userImage;
	}
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
	public String getPayPwd() {
		return payPwd;
	}
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
	
	
	
}
