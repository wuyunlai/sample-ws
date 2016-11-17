package cn.wuyl.sample.ws.helloworld.cxf.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestEndpoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//3、第一个参数称为Binding即绑定地址，
		//第二个参数是实现者，即谁提供服务
		cn.wuyl.sample.ws.helloworld.cxf.HelloWorldImpl h = new cn.wuyl.sample.ws.helloworld.cxf.HelloWorldImpl();
		Endpoint.publish("http://localhost:80/cxfHelloWorld", h);

		cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorldImpl hs = new cn.wuyl.sample.ws.helloworld.cxf.server.HelloWorldImpl();
		Endpoint.publish("http://localhost:80/cxf", hs);
		
		//RESTFull---------------------------------------------------------------------------
        // 添加 ResourceClass
        List<Class<?>> resourceClassList = new ArrayList<Class<?>>();
        resourceClassList.add(cn.wuyl.sample.ws.helloworld.cxf.HelloWorldImpl.class);

        // 添加 ResourceProvider
        List<ResourceProvider> resourceProviderList = new ArrayList<ResourceProvider>();
        resourceProviderList.add(new SingletonResourceProvider(new cn.wuyl.sample.ws.helloworld.cxf.HelloWorldImpl()));

        // 添加 Provider
        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());

        // 发布 REST 服务
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setAddress("http://localhost:80/ws/rest");
        factory.setResourceClasses(resourceClassList);
        factory.setResourceProviders(resourceProviderList);
        factory.setProviders(providerList);
        factory.create();
        System.out.println("rest ws is published");
	}

}
