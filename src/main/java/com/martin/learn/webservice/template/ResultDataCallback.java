package com.martin.learn.webservice.template;
/**
 * 与WebserviceTemplate配合，处理Websevice请求,并携带结果集返回给调用方
 *
 * @param <Req>
 * @param <Rsp>
 * @param <Data>
 */
public interface ResultDataCallback<Req,Rsp,Data> {

	Data done() throws Exception;
	
	Rsp getRsp();
	
}
