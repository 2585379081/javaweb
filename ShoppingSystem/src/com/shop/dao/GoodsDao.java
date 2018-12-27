package com.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.pojo.Goods;
import com.shop.tool.SQLHelper;

public class GoodsDao {
	//显示所有的商品
	public List<Goods>showAllGoods() throws SQLException{
		List<Goods> goodsList = new ArrayList<Goods>();
		
		String sql  = "select * from TB_Goods";
		ResultSet rs = com.shop.tool.SQLHelper.getResultSet(sql);
		
		//把resultset转化为list<goods>
		while(rs.next()) {
			Goods goods = new Goods();
			goods.setGoodsBrief(rs.getString("goodsBrief"));
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setGoodsCat(rs.getString("goodsCat"));
			goods.setGoodsImage(rs.getBytes("goodsImage"));
			goods.setGoodsNum(rs.getInt("goodsNum"));
			goods.setGoodsPrice(rs.getFloat("goodsPrice"));
			goodsList.add(goods);
		} 
		
		//如果list为空的话
		if(goodsList.size()==0) return null;
		return goodsList;
	}
	
	
	//按照商品的名称来查询商品
	public List<Goods> queryByName(String goodsName) throws SQLException {
		List<Goods> goodsList = new ArrayList<Goods>();
		String sql = "select * from TB_Goods where goodsName like ?";
		Object[] object = {"%"+goodsName+"%"};
		ResultSet rs = SQLHelper.getResultSet(sql,object);
		
		//result Set转化为goods类型
		while(rs.next()) {
			Goods goods = new Goods();
			goods.setGoodsBrief(rs.getString("goodsBrief"));
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setGoodsCat(rs.getString("goodsCat"));
			goods.setGoodsImage(rs.getBytes("goodsImage"));
			goods.setGoodsNum(rs.getInt("goodsNum"));
			goods.setGoodsPrice(rs.getFloat("goodsPrice"));
			goodsList.add(goods);
		}
		
		//如果list为空的话
		if(goodsList.size()==0) return null;
		return goodsList;
	}
	
	
	//按照商品的id来查询商品
	public List<Goods> queryById(Integer goodsId) throws SQLException {
		List<Goods> goodsList = new ArrayList<Goods>();
		String sql = "select * from TB_Goods where goodsId = ?";
		Object[] object = {goodsId};
		ResultSet rs = SQLHelper.getResultSet(sql,object);
		
		while(rs.next()) {
			Goods goods = new Goods();
			goods.setGoodsBrief(rs.getString("goodsBrief"));
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setGoodsCat(rs.getString("goodsCat"));
			goods.setGoodsImage(rs.getBytes("goodsImage"));
			goods.setGoodsNum(rs.getInt("goodsNum"));
			goods.setGoodsPrice(rs.getFloat("goodsPrice"));
			goodsList.add(goods);
		}
		
		
		//如果list为空的话
		if(goodsList.size()==0) return null;
		return goodsList;
	}
	
	
	//增加商品
	public int addGoods(Goods goods) {
		String sql = "insert into TB_Goods values (?,?,?,?,?,?,?) ";
		Object[] objects = {goods.getGoodsId(),goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsNum(),goods.getGoodsImage(),
			goods.getGoodsBrief(),goods.getGoodsCat()};
		int result = SQLHelper.ExecSql(sql,objects);
		
		return result;
	}
	
	
	//修改商品
	public int updateGoods(Goods goods) {
		String sql = "update TB_Goods set goodsName = ?,goodsPrice =?, "
				+ "goodsNum = ? ,goodsImage = ?,goodsBrief = ?,goodsCat = ? where goodsId =?";
		Object[] objects = {goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsNum(),goods.getGoodsImage(),
				goods.getGoodsBrief(),goods.getGoodsCat(),goods.getGoodsId()};
		int result = SQLHelper.ExecSql(sql,objects);
		return result;
	}
	
	
	//删除商品
	public  int deleteGoods(Goods goods) {
		String sql ="{call usp_deleteGoods(?)}";
		Object[] objects = {goods.getGoodsId()};
		int result = SQLHelper.execProcInGoods(sql,objects);
		return result;
	}
	

}
