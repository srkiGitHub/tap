package rs.vicko.tapws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceRefs;
import javax.xml.ws.WebServiceRef;

import rs.vicko.security.User;

@WebService
@WebServiceRefs({ @WebServiceRef(name = "tapWebService") })
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface TapWebService
{
	String sayHello(@WebParam(name = "name") String name);
	
	User getUserbyName(@WebParam(name = "name") String name);

}
