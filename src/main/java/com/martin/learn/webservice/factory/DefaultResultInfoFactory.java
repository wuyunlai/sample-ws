package com.martin.learn.webservice.factory;

import com.martin.learn.webservice.model.ResultInfo;

/**
 * ��������쳣��Ϣ�Ĺ���
 * @author Administrator
 *
 */
public class DefaultResultInfoFactory implements ResultInfoFactory {

	public ResultInfo getResultInfo(Exception e) {
		return new ResultInfo("1",e.getMessage());
	}
	
}
