package com.martin.learn.webservice.model;


/**
 * ������� ��webservice��Ӧ
 * ������ʵ��resultData��Getter/Setter���������ĳЩWebService��ܲ�֧�ַ���
 * @author Administrator
 *
 */
public abstract class DataResponse<T> extends Response {


	/**
	 * ����ʵ��
	 * @param resultData
	 */
	public abstract  void setResultData(T resultData);
	
	
	
}
