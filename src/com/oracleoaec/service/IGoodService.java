package com.oracleoaec.service;

import java.util.List;

import com.oracleoaec.entity.Goods;
import com.oracleoaec.entity.Pager;

public interface IGoodService {
	/**
	 * 添加一个商品到数据库
	 * @param goods 含有数据的商品对象
	 * @return 0失败 1成功
	 */
	public abstract int addGoods(Goods goods); 
	/**
	 * 查询所有商品
	 * @return null查询失败    list 含有商品数据的集合
	 */
	public abstract List<Goods> queryAllGoods(); 
	
	/**
	 * 分页查询
	 * @param pager
	 * @return
	 */
	public List<Goods> getAllGoods(Pager pager);
	
}
