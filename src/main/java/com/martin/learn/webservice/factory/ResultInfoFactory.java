package com.martin.learn.webservice.factory;

import com.martin.learn.webservice.model.ResultInfo;

/**
 * 处理各种异常消息的工厂
 * @author Administrator
 *
 */
public interface ResultInfoFactory {
	/**
	 * 根据异常，创建调用结果
	 * @param e
	 * @return
	 */
	public  ResultInfo getResultInfo(Exception e);
}
