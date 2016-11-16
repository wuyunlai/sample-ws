package com.martin.learn.webservice.factory;

import com.martin.learn.webservice.model.ResultInfo;

/**
 * 处理各种异常消息的工厂
 * @author Administrator
 *
 */
public class DefaultResultInfoFactory implements ResultInfoFactory {

	public ResultInfo getResultInfo(Exception e) {
		return new ResultInfo("1",e.getMessage());
	}
	
}
