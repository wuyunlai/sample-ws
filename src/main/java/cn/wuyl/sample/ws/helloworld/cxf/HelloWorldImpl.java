package cn.wuyl.sample.ws.helloworld.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.Endpoint;

@WebService(endpointInterface="cn.wuyl.sample.ws.helloworld.cxf.HelloWorld",serviceName="cxfHelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String sayHello(@WebParam(name="name") String name) {
		// TODO Auto-generated method stub
		return "Hello " + name;
	}

	public String sayGoodbye(@WebParam(name="name") String name) {
		// TODO Auto-generated method stub
		return "Bye " + name;
	}

}
