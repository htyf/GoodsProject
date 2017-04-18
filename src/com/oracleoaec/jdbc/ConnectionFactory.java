package com.oracleoaec.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static String URL;
	public static String USER;
	public static String PASSWORD;
	public static String DRIVER;
	public static Connection conn;
	static{
		Properties p = new Properties();
		Reader reader = null;
		try {
			//在SRC下的配置文件，推荐使用
			String path = ConnectionFactory.class.getClassLoader().getResource("/").getPath();
			reader = new FileReader(path+"/db.properties");
			//在WebContent下的配置文件，不推荐
//			String path = ConnectionFactory.class.getClassLoader().getResource("/").getPath();
//			File parentFile = new File(path).getParentFile().getParentFile();
//			reader = new FileReader(parentFile+"/db.properties");
			p.load(reader);
			USER = p.getProperty("name", "soysouce");
			PASSWORD = p.getProperty("pwd", "soysouce");
			URL = p.getProperty("driver_url", "jdbc:oracle:thin:@127.0.0.1:1521:XE");
			DRIVER = p.getProperty("driver", "oracle.jdbc.driver.OracleDriver");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			System.out.println("文件读取失败");
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(URL , USER , PASSWORD);
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return conn;
	}
}

















