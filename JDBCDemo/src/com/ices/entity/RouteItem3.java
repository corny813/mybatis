package com.ices.entity;

/**
 * GUID��ʽ��·�ɱ���
 * @author corny
 *
 */
public class RouteItem3 {

	int id;
	
	String guid;	//��һ��GU
	String ip;		//��һ��GU��ip
	String nextIP;	//��һ��GU��ip
	
	int cost;	//������

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
