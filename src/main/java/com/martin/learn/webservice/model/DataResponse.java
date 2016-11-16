package com.martin.learn.webservice.model;


/**
 * 带结果集 的webservice响应
 * 子类须实现resultData的Getter/Setter方法，因此某些WebService框架不支持泛型
 * @author Administrator
 *
 */
public abstract class DataResponse<T> extends Response {


	/**
	 * 子类实现
	 * @param resultData
	 */
	public abstract  void setResultData(T resultData);
	
	
	
}
