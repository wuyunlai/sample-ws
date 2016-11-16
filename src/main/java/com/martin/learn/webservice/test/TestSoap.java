package com.martin.learn.webservice.test;

public class TestSoap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AddRequest add = new AddRequest();
	        add.setAdd(1);
	        add.setAdded(2);
	        
	        Soap soap = new Soap();
	        AddResponse rsp =soap.add(add);
	        System.out.println(rsp.getResultData().getSum());
	    
	        System.out.println(rsp.getResultInfo().getResultCode());
	        System.out.println(rsp.getResultInfo().getResultDesc());
	}

}
