package com.martin.learn.webservice.test;

import com.martin.learn.webservice.model.Request;

public class AddRequest extends Request{
	 private int add;
	    private int added;
	    
	    public int getAdd() {
	        return add;
	    }
	    public void setAdd(int add) {
	        this.add = add;
	    }
	    public int getAdded() {
	        return added;
	    }
	    public void setAdded(int added) {
	        this.added = added;
	    }
}
