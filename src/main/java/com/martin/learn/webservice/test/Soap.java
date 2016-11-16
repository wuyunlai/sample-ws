package com.martin.learn.webservice.test;

import com.martin.learn.webservice.template.ResultDataCallback;
import com.martin.learn.webservice.template.WebServiceTemplate;

public class Soap {
	   public AddResponse add(final AddRequest request){
	        return WebServiceTemplate.doResult(new ResultDataCallback<AddRequest,AddResponse,AddResultData>(){

	            public AddResultData done() throws Exception {
	                return new AddResultData(request.getAdd()+request.getAdded());
	            }

	            public AddResponse getRsp() {
	                return new AddResponse();
	            }

	        });
	    }

}
