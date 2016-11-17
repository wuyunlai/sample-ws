package cn.wuyl.sample.ws.helloworld.cxf.test;

import javax.xml.ws.Endpoint;

import cn.wuyl.sample.ws.helloworld.cxf.HelloWorldImpl;
import junit.framework.Assert;

public class TestEndpoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//3、第一个参数称为Binding即绑定地址，
		//第二个参数是实现者，即谁提供服务
		cn.wuyl.sample.ws.helloworld.cxf.HelloWorldImpl h = new cn.wuyl.sample.ws.helloworld.cxf.HelloWorldImpl();
		Endpoint.publish("http://localhost:80/cxfHelloWorld", h);

		cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorldImpl hs = new cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorldImpl();
		Endpoint.publish("http://localhost:80/cxf", hs);
		
	}

}
