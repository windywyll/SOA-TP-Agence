package fr.voyage.soapbdd;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.3
 * 2014-02-11T11:18:02.199+01:00
 * Generated source version: 2.7.3
 * 
 */
@WebServiceClient(name = "RequestServerService", 
                  wsdlLocation = "http://localhost:8080/820SOAPVoyage/services/requestserver?wsdl",
                  targetNamespace = "http://soapservice/") 
public class RequestServerService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soapservice/", "RequestServerService");
    public final static QName RequestServerPort = new QName("http://soapservice/", "RequestServerPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/820SOAPVoyage/services/requestserver?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RequestServerService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/820SOAPVoyage/services/requestserver?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RequestServerService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RequestServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RequestServerService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RequestServerService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RequestServerService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public RequestServerService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns RequestServer
     */
    @WebEndpoint(name = "RequestServerPort")
    public RequestServer getRequestServerPort() {
        return super.getPort(RequestServerPort, RequestServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RequestServer
     */
    @WebEndpoint(name = "RequestServerPort")
    public RequestServer getRequestServerPort(WebServiceFeature... features) {
        return super.getPort(RequestServerPort, RequestServer.class, features);
    }

}
