package com.martin.learn.webservice.template;

import com.martin.learn.webservice.factory.DefaultResultInfoFactory;
import com.martin.learn.webservice.factory.ResponseFactory;
import com.martin.learn.webservice.model.DataResponse;
import com.martin.learn.webservice.model.Response;
import com.martin.learn.webservice.model.ResultData;

public class WebServiceTemplate {
	
	private final static ResponseFactory factory = new ResponseFactory(new DefaultResultInfoFactory());
	/**
	 * 不带结果集的 webservice调用
	 * @param <Req>
	 * @param <Rsp>
	 * @param callback
	 * @return
	 */
	public static <Req, Rsp extends Response> Rsp doResult(
			ResultCallback<Req, Rsp> callback) {

		try {
			callback.done();
		} catch (Exception e) {
			return factory.getExceptionResponse(callback.getRsp(), e);
		}

		return factory.getSuccessResponse(callback.getRsp());

	}
	/**
	 * 带结果集的 webservice调用
	 * @param <Req>
	 * @param <Rsp>
	 * @param <Data>
	 * @param callback
	 * @return
	 */
	public static <Req, Rsp extends DataResponse<Data>, Data extends ResultData> Rsp doResult(
			ResultDataCallback<Req, Rsp, Data> callback) {

		Data data = null;
		try {
			data = callback.done();
		} catch (Exception e) {
			return factory.getExceptionResponse(callback.getRsp(), e);
		}
		return factory.getSuccessResponse(callback.getRsp(), data);

	}
}
