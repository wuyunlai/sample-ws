package cn.wuyl.sample.ws.helloworld.test;

public class TestHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// //创建一个客户端服务对象
		cn.wuyl.sample.ws.helloworld.HelloWorld h = new cn.wuyl.sample.ws.helloworld.HelloWorldService().getHelloWorldPort();
		// 调用服务方法，并打印方法返回c值
		System.out.println(h.sayHello("大白"));
	}

}
