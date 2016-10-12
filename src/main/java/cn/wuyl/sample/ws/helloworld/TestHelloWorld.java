package cn.wuyl.sample.ws.helloworld;

public class TestHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// //创建一个客户端服务对象
		HelloWorld h = new HelloWorldService().getHelloWorldPort();
		// 调用服务方法，并打印方法返回c值
		System.out.println(h.sayHello("大白"));
	}

}
