//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.17 at 02:49:01 PM EDT 
//


package org.slc.sli.test.edfi.entitiesR1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A coding scheme that is used for identification and
 * 				record-keeping
 * 				purposes by schools, social services, or other
 * 				agencies to refer to staff
 * 				member.
 * 			
 * 
 * <p>Java class for staffIdentificationCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="staffIdentificationCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{}identificationCode"/>
 *         &lt;element name="identificationSystem" type="{}staffIdentificationSystemType"/>
 *         &lt;element name="assigningOrganizationCode" type="{}identificationCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "staffIdentificationCode", propOrder = {
    "id",
    "identificationSystem",
    "assigningOrganizationCode"
})
public class StaffIdentificationCode {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(required = true)
    protected StaffIdentificationSystemType identificationSystem;
    protected String assigningOrganizationCode;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the identificationSystem property.
     * 
     * @return
     *     possible object is
     *     {@link StaffIdentificationSystemType }
     *     
     */
    public StaffIdentificationSystemType getIdentificationSystem() {
        return identificationSystem;
    }

    /**
     * Sets the value of the identificationSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link StaffIdentificationSystemType }
     *     
     */
    public void setIdentificationSystem(StaffIdentificationSystemType value) {
        this.identificationSystem = value;
    }

    /**
     * Gets the value of the assigningOrganizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssigningOrganizationCode() {
        return assigningOrganizationCode;
    }

    /**
     * Sets the value of the assigningOrganizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssigningOrganizationCode(String value) {
        this.assigningOrganizationCode = value;
    }

}
