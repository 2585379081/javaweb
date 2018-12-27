package com.shop.pojo;

public class ShopCart {

	private String userId;
	private int goodsId;
	private int goodsQty;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsQty() {
		return goodsQty;
	}
	public void setGoodsQty(int goodsQty) {
		this.goodsQty = goodsQty;
	}
	public void setAll(String userId, int goodsId, int goodsQty) {
		this.userId = userId;
		this.goodsId = goodsId;
		this.goodsQty = goodsQty;
	}
}
