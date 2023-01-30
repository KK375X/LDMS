package com.ldms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBUtil {
	
   // 閸旂姾娴囨す鍗炲З閸氬秴鎷伴弫鐗堝祦鎼存挸婀撮崸锟�
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/ldms?useUnicode=true&characterEncoding=UTF-8";

   //  閺佺増宓佹惔鎾舵暏閹村嘲鎮曠�靛棛鐖�
   static final String USER = "root";
   static final String PASS = "934087731";
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstmt;
	
	private void openConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    //回滚
	public void connectionRollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    //提交事务
	public void commit() {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//閼惧嘲绶盨tatement
	public Statement getStatement() {
		openConnection();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stat;
	}
	
	//閼惧嘲绶盤reparedStatement
	public PreparedStatement getPreparedStatement(String sql) {
		openConnection();
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//閸忔娊妫村ù锟�
	public void closeResource() {
		try {
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			if (stat != null && !stat.isClosed()) {
				stat.close();
			}
			
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
