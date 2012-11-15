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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SLC-StudentDisciplineIncidentAssociation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-StudentDisciplineIncidentAssociation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element name="StudentReference" type="{http://ed-fi.org/0100}SLC-StudentReferenceType"/>
 *         &lt;element name="DisciplineIncidentReference" type="{http://ed-fi.org/0100}SLC-DisciplineIncidentReferenceType"/>
 *         &lt;element name="StudentParticipationCode" type="{http://ed-fi.org/0100}StudentParticipationCodeType"/>
 *         &lt;element name="Behaviors" type="{http://ed-fi.org/0100}BehaviorDescriptorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SecondaryBehaviors" type="{http://ed-fi.org/0100}SecondaryBehavior" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-StudentDisciplineIncidentAssociation", propOrder = {
    "studentReference",
    "disciplineIncidentReference",
    "studentParticipationCode",
    "behaviors",
    "secondaryBehaviors"
})
public class SLCStudentDisciplineIncidentAssociation
    extends ComplexObjectType
{

    @XmlElement(name = "StudentReference", required = true)
    protected SLCStudentReferenceType studentReference;
    @XmlElement(name = "DisciplineIncidentReference", required = true)
    protected SLCDisciplineIncidentReferenceType disciplineIncidentReference;
    @XmlElement(name = "StudentParticipationCode", required = true)
    protected StudentParticipationCodeType studentParticipationCode;
    @XmlElement(name = "Behaviors")
    protected List<BehaviorDescriptorType> behaviors;
    @XmlElement(name = "SecondaryBehaviors")
    protected List<SecondaryBehavior> secondaryBehaviors;

    /**
     * Gets the value of the studentReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCStudentReferenceType }
     *     
     */
    public SLCStudentReferenceType getStudentReference() {
        return studentReference;
    }

    /**
     * Sets the value of the studentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCStudentReferenceType }
     *     
     */
    public void setStudentReference(SLCStudentReferenceType value) {
        this.studentReference = value;
    }

    /**
     * Gets the value of the disciplineIncidentReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCDisciplineIncidentReferenceType }
     *     
     */
    public SLCDisciplineIncidentReferenceType getDisciplineIncidentReference() {
        return disciplineIncidentReference;
    }

    /**
     * Sets the value of the disciplineIncidentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCDisciplineIncidentReferenceType }
     *     
     */
    public void setDisciplineIncidentReference(SLCDisciplineIncidentReferenceType value) {
        this.disciplineIncidentReference = value;
    }

    /**
     * Gets the value of the studentParticipationCode property.
     * 
     * @return
     *     possible object is
     *     {@link StudentParticipationCodeType }
     *     
     */
    public StudentParticipationCodeType getStudentParticipationCode() {
        return studentParticipationCode;
    }

    /**
     * Sets the value of the studentParticipationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentParticipationCodeType }
     *     
     */
    public void setStudentParticipationCode(StudentParticipationCodeType value) {
        this.studentParticipationCode = value;
    }

    /**
     * Gets the value of the behaviors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the behaviors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBehaviors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BehaviorDescriptorType }
     * 
     * 
     */
    public List<BehaviorDescriptorType> getBehaviors() {
        if (behaviors == null) {
            behaviors = new ArrayList<BehaviorDescriptorType>();
        }
        return this.behaviors;
    }

    /**
     * Gets the value of the secondaryBehaviors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the secondaryBehaviors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecondaryBehaviors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecondaryBehavior }
     * 
     * 
     */
    public List<SecondaryBehavior> getSecondaryBehaviors() {
        if (secondaryBehaviors == null) {
            secondaryBehaviors = new ArrayList<SecondaryBehavior>();
        }
        return this.secondaryBehaviors;
    }

}
