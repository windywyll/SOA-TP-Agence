
package soapservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.3
 * Tue Feb 11 10:51:55 CET 2014
 * Generated source version: 2.7.3
 */

@XmlRootElement(name = "getChosenVoyageResponse", namespace = "http://soapservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getChosenVoyageResponse", namespace = "http://soapservice/")

public class GetChosenVoyageResponse {

    @XmlElement(name = "return")
    private java.util.ArrayList<org.opensaml.xml.util.Pair<java.lang.String, java.lang.String>> _return;

    public java.util.ArrayList<org.opensaml.xml.util.Pair<java.lang.String, java.lang.String>> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.ArrayList<org.opensaml.xml.util.Pair<java.lang.String, java.lang.String>> new_return)  {
        this._return = new_return;
    }

}
