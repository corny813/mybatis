package com.ices.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ices.dao.RI3Mapper;
import com.ices.entity.RouteItem3;
import com.ices.util.SqlSessionHelper;

public class RI3Controller {

	private SqlSession session;

	/**
	 * ����id��ѯ
	 * @param id
	 */
	public RouteItem3 queryById(int id){
		RI3Mapper mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = mapper.queryIPByID(id);
//		System.out.println(item.getIp()+","+item.getGuid());
		return item;
	}
	
	/**
	 * ����guid��ѯ
	 * @param guid
	 * @return
	 */
	public RouteItem3 queryIPByGUID(String guid){
		RI3Mapper mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = mapper.queryIPByGUID(guid);
		return item;
	}
	
	/**
	 * ����guid��������ipƥ����
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllIPByGUID(String guid){
		RI3Mapper mapper = session.getMapper(RI3Mapper.class);
		List<RouteItem3> item = mapper.queryAllIPByGUID(guid);
		return item;
	}
	
	/**
	 * ����guid��������nextIPƥ����
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllNextIPByGUID(String guid){
		RI3Mapper mapper = session.getMapper(RI3Mapper.class);
		List<RouteItem3> item = mapper.queryAllNextIPByGUID(guid);
		return item;
	}
	
	/**
	 * ��ѯ���н��
	 * @return
	 */
	public List<RouteItem3> queryAllItem(){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		ArrayList<RouteItem3> items = (ArrayList<RouteItem3>) RI3Mapper.queryAllItem();
//		System.out.println(items.size());
		return items;
	}
	
	/**
	 * ָ��guid��ѯ����ƥ����
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllItemByGUID(String guid){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		ArrayList<RouteItem3> items = (ArrayList<RouteItem3>) RI3Mapper.queryAllItemByGUID(guid);
		return items;
	}
	
	/**
	 * id������ʽ����
	 * @param guid
	 * @param ip
	 */
	public void insertItem(String guid,String ip){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setGuid(guid);
		item.setIp(ip);
		
		RI3Mapper.insertItem(item);
		session.commit();
	}
	
	/**
	 * id������ʽ����
	 * @param guid
	 * @param ip
	 */
	public void insertItem(String guid,String ip,String nextIP){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setGuid(guid);
		item.setIp(ip);
		item.setNextIP(nextIP);
		
		RI3Mapper.insertItem(item);
		session.commit();
	}
	
	/**
	 * id������ʽ����
	 * @param guid
	 * @param ip
	 */
	public void insertItem(String guid,String ip,String nextIP,int cost){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setGuid(guid);
		item.setIp(ip);
		item.setNextIP(nextIP);
		item.setCost(cost);
		
		RI3Mapper.insertItem(item);
		session.commit();
	}
	
	
	/**
	 * ָ��guid,nextIP����ipΪnewIP
	 * @param guid
	 * @param nextIP
	 * @param newIP
	 */
	public void updateIP(String guid,String nextIP,String newIP){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setGuid(guid);
		item.setNextIP(nextIP);
		item.setIp(newIP);
		
		RI3Mapper.updateIP(item);
		
		session.commit();
		
//		System.out.println("update: "+item.toString());
	}
	
	/**
	 * ָ��guid����IPΪnewIP
	 * @param guid
	 * @param newIP
	 */
	public void updateIPByGUID(String guid,String newIP){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setGuid(guid);
		item.setIp(newIP);
		
		RI3Mapper.updateIPByGUID(item);
		
		session.commit();
		
//		System.out.println("update: "+item.toString());
	}
	
	/**
	 * ָ��guid,ip����nextIPΪnewNextIP
	 * @param guid
	 * @param ip
	 * @param newNextIP
	 */
	public void updateNextIP(String guid,String ip,String newNextIP){
		RI3Mapper mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setGuid(guid);
		item.setIp(ip);
		item.setNextIP(newNextIP);
		
		mapper.updateNextIP(item);
		session.commit();
	}
	
	/**
	 * ָ��guid����nextIPΪnewNextIP
	 * @param guid
	 * @param newNextIP
	 */
	public void updateNextIPByGUID(String guid,String newNextIP){
		RI3Mapper mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setGuid(guid);
		item.setNextIP(newNextIP);
		
		mapper.updateNextIPByGUID(item);
		session.commit();
	}
	
	/**
	 * ����guidΪnewGUID
	 * @param ip
	 * @param nextIP
	 * @param newGUID
	 */
	public void updateGUID(String ip,String nextIP,String newGUID){
		RI3Mapper RI3Mapper = session.getMapper(RI3Mapper.class);
		RouteItem3 item = new RouteItem3();
		
		item.setIp(ip);
		item.setNextIP(nextIP);
		item.setGuid(newGUID);
		
		RI3Mapper.updateGUID(item);
		
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
		RI3Controller con = new RI3Controller();
		long begin = System.currentTimeMillis();
		con.openSession();
//		con.insertItem("gu1.gu2.gu3", "219.223.239.223","219.223.239.224");
//		List<RouteItem3> items = con.queryAllIPByGUID("gu1.gu2.gu3");
//		System.out.println(items.size());
//		List<RouteItem3> items1 = con.queryAllNextIPByGUID("gu1.gu2.gu3");
//		System.out.println(items1.size());
		
		String ipPre = "222.222.222.";
		List<RouteItem3> items = new ArrayList<RouteItem3>();
		con.closeSession();
		long time = System.currentTimeMillis()-begin;
		System.out.println("time:"+time);
	}
	
}
