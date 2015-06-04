package com.ices.dao;

import java.util.List;

import com.ices.entity.StaticRoute;

/**
 * sqlite下的表srouter增删改查接口类
 * @author corny
 * 
 */
public interface SRMapper {

	/*********************** 插入 ************************/
	/**
	 * id自增的形式插入
	 * 
	 * @param item
	 */
	public void insertItem(StaticRoute item);
	
 
	
	/*********************** 查询 ************************/
	/**
	 * 根据GUID查询
	 * 
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryIPByGUID(String guid);
	
	/**
	 * 指定guid查询proxyIP
	 * @param guid
	 * @return
	 */
	public List<StaticRoute> queryProxyIPByGUID(String guid);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public StaticRoute queryIPByID(int id);

	/**
	 * 查询所有的item
	 * 
	 * @return
	 */
	public List<StaticRoute> queryAllItem();
	
	/**
	 * 指定guid查询所有匹配项
	 * @return
	 */
	public List<StaticRoute> queryAllItemByGUID(String guid);
	

	
	/*********************** 删除 ************************/
	/**
	 * 根据测点进行删除
	 * 
	 * @param guid
	 */
	public void delete(String guid);

	
	
	/*********************** 更新 ************************/
	/**
	 * 更新IP
	 * 
	 * @param item
	 */
	public void updateIP(StaticRoute item);
	
	/**
	 * 指定guid更新IP
	 * 
	 * @param item
	 */
	public void updateIPByGUID(StaticRoute item);

	/**
	 * 更新guid
	 * 
	 * @param item
	 */
	public void updateGUID(StaticRoute item);

	/**
	 * 更新代理IP
	 * 
	 * @param item
	 */
	public void updateProxyIP(StaticRoute item);

	/**
	 * 指定guid更新代理IP
	 * 
	 * @param item
	 */
	public void updateProxyIPByGUID(StaticRoute item);

}
