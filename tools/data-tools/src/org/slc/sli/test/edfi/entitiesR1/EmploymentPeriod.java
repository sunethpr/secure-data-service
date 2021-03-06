//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.31 at 10:43:34 AM EDT 
//


package org.slc.sli.test.edfi.entitiesR1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The set of elements defining and characterizing a
 *                 person's period of
 *                 employment including start and end dates and the
 *                 type and reason for
 *                 separation.
 *             
 * 
 * <p>Java class for employmentPeriod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="employmentPeriod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hireDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="separation" type="{http://slc-sli/ed-org/0.1}separationType" minOccurs="0"/>
 *         &lt;element name="separationReason" type="{http://slc-sli/ed-org/0.1}separationReasonType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employmentPeriod", propOrder = {
    "hireDate",
    "endDate",
    "separation",
    "separationReason"
})
public class EmploymentPeriod {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected String hireDate;
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected String endDate;
    protected SeparationType separation;
    protected SeparationReasonType separationReason;

    /**
     * Gets the value of the hireDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHireDate() {
        return hireDate;
    }

    /**
     * Sets the value of the hireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHireDate(String value) {
        this.hireDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the separation property.
     * 
     * @return
     *     possible object is
     *     {@link SeparationType }
     *     
     */
    public SeparationType getSeparation() {
        return separation;
    }

    /**
     * Sets the value of the separation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeparationType }
     *     
     */
    public void setSeparation(SeparationType value) {
        this.separation = value;
    }

    /**
     * Gets the value of the separationReason property.
     * 
     * @return
     *     possible object is
     *     {@link SeparationReasonType }
     *     
     */
    public SeparationReasonType getSeparationReason() {
        return separationReason;
    }

    /**
     * Sets the value of the separationReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeparationReasonType }
     *     
     */
    public void setSeparationReason(SeparationReasonType value) {
        this.separationReason = value;
    }

}
