package com.martin.learn.webservice.model;


/**
 * webservice��Ӧ
 * @author Administrator
 *
 */
public abstract class Response {

	private ResultInfo resultInfo;

	
	
	public ResultInfo getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(ResultInfo resultInfo) {
		this.resultInfo = resultInfo;
	}
	
	
}
