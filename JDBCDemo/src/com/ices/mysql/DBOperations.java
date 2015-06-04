package com.ices.mysql;
//package com.xbrother.mysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.xbrother.entity.RouteItem;
//import com.xbrother.util.Utils;
//
///**
// * 封装数据库的增删改查操作，对外提供接口函数
// * @author corny
// *
// */
//public class DBOperations {
//
//	public int getLastId(){
//		Connection conn = DBConnection.getConnection();
//		Statement stmt = null;
//		ResultSet rs = null;
//		int id = 0;
//		
//		try {
//			stmt = conn.createStatement();
//			String sql = "select max(id) from router";
//			rs = stmt.executeQuery(sql);
//			if(rs.next()){
//				id = rs.getInt(1);
//				System.out.println(id);
//			}
//			String sql2 = "select last_insert_id()";
//			rs = stmt.executeQuery(sql2);
//			if(rs.next()){
//				id =  id>rs.getInt(1)?id:rs.getInt(1);
//				System.out.println(id);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return id;
//	}
//	
//	public void insertNode(String code,String mask,String hostIP){
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement ps = null;
//		String range = Utils.codeToRange(code, mask);
//		int id = getLastId()+1;
//		
//			try {
//				String sql = "insert into router values(?,?,?,?,?,?,?,?,?);";
//				ps = conn.prepareStatement(sql);
//				ps.setInt(1, id);// 设置占位符参数
//				ps.setString(2, range);
//				ps.setString(3, mask);
//				ps.setString(4, null);
//				ps.setString(5, null);
//				ps.setString(6, hostIP);
//				ps.setString(7, null);
//				ps.setString(8, null);
//				ps.setInt(9, 0);
//				ps.execute();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				DBConnection.closePreparedStatement(ps);
//				DBConnection.closeConnection(conn);
//			}
//	}
//	
//	public void deleteNode(String code,String mask){
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement ps = null;
//		String range = Utils.codeToRange(code, mask);
//		String sql = "delete from router where cacheRange=? and cacheMask=?";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, range);// 设置占位符参数
//			ps.setString(2, mask);
//			ps.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBConnection.closePreparedStatement(ps);
//			DBConnection.closeConnection(conn);
//		}
//	}
//	
//	public void updateNodeCode(String code,String mask,String hostIP,String newCode){
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement ps = null;
//		String newRange = Utils.codeToRange(newCode, mask);
//		String sql = "update router set cacheRange=? where cacheMask=? and hostIP=?";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, newRange);// 设置占位符参数
//			ps.setString(2, mask);
//			ps.setString(3, hostIP);
//			ps.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBConnection.closePreparedStatement(ps);
//			DBConnection.closeConnection(conn);
//		}
//	}
//	
//	public void updateNodeMask(String code,String mask,String hostIP,String newMask){
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement ps = null;
//		String range = Utils.codeToRange(code, mask);
//		String sql = "update router set cacheMask=? where cacheRange=? and hostIP=?";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, newMask);// 设置占位符参数
//			ps.setString(2, range);
//			ps.setString(3, hostIP);
//			ps.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBConnection.closePreparedStatement(ps);
//			DBConnection.closeConnection(conn);
//		}
//	}
//	
//	public void updateNodeIp(String code,String mask,String hostIP,String newIp){
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement ps = null;
//		String range = Utils.codeToRange(code, mask);
//		String sql = "update router set hostIP=? where cacheMask=? and cacheRange=?";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, newIp);// 设置占位符参数
//			ps.setString(2, mask);
//			ps.setString(3, range);
//			ps.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBConnection.closePreparedStatement(ps);
//			DBConnection.closeConnection(conn);
//		}
//	}
//	
//	public void queryAllByStatement() {
//		List<RouteItem> RouteItems = new ArrayList<RouteItem>();
//		Connection conn = DBConnection.getConnection();
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select * from router");
//			while (rs.next()) {
//				RouteItem RouteItem = new RouteItem();
//				RouteItem.setCacheRange(rs.getString("cacheRange"));
//				RouteItem.setCacheMask(rs.getString("cacheMask"));
//				RouteItem.setTimeSeriesRange(rs.getString("timeSeriesRange"));
//				RouteItem.setTimeSeriesMask(rs.getString("timeSeriesMask"));
//				RouteItem.setHostIP(rs.getString("hostIP"));
//				RouteItem.setNextDirIP(rs.getString("nextDirIP"));
//				RouteItem.setTargetDirIP(rs.getString("targetDirIP"));
//				RouteItem.setCost(rs.getInt("cost"));
////				System.out.println(RouteItem.toString());
//				RouteItems.add(RouteItem);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.closeResultSet(rs);
//			DBConnection.closeStatement(stmt);
//			DBConnection.closeConnection(conn);
//		}
//	}
//
//	public void queryAllByprepareStatement() {
//		List<RouteItem> RouteItems = new ArrayList<RouteItem>();
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement("select * from router");
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				RouteItem RouteItem = new RouteItem();
//				RouteItem.setCacheRange(rs.getString("cacheRange"));
//				RouteItem.setCacheMask(rs.getString("cacheMask"));
//				RouteItem.setTimeSeriesRange(rs.getString("timeSeriesRange"));
//				RouteItem.setTimeSeriesMask(rs.getString("timeSeriesMask"));
//				RouteItem.setHostIP(rs.getString("hostIP"));
//				RouteItem.setNextDirIP(rs.getString("nextDirIP"));
//				RouteItem.setTargetDirIP(rs.getString("targetDirIP"));
//				RouteItem.setCost(rs.getInt("cost"));
////				System.out.println(RouteItem.toString());
//				RouteItems.add(RouteItem);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.closeResultSet(rs);
//			DBConnection.closeStatement(ps);
//			DBConnection.closeConnection(conn);
//		}
//	}
//
//	public RouteItem queryByCode(String code,String mask) {
//		Connection conn = DBConnection.getConnection();
//		Statement stmt = null;
//		ResultSet rs = null;
//		String resultIP = null;
//		String range = Utils.codeToRange(code, mask);
//		String sql = "select * from router where cacheRange='"+range+"' and cacheMask='"+mask+"'";
//		RouteItem RouteItem = new RouteItem();
//		int maxMaskLen = 0;
//		
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while(rs.next()){
//				resultIP = rs.getString("hostIP");
//				int maskLen = rs.getString("cacheMask").length();
////				maxMaskLen = maskLen > maxMaskLen ? maskLen : maxMaskLen;
//				
//				RouteItem.setCacheRange(rs.getString("cacheRange"));
//				RouteItem.setCacheMask(rs.getString("cacheMask"));
//				RouteItem.setTimeSeriesRange(rs.getString("timeSeriesRange"));
//				RouteItem.setTimeSeriesMask(rs.getString("timeSeriesMask"));
//				RouteItem.setHostIP(rs.getString("hostIP"));
//				RouteItem.setNextDirIP(rs.getString("nextDirIP"));
//				RouteItem.setTargetDirIP(rs.getString("targetDirIP"));
//				RouteItem.setCost(rs.getInt("cost"));
//			}
////			System.out.println(resultIP);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBConnection.closeResultSet(rs);
//			DBConnection.closeStatement(stmt);
//			DBConnection.closeConnection(conn);
//		}
//		return RouteItem;
//	}
//
//	public RouteItem queryPrepareByCode(String code,String mask) {
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String resultIP = null;
//		String range = Utils.codeToRange(code, mask);
//		RouteItem RouteItem = new RouteItem();
//		
//		try {
//			ps = conn.prepareStatement("select * from router where cacheRange = ? and cacheMask=?");
//			ps.setString(1, range);// 设置占位符参数
//			ps.setString(2, mask);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				resultIP = rs.getString("hostIP");
//				RouteItem.setCacheRange(rs.getString("cacheRange"));
//				RouteItem.setCacheMask(rs.getString("cacheMask"));
//				RouteItem.setTimeSeriesRange(rs.getString("timeSeriesRange"));
//				RouteItem.setTimeSeriesMask(rs.getString("timeSeriesMask"));
//				RouteItem.setHostIP(rs.getString("hostIP"));
//				RouteItem.setNextDirIP(rs.getString("nextDirIP"));
//				RouteItem.setTargetDirIP(rs.getString("targetDirIP"));
//				RouteItem.setCost(rs.getInt("cost"));
//			}
////			System.out.println(resultIP);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.closeResultSet(rs);
//			DBConnection.closeStatement(ps);
//			DBConnection.closeConnection(conn);
//		}
//		return RouteItem;
//	}
//	
//	public void setRouteItem(int a,String...args){
//		
//	}
//}
