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
 * Provides alternative references for cohorts during interchange. Use XML IDREF to reference a course record that is included in the interchange
 * 
 * <p>Java class for CohortReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CohortReferenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ReferenceType">
 *       &lt;sequence>
 *         &lt;element name="CohortIdentity" type="{http://ed-fi.org/0100}CohortIdentityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CohortReferenceType", propOrder = {
    "cohortIdentity"
})
public class CohortReferenceType
    extends ReferenceType
{

    @XmlElement(name = "CohortIdentity")
    protected CohortIdentityType cohortIdentity;

    /**
     * Gets the value of the cohortIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link CohortIdentityType }
     *     
     */
    public CohortIdentityType getCohortIdentity() {
        return cohortIdentity;
    }

    /**
     * Sets the value of the cohortIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CohortIdentityType }
     *     
     */
    public void setCohortIdentity(CohortIdentityType value) {
        this.cohortIdentity = value;
    }

}
