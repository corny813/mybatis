package com.ices.dao;

import java.util.List;

import com.ices.entity.RouteItem3;

/**
 * sqlite�µı�router3��ɾ�Ĳ�ӿ���
 * @author corny
 *
 */
public interface RI3Mapper {

	/*********************** ����************************/
	/**
	 * id��������ʽ����
	 * 
	 * @param item
	 */
	public void insertItem(RouteItem3 item);
	
	
	
	/***********************��ѯ************************/
	/**
	 * ����GUID��ѯ
	 * @param guid
	 * @return
	 */
	public RouteItem3 queryIPByGUID(String guid);
	
	/**
	 * ����GUID��ѯ
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllIPByGUID(String guid);
	
	/**
	 * ��ѯ��һ��GU��ip
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllNextIPByGUID(String guid);
	
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	public RouteItem3 queryIPByID(int id);
	
	/**
	 * ��ѯ���е�item
	 * @return
	 */
	public List<RouteItem3> queryAllItem();
	
	/**
	 * ָ��guid��ѯ����ƥ����
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllItemByGUID(String guid);
	
	
	/***********************ɾ��************************/
	/**
	 * ���ݲ�����ɾ��
	 * @param guid
	 */
	public void delete(String guid);
	
	
	
	/***********************����************************/
	/**
	 * ����IP
	 * @param item
	 */
	public void updateIP(RouteItem3 item);
	
	/**
	 * ָ��guid����ip
	 * @param item
	 */
	public void updateIPByGUID(RouteItem3 item);
	
	/**
	 * ����guid
	 * @param item
	 */
	public void updateGUID(RouteItem3 item);
	
	/**
	 * ����nextIP
	 * @param item
	 */
	public void updateNextIP(RouteItem3 item);
	
	/**
	 * ָ��guid����nextIP
	 * @param item
	 */
	public void updateNextIPByGUID(RouteItem3 item);
	
}
