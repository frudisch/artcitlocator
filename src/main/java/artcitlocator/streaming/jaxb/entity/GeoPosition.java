//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.11 at 11:27:29 PM CET 
//


package artcitlocator.streaming.jaxb.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoPosition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoPosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xCoord" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="yCoord" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoPosition", propOrder = {
    "xCoord",
    "yCoord"
})
public class GeoPosition {

    protected double xCoord;
    protected double yCoord;
    @XmlAttribute(name = "id")
    protected Integer id;

    /**
     * Gets the value of the xCoord property.
     * 
     */
    public double getXCoord() {
        return xCoord;
    }

    /**
     * Sets the value of the xCoord property.
     * 
     */
    public void setXCoord(double value) {
        this.xCoord = value;
    }

    /**
     * Gets the value of the yCoord property.
     * 
     */
    public double getYCoord() {
        return yCoord;
    }

    /**
     * Sets the value of the yCoord property.
     * 
     */
    public void setYCoord(double value) {
        this.yCoord = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

}
