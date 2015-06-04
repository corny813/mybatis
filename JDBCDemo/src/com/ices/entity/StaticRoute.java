package com.ices.entity;

/**
 * 静态路由规则配置表项
 * @author corny
 *
 */
public class StaticRoute{
	int id;
	
	String guid;	//
	String ip;		//
	String proxyIP;		//代理ip
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getProxyIP() {
		return proxyIP;
	}
	public void setProxyIP(String proxyIP) {
		this.proxyIP = proxyIP;
	}
}