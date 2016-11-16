package com.martin.learn.webservice.test;

import com.martin.learn.webservice.model.DataResponse;

public class AddResponse extends DataResponse<AddResultData>{
	   private AddResultData resultData;

	    public AddResultData getResultData() {
	        return resultData;
	    }

	    public void setResultData(AddResultData resultData) {
	        this.resultData = resultData;
	    }

}
