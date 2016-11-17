package cn.wuyl.sample.ws.helloworld.cxf;

import javax.jws.WebService;
import javax.jws.WebParam;

@WebService
public interface HelloWorld {
	public String sayHello(@WebParam(name="name") String name);
	public String sayGoodbye(@WebParam(name="name") String name);
}
