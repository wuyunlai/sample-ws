package cn.wuyl.sample.ws.helloworld.cxf;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.jws.WebParam;

@WebService
public interface HelloWorld {
	@GET
	@Produces ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})  
    @Path("/hello/{name}")
	public String sayHello(@PathParam("name") String name);

	@GET
	@Produces ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})  
    @Path("/bye/{name}")
	public String sayGoodbye(@PathParam("name") String name);
}
