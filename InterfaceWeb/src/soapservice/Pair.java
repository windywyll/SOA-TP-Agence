
package soapservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour pair complex type.
 * 
 * <p>Le fragment de sch\u00e9ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="pair">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="first" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="second" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pair", propOrder = {
    "first",
    "second"
})
public class Pair {

    protected Object first;
    protected Object second;

    /**
     * Obtient la valeur de la propri\u00e9t\u00e9 first.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFirst() {
        return first;
    }

    /**
     * D\u00e9finit la valeur de la propri\u00e9t\u00e9 first.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFirst(Object value) {
        this.first = value;
    }

    /**
     * Obtient la valeur de la propri\u00e9t\u00e9 second.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSecond() {
        return second;
    }

    /**
     * D\u00e9finit la valeur de la propri\u00e9t\u00e9 second.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSecond(Object value) {
        this.second = value;
    }

}
