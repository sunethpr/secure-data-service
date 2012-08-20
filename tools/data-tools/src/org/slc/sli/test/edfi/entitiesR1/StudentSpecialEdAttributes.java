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
 * Special Education attributes of a Student.
 *             
 * 
 * <p>Java class for studentSpecialEdAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentSpecialEdAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ideaEligibility" type="{}ideaEligibilityType"/>
 *         &lt;element name="multiplyDisabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="medicallyFragile" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentSpecialEdAttributes", propOrder = {
    "ideaEligibility",
    "multiplyDisabled",
    "medicallyFragile"
})
public class StudentSpecialEdAttributes {

    @XmlElement(required = true)
    protected IdeaEligibilityType ideaEligibility;
    protected Boolean multiplyDisabled;
    protected Boolean medicallyFragile;

    /**
     * Gets the value of the ideaEligibility property.
     * 
     * @return
     *     possible object is
     *     {@link IdeaEligibilityType }
     *     
     */
    public IdeaEligibilityType getIdeaEligibility() {
        return ideaEligibility;
    }

    /**
     * Sets the value of the ideaEligibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdeaEligibilityType }
     *     
     */
    public void setIdeaEligibility(IdeaEligibilityType value) {
        this.ideaEligibility = value;
    }

    /**
     * Gets the value of the multiplyDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultiplyDisabled() {
        return multiplyDisabled;
    }

    /**
     * Sets the value of the multiplyDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultiplyDisabled(Boolean value) {
        this.multiplyDisabled = value;
    }

    /**
     * Gets the value of the medicallyFragile property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMedicallyFragile() {
        return medicallyFragile;
    }

    /**
     * Sets the value of the medicallyFragile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMedicallyFragile(Boolean value) {
        this.medicallyFragile = value;
    }

}
