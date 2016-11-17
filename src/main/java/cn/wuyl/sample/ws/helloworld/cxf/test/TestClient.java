package cn.wuyl.sample.ws.helloworld.cxf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

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
        
        System.out.println("Please enter a name!");
        Scanner scanner = new Scanner(System.in);
        name=scanner.nextLine();
        
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld\t"+hw.sayHello(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld\t"+hw.sayGoodbye(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorld\t"+hws.sayHello(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorld\t"+hws.sayGoodbye(name));
        
        
        //RESTFull-------------------------------------------------------------------------------
        String baseAddress = "http://localhost:80/ws/rest";

        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());

        cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest = JAXRSClientFactory.create(baseAddress, cn.wuyl.sample.ws.helloworld.cxf.HelloWorld.class, providerList);
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest\t"+rest.sayHello(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest\t"+rest.sayGoodbye(name));
        
	}

}
