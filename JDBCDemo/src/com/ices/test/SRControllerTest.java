package com.ices.test;

import junit.framework.TestCase;

import com.ices.controller.SRController;

public class SRControllerTest extends TestCase{

private SRController controller = new SRController();
	
	public void openSessionTest(){
		controller.openSession();
	}
	
	public void insertItemTest(){
		controller.openSession();
		controller.insertItem("gu1", "222.221.220.2","222.221.220.3");
		controller.closeSession();
	}
	
	public void queryItemTest(){
		controller.openSession();
		controller.queryIPByGUID("gu1");
		controller.queryIPByGUID("gu2");
		
		controller.queryAllItem();
		
		controller.queryAllItemByGUID("gu1");
		controller.queryAllItemByGUID("gu2");
		
		controller.queryProxyIPByGUID("gu1");
		controller.queryProxyIPByGUID("gu2");
		
		controller.queryIPById(1);
		
		controller.queryIPByGUID("gu1");
		controller.queryIPByGUID("gu2");
		
		controller.closeSession();
	}
	
	public void updateTest(){
		String ip = "222.221.220.2";
		String proxyIP = "222.221.220.3";
		String newGUID = "gu3";
		controller.openSession();
		
		controller.updateGUID(ip, proxyIP, newGUID);
		
		controller.updateIP(newGUID, proxyIP, "222.221.220.4");
		controller.updateIPByGUID(newGUID, "2.2.2.2");
		
		controller.updateProxyIP(newGUID, "2.2.2.2", proxyIP+2);
		controller.updateProxyIPByGUID(newGUID, proxyIP+3);
		
		controller.closeSession();
	}
	
	
}
