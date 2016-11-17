package cn.wuyl.sample.ws.helloworld.cxf.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(cn.wuyl.sample.ws.helloworld.cxf.HelloWorld.class);
        svr.setAddress("http://localhost:80/cxfHelloWorld");
        cn.wuyl.sample.ws.helloworld.cxf.HelloWorld hw = (cn.wuyl.sample.ws.helloworld.cxf.HelloWorld) svr.create();
        JaxWsProxyFactoryBean svrs = new JaxWsProxyFactoryBean();
        svrs.setServiceClass(cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorld.class);
        svrs.setAddress("http://localhost:80/cxf");
        cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorld hws = (cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorld) svrs.create();
        String name = "吴运来";
        System.out.println(hw.sayHello(name));
        System.out.println(hw.sayGoodbye(name));
        System.out.println(hws.sayHello(name));
        System.out.println(hws.sayGoodbye(name));
	}

}
