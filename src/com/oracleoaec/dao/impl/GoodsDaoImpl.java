package com.oracleoaec.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.GenericCommonDao;
import com.oracleoaec.entity.Goods;
import com.oracleoaec.jdbc.ConnectionFactory;
import com.oracleoaec.jdbc.PreparedStatementSetter;

public class GoodsDaoImpl extends GenericCommonDao<Goods>{
	@Override
	public int save(final Goods obj) throws SQLException {
		String sql = "insert into table_goods values(table_goods_seq.nextval,?,?,?)";
		int row = update(sql , new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, obj.getG_name());
				ps.setLong(2, obj.getG_count());
				ps.setFloat(3, obj.getG_price());
			}
		});
		return row;
	}
	@Override
	public List<Goods> queryAll() throws SQLException {
		String sql = "select * from table_goods";
		List<Goods> list = query(Goods.class, sql , null);
		return list.size()>0?list:null;
	}
	
	
	//根据开始结束  找到范围内的所有商品
	public List<Goods> serachAllGoods(final int start, final int end) {
		List<Goods> list = new ArrayList<>();
		//这边要自己写连接
		String sql = "select t.* from(select rownum as r, table_goods.* from table_goods)t where t.r > ? and t.r <=?";
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setG_id(rs.getLong("G_ID"));
				goods.setG_name(rs.getString("G_NAME"));
				goods.setG_count(rs.getLong("G_COUNT"));
				goods.setG_price(rs.getFloat("G_PRICE"));
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list.size()>0?list:null;
	}
	
}












