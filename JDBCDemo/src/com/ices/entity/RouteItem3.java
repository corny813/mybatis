package com.ices.entity;

/**
 * GUID方式的路由表项
 * @author corny
 *
 */
public class RouteItem3 {

	int id;
	
	String guid;	//下一级GU
	String ip;		//下一级GU的ip
	String nextIP;	//下一跳GU的ip
	
	int cost;	//保留项

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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getNextIP() {
		return nextIP;
	}

	public void setNextIP(String nextIP) {
		this.nextIP = nextIP;
	}
}
