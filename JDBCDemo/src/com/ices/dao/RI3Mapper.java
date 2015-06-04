package com.ices.dao;

import java.util.List;

import com.ices.entity.RouteItem3;

/**
 * sqlite下的表router3增删改查接口类
 * @author corny
 *
 */
public interface RI3Mapper {

	/*********************** 插入************************/
	/**
	 * id自增的形式插入
	 * 
	 * @param item
	 */
	public void insertItem(RouteItem3 item);
	
	
	
	/***********************查询************************/
	/**
	 * 根据GUID查询
	 * @param guid
	 * @return
	 */
	public RouteItem3 queryIPByGUID(String guid);
	
	/**
	 * 根据GUID查询
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllIPByGUID(String guid);
	
	/**
	 * 查询下一跳GU的ip
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllNextIPByGUID(String guid);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public RouteItem3 queryIPByID(int id);
	
	/**
	 * 查询所有的item
	 * @return
	 */
	public List<RouteItem3> queryAllItem();
	
	/**
	 * 指定guid查询所有匹配项
	 * @param guid
	 * @return
	 */
	public List<RouteItem3> queryAllItemByGUID(String guid);
	
	
	/***********************删除************************/
	/**
	 * 根据测点进行删除
	 * @param guid
	 */
	public void delete(String guid);
	
	
	
	/***********************更新************************/
	/**
	 * 更新IP
	 * @param item
	 */
	public void updateIP(RouteItem3 item);
	
	/**
	 * 指定guid更新ip
	 * @param item
	 */
	public void updateIPByGUID(RouteItem3 item);
	
	/**
	 * 更新guid
	 * @param item
	 */
	public void updateGUID(RouteItem3 item);
	
	/**
	 * 更新nextIP
	 * @param item
	 */
	public void updateNextIP(RouteItem3 item);
	
	/**
	 * 指定guid更新nextIP
	 * @param item
	 */
	public void updateNextIPByGUID(RouteItem3 item);
	
}
