package com.martin.learn.webservice.factory;

import com.martin.learn.webservice.model.ResultInfo;

/**
 * ��������쳣��Ϣ�Ĺ���
 * @author Administrator
 *
 */
public interface ResultInfoFactory {
	/**
	 * �����쳣���������ý��
	 * @param e
	 * @return
	 */
	public  ResultInfo getResultInfo(Exception e);
}
