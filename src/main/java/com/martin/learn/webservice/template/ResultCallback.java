package com.martin.learn.webservice.template;
/**
 * 与WebserviceTemplate配合，处理Websevice请求
 * @author Administrator
 *
 * @param <Req>
 * @param <Rsp>
 */
public interface ResultCallback<Req,Rsp> {

	void done() throws Exception;
	Rsp getRsp();
}
