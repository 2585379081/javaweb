package com.shop.service;

import com.shop.dao.ShopCartDao;
import com.shop.pojo.ShopCart;

public class ShopCartService {

	//返回客户的购物车中的信息
	public ShopCart[] getAllShopCart(String userId) throws Exception{
		ShopCartDao dao = new ShopCartDao();
		ShopCart[] shopCarts = (ShopCart[])dao.getAllObjects(userId);
		return shopCarts;
	}
	
	//修改商品数量
	public int alterGoodsNumber(String userId, int goodsId, int goodsQty) throws Exception{
		ShopCartDao dao = new ShopCartDao();
		ShopCart shopCart = new ShopCart();
		shopCart.setAll(userId, goodsId, goodsQty);
		return dao.alterGoodsNumber(shopCart);
	}
	
	//删除指定商品
	public int deleteGoods(String userId, int goodsId) throws Exception{
		ShopCartDao dao = new ShopCartDao();
		ShopCart shopCart = new ShopCart();
		shopCart.setUserId(userId);
		shopCart.setGoodsId(goodsId);
		return dao.deleteGoods(shopCart);
	}
	
	//添加商品到购物车
	public int addGoods(String userId, int goodsId, int goodsQty) throws Exception{
		ShopCartDao dao = new ShopCartDao();
		ShopCart shopCart = new ShopCart();
		shopCart.setAll(userId, goodsId, goodsQty);
		return dao.addGoods(shopCart);
	}
}
