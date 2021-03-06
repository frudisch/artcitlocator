//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.12 at 12:20:41 AM CET 
//


package artcitlocator.streaming.configuration.jaxb.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Twitter" type="{http://tempuri.org/po.xsd}TwitterAccount"/>
 *         &lt;element name="RMI" type="{http://tempuri.org/po.xsd}RMI_Information"/>
 *         &lt;sequence>
 *           &lt;element name="RMIPlugIns" type="{http://tempuri.org/po.xsd}RMI_Information" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="WaitTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "twitter",
    "rmi",
    "rmiPlugIns",
    "waitTime"
})
@XmlRootElement(name = "TwitterRoot")
public class TwitterRoot {

    @XmlElement(name = "Twitter", required = true)
    protected TwitterAccount twitter;
    @XmlElement(name = "RMI", required = true)
    protected RMIInformation rmi;
    @XmlElement(name = "RMIPlugIns")
    protected List<RMIInformation> rmiPlugIns;
    @XmlElement(name = "WaitTime")
    protected int waitTime;

    /**
     * Gets the value of the twitter property.
     * 
     * @return
     *     possible object is
     *     {@link TwitterAccount }
     *     
     */
    public TwitterAccount getTwitter() {
        return twitter;
    }

    /**
     * Sets the value of the twitter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TwitterAccount }
     *     
     */
    public void setTwitter(TwitterAccount value) {
        this.twitter = value;
    }

    /**
     * Gets the value of the rmi property.
     * 
     * @return
     *     possible object is
     *     {@link RMIInformation }
     *     
     */
    public RMIInformation getRMI() {
        return rmi;
    }

    /**
     * Sets the value of the rmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link RMIInformation }
     *     
     */
    public void setRMI(RMIInformation value) {
        this.rmi = value;
    }

    /**
     * Gets the value of the rmiPlugIns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rmiPlugIns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRMIPlugIns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RMIInformation }
     * 
     * 
     */
    public List<RMIInformation> getRMIPlugIns() {
        if (rmiPlugIns == null) {
            rmiPlugIns = new ArrayList<RMIInformation>();
        }
        return this.rmiPlugIns;
    }

    /**
     * Gets the value of the waitTime property.
     * 
     */
    public int getWaitTime() {
        return waitTime;
    }

    /**
     * Sets the value of the waitTime property.
     * 
     */
    public void setWaitTime(int value) {
        this.waitTime = value;
    }

}
