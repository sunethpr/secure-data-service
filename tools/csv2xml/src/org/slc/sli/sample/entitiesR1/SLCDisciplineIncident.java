//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.05 at 01:12:38 PM EST 
//


package org.slc.sli.sample.entitiesR1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * DisciplineIncident record with key fields: IncidentIdentifier and SchoolReference. Changed types of SchoolReference and StaffReference to SLC reference types.
 * 
 * <p>Java class for SLC-DisciplineIncident complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-DisciplineIncident">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element name="IncidentIdentifier" type="{http://ed-fi.org/0100}IncidentIdentifier"/>
 *         &lt;element name="IncidentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="IncidentTime" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="IncidentLocation" type="{http://ed-fi.org/0100}IncidentLocationType"/>
 *         &lt;element name="ReporterDescription" type="{http://ed-fi.org/0100}ReporterDescriptionType" minOccurs="0"/>
 *         &lt;element name="ReporterName" type="{http://ed-fi.org/0100}ReporterName" minOccurs="0"/>
 *         &lt;element name="Behaviors" type="{http://ed-fi.org/0100}BehaviorDescriptorType" maxOccurs="unbounded"/>
 *         &lt;element name="SecondaryBehaviors" type="{http://ed-fi.org/0100}SecondaryBehavior" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Weapons" type="{http://ed-fi.org/0100}WeaponsType" minOccurs="0"/>
 *         &lt;element name="ReportedToLawEnforcement" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CaseNumber" type="{http://ed-fi.org/0100}CaseNumber" minOccurs="0"/>
 *         &lt;element name="SchoolReference" type="{http://ed-fi.org/0100}SLC-EducationalOrgReferenceType"/>
 *         &lt;element name="StaffReference" type="{http://ed-fi.org/0100}SLC-StaffReferenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-DisciplineIncident", propOrder = {
    "incidentIdentifier",
    "incidentDate",
    "incidentTime",
    "incidentLocation",
    "reporterDescription",
    "reporterName",
    "behaviors",
    "secondaryBehaviors",
    "weapons",
    "reportedToLawEnforcement",
    "caseNumber",
    "schoolReference",
    "staffReference"
})
public class SLCDisciplineIncident
    extends ComplexObjectType
{

    @XmlElement(name = "IncidentIdentifier", required = true)
    protected String incidentIdentifier;
    @XmlElement(name = "IncidentDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar incidentDate;
    @XmlElement(name = "IncidentTime", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar incidentTime;
    @XmlElement(name = "IncidentLocation", required = true)
    protected IncidentLocationType incidentLocation;
    @XmlElement(name = "ReporterDescription")
    protected ReporterDescriptionType reporterDescription;
    @XmlElement(name = "ReporterName")
    protected String reporterName;
    @XmlElement(name = "Behaviors", required = true)
    protected List<BehaviorDescriptorType> behaviors;
    @XmlElement(name = "SecondaryBehaviors")
    protected List<SecondaryBehavior> secondaryBehaviors;
    @XmlElement(name = "Weapons")
    protected WeaponsType weapons;
    @XmlElement(name = "ReportedToLawEnforcement")
    protected Boolean reportedToLawEnforcement;
    @XmlElement(name = "CaseNumber")
    protected String caseNumber;
    @XmlElement(name = "SchoolReference", required = true)
    protected SLCEducationalOrgReferenceType schoolReference;
    @XmlElement(name = "StaffReference")
    protected SLCStaffReferenceType staffReference;

    /**
     * Gets the value of the incidentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncidentIdentifier() {
        return incidentIdentifier;
    }

    /**
     * Sets the value of the incidentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncidentIdentifier(String value) {
        this.incidentIdentifier = value;
    }

    /**
     * Gets the value of the incidentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIncidentDate() {
        return incidentDate;
    }

    /**
     * Sets the value of the incidentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIncidentDate(XMLGregorianCalendar value) {
        this.incidentDate = value;
    }

    /**
     * Gets the value of the incidentTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIncidentTime() {
        return incidentTime;
    }

    /**
     * Sets the value of the incidentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIncidentTime(XMLGregorianCalendar value) {
        this.incidentTime = value;
    }

    /**
     * Gets the value of the incidentLocation property.
     * 
     * @return
     *     possible object is
     *     {@link IncidentLocationType }
     *     
     */
    public IncidentLocationType getIncidentLocation() {
        return incidentLocation;
    }

    /**
     * Sets the value of the incidentLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncidentLocationType }
     *     
     */
    public void setIncidentLocation(IncidentLocationType value) {
        this.incidentLocation = value;
    }

    /**
     * Gets the value of the reporterDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ReporterDescriptionType }
     *     
     */
    public ReporterDescriptionType getReporterDescription() {
        return reporterDescription;
    }

    /**
     * Sets the value of the reporterDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReporterDescriptionType }
     *     
     */
    public void setReporterDescription(ReporterDescriptionType value) {
        this.reporterDescription = value;
    }

    /**
     * Gets the value of the reporterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReporterName() {
        return reporterName;
    }

    /**
     * Sets the value of the reporterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReporterName(String value) {
        this.reporterName = value;
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

    /**
     * Gets the value of the weapons property.
     * 
     * @return
     *     possible object is
     *     {@link WeaponsType }
     *     
     */
    public WeaponsType getWeapons() {
        return weapons;
    }

    /**
     * Sets the value of the weapons property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaponsType }
     *     
     */
    public void setWeapons(WeaponsType value) {
        this.weapons = value;
    }

    /**
     * Gets the value of the reportedToLawEnforcement property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReportedToLawEnforcement() {
        return reportedToLawEnforcement;
    }

    /**
     * Sets the value of the reportedToLawEnforcement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReportedToLawEnforcement(Boolean value) {
        this.reportedToLawEnforcement = value;
    }

    /**
     * Gets the value of the caseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseNumber() {
        return caseNumber;
    }

    /**
     * Sets the value of the caseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseNumber(String value) {
        this.caseNumber = value;
    }

    /**
     * Gets the value of the schoolReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public SLCEducationalOrgReferenceType getSchoolReference() {
        return schoolReference;
    }

    /**
     * Sets the value of the schoolReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public void setSchoolReference(SLCEducationalOrgReferenceType value) {
        this.schoolReference = value;
    }

    /**
     * Gets the value of the staffReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCStaffReferenceType }
     *     
     */
    public SLCStaffReferenceType getStaffReference() {
        return staffReference;
    }

    /**
     * Sets the value of the staffReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCStaffReferenceType }
     *     
     */
    public void setStaffReference(SLCStaffReferenceType value) {
        this.staffReference = value;
    }

}
