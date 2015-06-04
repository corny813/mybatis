package com.ices.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ices.dao.SRMapper;
import com.ices.entity.StaticRoute;
import com.ices.util.SqlSessionHelper;

public class SRController {

	
	private SqlSession session;

	/**
	 * 根据id查询
	 * @param id
	 */
	public void queryIPById(int id){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = SRMapper.queryIPByID(id);
//		System.out.println(item.getGuid()+","+item.getIp());
	}
	
	/**
	 * 指定guid查询IP
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryIPByGUID(String guid){
		SRMapper mapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) mapper.queryIPByGUID(guid);
		return items;
	}
	
	/**
	 * 指定guid查询IP
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryProxyIPByGUID(String guid){
		SRMapper mapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) mapper.queryProxyIPByGUID(guid);
		return items;
	}
	
	/**
	 * 查询所有结果
	 * @return
	 */
	public List<StaticRoute> queryAllItem(){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) SRMapper.queryAllItem();
		System.out.println(items.size());
		return items;
	}
	
	/**
	 * 指定guid查询所有结果
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryAllItemByGUID(String guid){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) SRMapper.queryAllItemByGUID(guid);
		return items;
	}
	
	
	/**
	 * id自增形式插入
	 * @param guid
	 * @param ip
	 * @param proxyIP
	 */
	public void insertItem(String guid,String ip,String proxyIP){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = new StaticRoute();
		
		item.setGuid(guid);
		item.setIp(ip);
		item.setProxyIP(proxyIP);
		
		SRMapper.insertItem(item);
		session.commit();
	}
	
	/**
	 * 根据guid,proxyIP更新ip为newIP
	 * @param guid
	 * @param proxyIP
	 * @param newIP
	 */
	public void updateIP(String guid,String proxyIP,String newIP){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = new StaticRoute();
		
		item.setGuid(guid);
		item.setProxyIP(proxyIP);
		item.setIp(newIP);
		
		SRMapper.updateIP(item);
		
		session.commit();
//		System.out.println("update: "+item.toString());
	}
	
	/**
	 * 根据guid更新IP
	 * @param guid
	 * @param newIP
	 */
	public void updateIPByGUID(String guid,String newIP){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = new StaticRoute();
		
		item.setGuid(guid);
		item.setIp(newIP);
		
		SRMapper.updateIPByGUID(item);
		
		session.commit();
//		System.out.println("update: "+item.toString());
	}
	
	/**
	 * 根据ip,proxyIP更新guid为newGUID
	 * @param ip
	 * @param proxyIP
	 * @param newGUID
	 */
	public void updateGUID(String ip,String proxyIP,String newGUID){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = new StaticRoute();
		
		item.setIp(ip);
		item.setProxyIP(proxyIP);
		item.setGuid(newGUID);
		
		SRMapper.updateGUID(item);
		
		session.commit();
//		System.out.println("update: "+item.toString());
	}
	
	
	/**
	 * 根据guid,ip更新proxyIP为newProxyIP
	 * @param guid
	 * @param ip
	 * @param newProxyIP
	 */
	public void updateProxyIP(String guid,String ip,String newProxyIP){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = new StaticRoute();
		
		item.setGuid(guid);
		item.setIp(ip);
		item.setProxyIP(newProxyIP);
		
		SRMapper.updateProxyIP(item);
		
		session.commit();
//		System.out.println("update: "+item.toString());
	}
	
	/**
	 * 根据guid更新proxyIP
	 * @param guid
	 * @param newProxyIP
	 */
	public void updateProxyIPByGUID(String guid,String newProxyIP){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = new StaticRoute();
		
		item.setGuid(guid);
		item.setProxyIP(newProxyIP);
		
		SRMapper.updateProxyIPByGUID(item);
		
		session.commit();
//		System.out.println("update: "+item.toString());
	}
	
	/**
	 * 打开session会话
	 * @return
	 */
	public SqlSession openSession(){
		SqlSession session = SqlSessionHelper.getSessionFactory().openSession();
		this.session = session;
		return session;
	}
	
	/**
	 * 关闭会话
	 */
	public void closeSession(){
		if(session!=null){
//			session.commit();
			session.close();
		}
	}
	
	public static void main(String[] args){
		SRController con = new SRController();
		SqlSession session = con.openSession();
		List<StaticRoute> items = con.queryIPByGUID("gu1");
		System.out.println(items.size());
	}
	
}
