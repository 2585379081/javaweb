package com.shop.service;

import java.sql.SQLException;
import java.util.List;

import com.shop.dao.GoodsDao;
import com.shop.pojo.Goods;

public class GoodsService {
	
	private GoodsDao goodsDao = new GoodsDao();
	
	
	public List<Goods>showAllGoods(){
		try {
			return goodsDao.showAllGoods();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Goods> queryGoods(Goods g) {
		
		String goodsName = g.getGoodsName();
		Integer goodsId = g.getGoodsId();
		
		
		//如果goodsName 不为空的话，就调用queryByName
		if(goodsName !=null) {
			try {
				 return goodsDao.queryByName(goodsName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(goodsId !=null) {
			 try {
				return goodsDao.queryById(goodsId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}
	
	
	//对商品进行增删改
	public int updateGoods(Goods goods,String op) {
		
		if(op.equals("add")) {
			//对商品进行插入
			return goodsDao.addGoods(goods);
		}else if(op.equals("update")) {
			//对商品进行修改
			return goodsDao.updateGoods(goods);
		}else if(op.equals("delete")) {
			//对商品进行删除
			return goodsDao.deleteGoods(goods);
		}
		
		return 0;
	}

}
