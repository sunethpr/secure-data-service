//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.22 at 01:42:02 PM EST 
//


package org.ed_fi._0100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Changed to use a required SLC identity type.
 * 
 * <p>Java class for SLC-SessionReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-SessionReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SessionIdentity" type="{http://ed-fi.org/0100}SLC-SessionIdentityType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-SessionReferenceType", propOrder = {
    "sessionIdentity"
})
public class SLCSessionReferenceType {

    @XmlElement(name = "SessionIdentity", required = true)
    protected SLCSessionIdentityType sessionIdentity;

    /**
     * Gets the value of the sessionIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link SLCSessionIdentityType }
     *     
     */
    public SLCSessionIdentityType getSessionIdentity() {
        return sessionIdentity;
    }

    /**
     * Sets the value of the sessionIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCSessionIdentityType }
     *     
     */
    public void setSessionIdentity(SLCSessionIdentityType value) {
        this.sessionIdentity = value;
    }

}
