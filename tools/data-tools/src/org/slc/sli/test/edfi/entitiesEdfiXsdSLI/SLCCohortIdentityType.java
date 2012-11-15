//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.15 at 05:29:39 PM EST 
//


package org.slc.sli.test.edfi.entitiesEdfiXsdSLI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Encapsulates the possible attributes that can be used to lookup the identity of cohorts.
 * 
 * <p>Java class for SLC-CohortIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-CohortIdentityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CohortIdentifier" type="{http://ed-fi.org/0100}CohortIdentifier"/>
 *         &lt;element name="EducationalOrgReference" type="{http://ed-fi.org/0100}SLC-EducationalOrgReferenceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-CohortIdentityType", propOrder = {
    "cohortIdentifier",
    "educationalOrgReference"
})
public class SLCCohortIdentityType {

    @XmlElement(name = "CohortIdentifier", required = true)
    protected String cohortIdentifier;
    @XmlElement(name = "EducationalOrgReference", required = true)
    protected SLCEducationalOrgReferenceType educationalOrgReference;

    /**
     * Gets the value of the cohortIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCohortIdentifier() {
        return cohortIdentifier;
    }

    /**
     * Sets the value of the cohortIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCohortIdentifier(String value) {
        this.cohortIdentifier = value;
    }

    /**
     * Gets the value of the educationalOrgReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public SLCEducationalOrgReferenceType getEducationalOrgReference() {
        return educationalOrgReference;
    }

    /**
     * Sets the value of the educationalOrgReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public void setEducationalOrgReference(SLCEducationalOrgReferenceType value) {
        this.educationalOrgReference = value;
    }

}
