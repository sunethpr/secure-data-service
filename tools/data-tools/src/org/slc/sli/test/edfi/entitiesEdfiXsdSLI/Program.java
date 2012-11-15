//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.15 at 05:29:39 PM EST 
//


package org.slc.sli.test.edfi.entitiesEdfiXsdSLI;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * This entity represents any program designed to work in conjunction with or to supplement the main academic program.  Programs may provide instruction, training, services or benefits through federal, state, or local agencies.  Programs may also include organized extracurricular activities for students.
 * 
 * 
 * <p>Java class for Program complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Program">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element name="ProgramId" type="{http://ed-fi.org/0100}ProgramId" minOccurs="0"/>
 *         &lt;element name="ProgramType" type="{http://ed-fi.org/0100}ProgramType"/>
 *         &lt;element name="ProgramSponsor" type="{http://ed-fi.org/0100}ProgramSponsorType" minOccurs="0"/>
 *         &lt;element name="Services" type="{http://ed-fi.org/0100}ServiceDescriptorType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Program", propOrder = {
    "programId",
    "programType",
    "programSponsor",
    "services"
})
@XmlSeeAlso({
    SLCProgram.class
})
public class Program
    extends ComplexObjectType
{

    @XmlElement(name = "ProgramId")
    protected String programId;
    @XmlElement(name = "ProgramType", required = true)
    protected ProgramType programType;
    @XmlElement(name = "ProgramSponsor")
    protected ProgramSponsorType programSponsor;
    @XmlElement(name = "Services")
    protected List<ServiceDescriptorType> services;

    /**
     * Gets the value of the programId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramId() {
        return programId;
    }

    /**
     * Sets the value of the programId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramId(String value) {
        this.programId = value;
    }

    /**
     * Gets the value of the programType property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramType }
     *     
     */
    public ProgramType getProgramType() {
        return programType;
    }

    /**
     * Sets the value of the programType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramType }
     *     
     */
    public void setProgramType(ProgramType value) {
        this.programType = value;
    }

    /**
     * Gets the value of the programSponsor property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramSponsorType }
     *     
     */
    public ProgramSponsorType getProgramSponsor() {
        return programSponsor;
    }

    /**
     * Sets the value of the programSponsor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramSponsorType }
     *     
     */
    public void setProgramSponsor(ProgramSponsorType value) {
        this.programSponsor = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the services property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceDescriptorType }
     * 
     * 
     */
    public List<ServiceDescriptorType> getServices() {
        if (services == null) {
            services = new ArrayList<ServiceDescriptorType>();
        }
        return this.services;
    }

}
