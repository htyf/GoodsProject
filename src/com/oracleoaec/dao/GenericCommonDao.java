package com.oracleoaec.dao;

import java.sql.SQLException;
import java.util.List;

import com.oracleoaec.jdbc.JDBCTemplate;
public class GenericCommonDao<T> extends JDBCTemplate<T> implements ICommonDao<T> {
	@Override
	public int save(T obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(T obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(T obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> queryAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T query(T obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T queryById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T queryByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> queryByLimit(Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
