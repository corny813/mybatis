package com.ices.dao;

import java.util.List;

import com.ices.entity.StaticRoute;

/**
 * sqlite�µı�srouter��ɾ�Ĳ�ӿ���
 * @author corny
 * 
 */
public interface SRMapper {

	/*********************** ���� ************************/
	/**
	 * id��������ʽ����
	 * 
	 * @param item
	 */
	public void insertItem(StaticRoute item);
	
 
	
	/*********************** ��ѯ ************************/
	/**
	 * ����GUID��ѯ
	 * 
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryIPByGUID(String guid);
	
	/**
	 * ָ��guid��ѯproxyIP
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryProxyIPByGUID(String guid);

	/**
	 * ����id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public StaticRoute queryIPByID(int id);

	/**
	 * ��ѯ���е�item
	 * 
	 * @return
	 */
	public List<StaticRoute> queryAllItem();
	
	/**
	 * ָ��guid��ѯ����ƥ����
	 * @return
	 */
	public List<StaticRoute> queryAllItemByGUID(String guid);
	

	
	/*********************** ɾ�� ************************/
	/**
	 * ���ݲ�����ɾ��
	 * 
	 * @param guid
	 */
	public void delete(String guid);

	
	
	/*********************** ���� ************************/
	/**
	 * ����IP
	 * 
	 * @param item
	 */
	public void updateIP(StaticRoute item);
	
	/**
	 * ָ��guid����IP
	 * 
	 * @param item
	 */
	public void updateIPByGUID(StaticRoute item);

	/**
	 * ����guid
	 * 
	 * @param item
	 */
	public void updateGUID(StaticRoute item);

	/**
	 * ���´���IP
	 * 
	 * @param item
	 */
	public void updateProxyIP(StaticRoute item);

	/**
	 * ָ��guid���´���IP
	 * 
	 * @param item
	 */
	public void updateProxyIPByGUID(StaticRoute item);

}
