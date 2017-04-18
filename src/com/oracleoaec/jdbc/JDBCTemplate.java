package com.oracleoaec.jdbc;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.utils.MyUtils;

public class JDBCTemplate<T> {
	public int update(String sql,PreparedStatementSetter setter) {
		Connection conn = null;
		PreparedStatement ps = null;
		int row = 0;//��Ӱ�������
		try {
			//1.������2.������ݿ�
			conn = ConnectionFactory.getConnection();
			//3.�����sql��� �����ݿ��������
			ps = conn.prepareStatement(sql);//װ��sql���
			//3.5ռλ���滻
			if (setter != null) {
				setter.setValues(ps);// �滻ռλ��
			}
			//4.ִ��sql���
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.�ر���Դ
			MyUtils.closeAll(conn, ps, null);
		}
		return row;
	}
//	User.class
	public List<T> query(Class<T> t,String sql,PreparedStatementSetter setter){
		List<T> list = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(ps);
			}
			rs = ps.executeQuery();
			list = new ArrayList<T>();
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				T obj = t.newInstance();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String name = rsmd.getColumnName(i+1);
					Object value = rs.getObject(name);
					Field field = t.getDeclaredField(name.toLowerCase());
					field.setAccessible(true);
					if(value instanceof BigDecimal){
						BigDecimal v = (BigDecimal) value;
						System.out.println(field.getType().getSimpleName());
						if("Long".equals(field.getType().getSimpleName())){
							System.out.println(value+"llllll");
							long longValue = v.longValue();
							field.set(obj, longValue);
						}else if("float".equals(field.getType().getSimpleName())){
							float longValue = v.floatValue();
							field.set(obj, longValue);
						}
					}else{
						field.set(obj, value);
					}
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}finally{
			MyUtils.closeAll(conn, ps, rs);
		}
		return list;
	}
}
