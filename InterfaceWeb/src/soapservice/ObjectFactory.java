
package soapservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetChosenVoyageResponse_QNAME = new QName("http://soapservice/", "getChosenVoyageResponse");
    private final static QName _GetChosenVoyage_QNAME = new QName("http://soapservice/", "getChosenVoyage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetChosenVoyageResponse }
     * 
     */
    public GetChosenVoyageResponse createGetChosenVoyageResponse() {
        return new GetChosenVoyageResponse();
    }

    /**
     * Create an instance of {@link GetChosenVoyage }
     * 
     */
    public GetChosenVoyage createGetChosenVoyage() {
        return new GetChosenVoyage();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link Pair }
     * 
     */
    public Pair createPair() {
        return new Pair();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChosenVoyageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservice/", name = "getChosenVoyageResponse")
    public JAXBElement<GetChosenVoyageResponse> createGetChosenVoyageResponse(GetChosenVoyageResponse value) {
        return new JAXBElement<GetChosenVoyageResponse>(_GetChosenVoyageResponse_QNAME, GetChosenVoyageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetChosenVoyage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservice/", name = "getChosenVoyage")
    public JAXBElement<GetChosenVoyage> createGetChosenVoyage(GetChosenVoyage value) {
        return new JAXBElement<GetChosenVoyage>(_GetChosenVoyage_QNAME, GetChosenVoyage.class, null, value);
    }

}
