package com.shop.pojo;

public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsNum;
	private float goodsPrice;
	public int getGoodsId() {
		return goodsId;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public byte[] getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(byte[] goodsImage) {
		this.goodsImage = goodsImage;
	}
	public String getGoodsBrief() {
		return goodsBrief;
	}
	public void setGoodsBrief(String goodsBrief) {
		this.goodsBrief = goodsBrief;
	}
	public String getGoodsCat() {
		return goodsCat;
	}
	public void setGoodsCat(String goodsCat) {
		this.goodsCat = goodsCat;
	}
	private byte[] goodsImage;
	private String goodsBrief;
	private String goodsCat;

}

