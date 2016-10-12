package cn.wuyl.sample.ws.helloworld.server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
//使用jdk1.6.0_24以上版本
//1、添加注解
@WebService
public class HelloWorld {

	public String sayHello(String name){
		return "Hello " + name;
	}
	
	public String sayGoodbye(String name){
		return "Bye " + name;
	}

	//3、第一个参数称为Binding即绑定地址，
	//第二个参数是实现者，即谁提供服务
	public static void main(String[] args) {
		HelloWorld h = new HelloWorld();
		Endpoint.publish("http://localhost:80/hello", h);
	}
}
