package com.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.pojo.ShopCart;
import com.shop.tool.SQLHelper;

public class ShopCartDao {

	// 得到客户购物车里面的所有商品
	public Object[] getAllObjects(String userId) throws Exception {
		ArrayList<ShopCart> objects = new ArrayList<ShopCart>();
		ResultSet rSet = SQLHelper.getResultSet("select * from TB_ShopCart where userId = " + userId);
		if (rSet != null) {
			while (rSet.next()) {
				ShopCart shopCart = initShopCart(rSet);
				objects.add(shopCart);
			}
			rSet.close();
		}
		ShopCart[] shopCarts = new ShopCart[objects.size()];
		objects.toArray(shopCarts);
		return shopCarts;
	}

	// 修改商品数量
	public int alterGoodsNumber(ShopCart shopCart) {
		String sql = "exec alterShopCartGoodsNumber ?,?,?";
		Object[] params=new Object[3];
		params[0]=shopCart.getUserId();
		params[1]=shopCart.getGoodsId();
		params[2]=shopCart.getGoodsQty();
		return SQLHelper.ExecSql(sql,params);
	}
	
	//删除购物车中的指定商品
	public int deleteGoods(ShopCart shopCart) {
		String sql = "delete from TB_ShopCart where userId = ? and goodsId = ?";
		Object[] params=new Object[2];
		params[0]=shopCart.getUserId();
		params[1]=shopCart.getGoodsId();
		return SQLHelper.ExecSql(sql,params);
	}

	// 添加商品到购物车
	public int addGoods(ShopCart shopCart) {
		String sql = "exec addGoodsToShopCart ?,?,?";
		Object[] params=new Object[3];
		params[0]=shopCart.getUserId();
		params[1]=shopCart.getGoodsId();
		params[2]=shopCart.getGoodsQty();
		return SQLHelper.ExecSql(sql,params);
	}

	private ShopCart initShopCart(ResultSet rSet) throws SQLException {
		ShopCart shopCart = new ShopCart();
		shopCart.setGoodsId(rSet.getInt("goodsId"));
		shopCart.setUserId(rSet.getString("userId"));
		shopCart.setGoodsQty(rSet.getInt("goodsQty"));
		return shopCart;
	}
}
