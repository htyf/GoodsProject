package com.oracleoaec.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.oracleoaec.dao.impl.GoodsDaoImpl;
import com.oracleoaec.entity.Goods;
import com.oracleoaec.entity.Pager;
import com.oracleoaec.service.IGoodService;

public class GoodsServiceImpl implements IGoodService{
	GoodsDaoImpl gdi = new GoodsDaoImpl();
	public List<Goods> getAllGoods(Pager pager) {
		List<Goods> list = queryAllGoods();
		if(list!=null){
			System.out.println("size"+list.size());
			// 设置总记录数
			if(pager.getRecordCount() == 0){
				pager.setRecordCount(list.size());
			}
			// 计算起始和结束位置
			int start = (pager.getCurrentPage() - 1) * Pager.PAGE_RECORD;
			int end = start + Pager.PAGE_RECORD;
			List<Goods> r_list = gdi.serachAllGoods(start, end);
			System.out.println("sizbbbb"+list.size());
			return r_list;
		}
		return null;
	}
	
	
	@Override
	public int addGoods(Goods goods) {
		if(goods == null){
			return 0;
		}
		int row = 0;
		try {
			row = gdi.save(goods);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	@Override
	public List<Goods> queryAllGoods() {
		List<Goods> list = null;
		try {
			list = gdi.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
