package com.oracleoaec.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICommonDao<T> {
  public int save(T obj) throws SQLException;
  public int delete(long id) throws SQLException;
  public int delete(T obj) throws SQLException;
  public int update(T obj) throws SQLException;
  public List<T> queryAll() throws SQLException;
  public T query(T obj) throws SQLException;
  public T queryById(long id) throws SQLException;
  public T queryByName(String name) throws SQLException;
  public List<T> queryByLimit(Object...obj) throws SQLException;
}
