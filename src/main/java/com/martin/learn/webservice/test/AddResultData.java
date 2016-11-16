package com.martin.learn.webservice.test;

import com.martin.learn.webservice.model.ResultData;

public class AddResultData implements ResultData{
	   private int sum;

	    public AddResultData(int sum) {
	        super();
	        this.sum = sum;
	    }

	    public AddResultData() {
	        super();
	    }

	    public int getSum() {
	        return sum;
	    }

	    public void setSum(int sum) {
	        this.sum = sum;
	    }
}
