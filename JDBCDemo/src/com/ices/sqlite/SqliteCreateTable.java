package com.ices.sqlite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ices.mysql.DBConnection;

/**
 * 用于建表
 * 
 * @author corny
 * 
 */
public class SqliteCreateTable {

	public void createTabel(String sql) {
		
		Connection conn = DBConnection.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getSQL(){
		String sql = "drop table if exists router;create table router " 
				+ "(id INTEGER PRIMARY KEY   AUTOINCREMENT  NOT NULL ,"
				+ " range           TEXT    NOT NULL, "
				+ " min             INT     NOT NULL, "
				+ " max       		INT     NOT NULL, "
				+ " nextIP          TEXT NOT NULL)";
		return sql;
	}
	
	public static String getSQL3(){
		String sql = "drop table if exists router;create table router " 
				+ "(id INTEGER PRIMARY KEY   AUTOINCREMENT  NOT NULL ,"
				+ " guid           TEXT    NOT NULL, "
				+ " ip           TEXT    NOT NULL, "
				+ " nextIP          TEXT ,"
				+ " cost          INTEGER default -1)";
		return sql;
	}
	
	public static String getStaticRoute(){
		String sql = "drop table if exists srouter;create table srouter " 
				+ "(id INTEGER PRIMARY KEY   AUTOINCREMENT  NOT NULL ,"
				+ " guid           TEXT    NOT NULL, "
				+ " ip           TEXT    NOT NULL, "
				+ " proxyip          TEXT NOT NULL)";
		return sql;
	}


	public static void main(String[] args) {
		SqliteCreateTable oper = new SqliteCreateTable();
//		oper.createTabel(getSQL3());
//		oper.createTabel(getStaticRoute());
	}
}
