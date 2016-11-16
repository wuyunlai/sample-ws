package com.martin.learn.webservice.model;

public class ResultInfo {
	
	public static final ResultInfo SUCCESS = new ResultInfo("0","success");
	/**
	 * 调用结果码
	 */
	private String resultCode;
	/**
	 * 调用结果描述
	 */
	private String resultDesc;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	public ResultInfo(String resultCode, String resultDesc) {
		super();
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
	}
	public ResultInfo() {
		super();
	}
	
	
}
