package com.martin.learn.webservice.template;
/**
 * ��WebserviceTemplate��ϣ�����Websevice����
 * @author Administrator
 *
 * @param <Req>
 * @param <Rsp>
 */
public interface ResultCallback<Req,Rsp> {

	void done() throws Exception;
	Rsp getRsp();
}
