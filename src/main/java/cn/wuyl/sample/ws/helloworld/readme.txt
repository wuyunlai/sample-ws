首先，建立一个WebService。

package cn.xzj.ws;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
//使用jdk1.6.0_24以上版本
//1、添加注解
@WebService
public class HelloWorld {
    //2、至少包含一个可以对外公开的服务
 public String a(String name){
  return "屌丝"+name;
 }
 //3、第一个参数称为Binding即绑定地址，
 //第二个参数是实现者，即谁提供服务
 public static void main(String[] args) {
  HelloWorld h = new HelloWorld();
  Endpoint.publish("http://localhost:8014/hello", h);
  
 }
}
直接运行，jdk1.6会有信息，1.7为空，不报错就没有问题，表示启动WebService成功！

在浏览器访问http://localhost:8014/hello？wsdl,获得WebService说明书，看到如下

  <?xml version="1.0" encoding="UTF-8" ?> 
- <!--  Published by JAX-WS RI at http://jax-ws.dev.java.net. RI's version is JAX-WS RI 2.1.6 in JDK 6. 
  --> - <!--  Generated by JAX-WS RI at http://jax-ws.dev.java.net. RI's version is JAX-WS RI 2.1.6 in JDK 6.   --> - <definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://ws.xzj.cn/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://schemas.xmlsoap.org/wsdl/" targetNamespace="http://ws.xzj.cn/" name="HelloWorldService">- <types>- <xsd:schema>  <xsd:import namespace="http://ws.xzj.cn/" schemaLocation="http://localhost:8014/hello?xsd=1" />   </xsd:schema>  </types>- <message name="a">  <part name="parameters" element="tns:a" />   </message>- <message name="aResponse">  <part name="parameters" element="tns:aResponse" />   </message>- <portType name="HelloWorld">- <operation name="a">  <input message="tns:a" />   <output message="tns:aResponse" />   </operation>  </portType>- <binding name="HelloWorldPortBinding" type="tns:HelloWorld">  <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document" /> - <operation name="a">  <soap:operation soapAction="" /> - <input>  <soap:body use="literal" />   </input>- <output>  <soap:body use="literal" />   </output>  </operation>  </binding>- <service name="HelloWorldService">- <port name="HelloWorldPort" binding="tns:HelloWorldPortBinding">  <soap:address location="http://localhost:8014/hello" />   </port>  </service>  </definitions>
在Jdk的当前版本下,通过wsimport这个工具来生成远程调用的源代码

*****************************************************************************************************
*将cn.wuyl.sample.ws.helloworld.server中HelloWorld服务端代码拷贝到cn.wuyl.sample.ws.helloworld下启动，*
*然后生成客户端代码覆盖                                                                                                                                              *
*****************************************************************************************************

D:\>wsimport -s . http://localhost:8014/hello?wsdl
parsing WSDL...

generating code...

compiling code...

D:\>
在D盘就可以看到cn/xzj/ws生成的class文件和java文件，拷贝java文件到项目中。

 package cn.xzj.ws;
public class Test {
 public static void main(String[] args) {
  ////创建一个客户端服务对象 
  HelloWorld h = new HelloWorldService().getHelloWorldPort();
   //调用服务方法，并打印方法返回值 
  System.out.println(h.a("大白"));
 }
}
输出：屌丝大白。

 

注意： 

给类添加上@WebService注解后，类中所有的非静态方法都将对外公布。

不支持静态方法，final方法。

如果希望某个方法（非static,非final）不对外公开，可以在方法上添加

@WebMenthod(exclude=true),防止对外公开。

如果一个类上，被添加了@WebService注解，则此类必须至少有一个可公开的方法，否则将会启动失败。