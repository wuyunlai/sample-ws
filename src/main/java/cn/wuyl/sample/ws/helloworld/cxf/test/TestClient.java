package cn.wuyl.sample.ws.helloworld.cxf.test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestClient {
    static String na = null;

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
        //输入名字
//        System.out.println("Please enter a name!");
//        Scanner scanner = new Scanner(System.in);
//        name=scanner.nextLine();
        
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld\t"+hw.sayHello(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld\t"+hw.sayGoodbye(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorld\t"+hws.sayHello(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorld\t"+hws.sayGoodbye(name));
        
        
        //RESTFull-------------------------------------------------------------------------------
        String baseAddress = "http://localhost:80/ws/rest";
        
        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());
        
        //通用的 WebClient 客户端
        String bz = WebClient.create(baseAddress, providerList)
			.path("/hello/"+name)
			.accept(MediaType.APPLICATION_JSON)
			.get(String.class);
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld WebClient\t"+bz);
        bz = WebClient.create(baseAddress, providerList)
			.path("/bye/"+name)
			.accept(MediaType.APPLICATION_JSON)
			.post(name,String.class);
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld WebClient\t"+bz);

        //JAX-RS 1.0 时代的客户端
        cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest = JAXRSClientFactory.create(baseAddress, cn.wuyl.sample.ws.helloworld.cxf.HelloWorld.class, providerList);
        //回调函数
//        InvocationCallback<String> callback = new InvocationCallback<String>() {
//        	public void completed(String response) {
//        		System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest\tn is"+na);
//        		na = response;
//        		System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest\tn is"+na);
//        	}
//        	public void failed(Throwable error) {
//        	}
//        };
//        WebClient.getConfig(rest).getRequestContext().put(InvocationCallback.class.getName(), callback);
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest\t"+rest.sayHello(name));
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest\t"+rest.sayGoodbye(name));
        
        //JAX-RS 2.0 时代的客户端
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.register(new JacksonJsonProvider()).target(baseAddress);;
        String rtn = target
            .path("/hello/"+name)
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);
        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest2.0\t"+rtn);
//post broken----------------------
//        rtn = target
//            .path("/bye/"+name)
//            .request(MediaType.APPLICATION_JSON)
//            .get(String.class);
//        System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest2.0\t"+rtn);
//post broken----------------------
        //Converting proxies to Web Clients and vice versa
        org.apache.cxf.jaxrs.client.Client c = WebClient.client(rest);
      WebClient httpClient = WebClient.fromClient(c);
      httpClient.path("/bye/"+name)
		.accept(MediaType.APPLICATION_JSON)
		.post(name,String.class);
      System.out.println("cn.wuyl.sample.ws.helloworld.cxf.HelloWorld rest2.0\t"+bz);
	}

}
