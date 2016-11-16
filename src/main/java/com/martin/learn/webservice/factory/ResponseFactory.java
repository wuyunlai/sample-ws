package com.martin.learn.webservice.factory;

import com.martin.learn.webservice.model.DataResponse;
import com.martin.learn.webservice.model.Response;
import com.martin.learn.webservice.model.ResultData;
import com.martin.learn.webservice.model.ResultInfo;

/**
 * 响应工厂
 * @author Administrator
 *
 */
public class ResponseFactory {
	
	private ResultInfoFactory resultInfoFactory;
	
	
	
	
	public ResponseFactory(ResultInfoFactory resultInfoFactory) {
		super();
		this.resultInfoFactory = resultInfoFactory;
	}
	/**
	 * 调用webservice失败时，返回响应
	 * @param <Rsp>
	 * @param rsp
	 * @param e
	 * @return
	 */
	public <Rsp extends Response> Rsp getExceptionResponse(Rsp rsp,Exception e){

		rsp.setResultInfo(resultInfoFactory.getResultInfo(e));
		return rsp;
	}
	/**
	 * 调用成功，返回响应
	 * @param <Rsp>
	 * @param rsp
	 * @return
	 */
	public <Rsp extends Response> Rsp getSuccessResponse(Rsp rsp){
		
		rsp.setResultInfo(ResultInfo.SUCCESS);
		return rsp;
	}
	/**
	 * 调用成功，返回响应
	 * @param <Rsp>
	 * @param rsp
	 * @return
	 */
	public <Rsp extends DataResponse<Data>,Data extends ResultData> Rsp getSuccessResponse(Rsp rsp,Data data){
		
		rsp.setResultInfo(ResultInfo.SUCCESS);
		rsp.setResultData(data);
		return rsp;
	}
	
	
	
}
