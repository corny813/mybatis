package com.ices.test;

import junit.framework.TestCase;

import com.ices.controller.RI3Controller;

public class RI3ControllerTest extends TestCase{

	private RI3Controller controller = new RI3Controller();
	
	public void openSessionTest(){
		controller.openSession();
	}
	
	public void insertItemTest(){
		controller.openSession();
		String ipPre = "222.222.222.";
		for(int i=0;i<1000;i++){
			if(i%3==0){
				controller.insertItem("gu1", ipPre+i);
			}else if(i%3==1){
				controller.insertItem("gu1.gu2", ipPre+i);
			}else{
				controller.insertItem("gu1.gu2.gu3", ipPre+i);
			}
		}
		controller.closeSession();
	}
	
	public void queryIPByIDTest(){
		controller.openSession();
		controller.queryById(1);
		controller.closeSession();
	}
	
	public void queryIPByGUIDTest(){
		controller.openSession();
		controller.queryIPByGUID("gu1.gu2.gu3");
		controller.closeSession();
	}
	
	public void queryAllIPByGUIDTest(){
		controller.openSession();
		controller.queryAllIPByGUID("gu1.gu2.gu3");
		controller.closeSession();
	}
	
	public void queryAllNextIPByGUIDTest(){
		controller.openSession();
		controller.queryAllNextIPByGUID("gu1.gu2.gu3");
		controller.closeSession();
	}
	
	public void updateIPTest(){
		controller.openSession();
		controller.updateIP("gu1.gu2.gu3", null, "222.222.222.22");
		controller.closeSession();
	}
	
	public void updateIPByGUIDTest(){
		controller.openSession();
		controller.updateIPByGUID("gu1.gu2.gu3", "222.222.2.2");
		controller.closeSession();
	}
	
	public void updateNextIPTest(){
		controller.openSession();
		controller.updateNextIP("gu1.gu2.gu3", "222.222.222.22", "2.2.2.2");
		controller.closeSession();
	}
	
	public void updateNextIPByGUIDTest(){
		controller.openSession();
		controller.updateNextIPByGUID("gu1.gu2.gu3", "2.2.2.2");
		controller.closeSession();
	}
	
	public void updateGUIDTest(){
		controller.openSession();
		controller.updateGUID("222.222.2.2", "2.2.2.2", "gu1.gu2");
		controller.closeSession();
	}
	
	public void queryAllItemByGUIDTest(){
		controller.openSession();
		controller.queryAllItemByGUID("gu1");
		controller.closeSession();
	}
	
}
