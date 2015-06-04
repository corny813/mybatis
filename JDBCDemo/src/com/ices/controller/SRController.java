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
	 * ����id��ѯ
	 * @param id
	 */
	public void queryIPById(int id){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		StaticRoute item = SRMapper.queryIPByID(id);
//		System.out.println(item.getGuid()+","+item.getIp());
	}
	
	/**
	 * ָ��guid��ѯIP
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryIPByGUID(String guid){
		SRMapper mapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) mapper.queryIPByGUID(guid);
		return items;
	}
	
	/**
	 * ָ��guid��ѯIP
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryProxyIPByGUID(String guid){
		SRMapper mapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) mapper.queryProxyIPByGUID(guid);
		return items;
	}
	
	/**
	 * ��ѯ���н��
	 * @return
	 */
	public List<StaticRoute> queryAllItem(){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) SRMapper.queryAllItem();
		System.out.println(items.size());
		return items;
	}
	
	/**
	 * ָ��guid��ѯ���н��
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryAllItemByGUID(String guid){
		SRMapper SRMapper = session.getMapper(SRMapper.class);
		ArrayList<StaticRoute> items = (ArrayList<StaticRoute>) SRMapper.queryAllItemByGUID(guid);
		return items;
	}
	
	
	/**
	 * id������ʽ����
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
	 * ����guid,proxyIP����ipΪnewIP
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
	 * ����guid����IP
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
	 * ����ip,proxyIP����guidΪnewGUID
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
	 * ����guid,ip����proxyIPΪnewProxyIP
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
	 * ����guid����proxyIP
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
	 * ��session�Ự
	 * @return
	 */
	public SqlSession openSession(){
		SqlSession session = SqlSessionHelper.getSessionFactory().openSession();
		this.session = session;
		return session;
	}
	
	/**
	 * �رջỰ
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
