package com.martin.learn.webservice.template;
/**
 * ��WebserviceTemplate��ϣ�����Websevice����,��Я����������ظ����÷�
 *
 * @param <Req>
 * @param <Rsp>
 * @param <Data>
 */
public interface ResultDataCallback<Req,Rsp,Data> {

	Data done() throws Exception;
	
	Rsp getRsp();
	
}
