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
 * This entity represents the student's response to an assessment item and the item-level scores such as correct, incorrect, or met standard. 
 * 
 * 
 * <p>Java class for SLC-StudentAssessmentItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-StudentAssessmentItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element name="AssessmentResponse" type="{http://ed-fi.org/0100}AssessmentResponse" minOccurs="0"/>
 *         &lt;element name="ResponseIndicator" type="{http://ed-fi.org/0100}ResponseIndicatorType" minOccurs="0"/>
 *         &lt;element name="AssessmentItemResult" type="{http://ed-fi.org/0100}AssessmentItemResultType"/>
 *         &lt;element name="RawScoreResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StudentAssessmentReference" type="{http://ed-fi.org/0100}SLC-StudentAssessmentReferenceType" minOccurs="0"/>
 *         &lt;element name="StudentObjectiveAssessmentReference" type="{http://ed-fi.org/0100}SLC-StudentObjectiveAssessmentReferenceType" minOccurs="0"/>
 *         &lt;element name="AssessmentItemReference" type="{http://ed-fi.org/0100}SLC-AssessmentItemReferenceType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-StudentAssessmentItem", propOrder = {
    "assessmentResponse",
    "responseIndicator",
    "assessmentItemResult",
    "rawScoreResult",
    "studentAssessmentReference",
    "studentObjectiveAssessmentReference",
    "assessmentItemReference"
})
public class SLCStudentAssessmentItem
    extends ComplexObjectType
{

    @XmlElement(name = "AssessmentResponse")
    protected String assessmentResponse;
    @XmlElement(name = "ResponseIndicator")
    protected ResponseIndicatorType responseIndicator;
    @XmlElement(name = "AssessmentItemResult", required = true)
    protected AssessmentItemResultType assessmentItemResult;
    @XmlElement(name = "RawScoreResult")
    protected Integer rawScoreResult;
    @XmlElement(name = "StudentAssessmentReference")
    protected SLCStudentAssessmentReferenceType studentAssessmentReference;
    @XmlElement(name = "StudentObjectiveAssessmentReference")
    protected SLCStudentObjectiveAssessmentReferenceType studentObjectiveAssessmentReference;
    @XmlElement(name = "AssessmentItemReference", required = true)
    protected SLCAssessmentItemReferenceType assessmentItemReference;

    /**
     * Gets the value of the assessmentResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssessmentResponse() {
        return assessmentResponse;
    }

    /**
     * Sets the value of the assessmentResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssessmentResponse(String value) {
        this.assessmentResponse = value;
    }

    /**
     * Gets the value of the responseIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseIndicatorType }
     *     
     */
    public ResponseIndicatorType getResponseIndicator() {
        return responseIndicator;
    }

    /**
     * Sets the value of the responseIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseIndicatorType }
     *     
     */
    public void setResponseIndicator(ResponseIndicatorType value) {
        this.responseIndicator = value;
    }

    /**
     * Gets the value of the assessmentItemResult property.
     * 
     * @return
     *     possible object is
     *     {@link AssessmentItemResultType }
     *     
     */
    public AssessmentItemResultType getAssessmentItemResult() {
        return assessmentItemResult;
    }

    /**
     * Sets the value of the assessmentItemResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssessmentItemResultType }
     *     
     */
    public void setAssessmentItemResult(AssessmentItemResultType value) {
        this.assessmentItemResult = value;
    }

    /**
     * Gets the value of the rawScoreResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRawScoreResult() {
        return rawScoreResult;
    }

    /**
     * Sets the value of the rawScoreResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRawScoreResult(Integer value) {
        this.rawScoreResult = value;
    }

    /**
     * Gets the value of the studentAssessmentReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCStudentAssessmentReferenceType }
     *     
     */
    public SLCStudentAssessmentReferenceType getStudentAssessmentReference() {
        return studentAssessmentReference;
    }

    /**
     * Sets the value of the studentAssessmentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCStudentAssessmentReferenceType }
     *     
     */
    public void setStudentAssessmentReference(SLCStudentAssessmentReferenceType value) {
        this.studentAssessmentReference = value;
    }

    /**
     * Gets the value of the studentObjectiveAssessmentReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCStudentObjectiveAssessmentReferenceType }
     *     
     */
    public SLCStudentObjectiveAssessmentReferenceType getStudentObjectiveAssessmentReference() {
        return studentObjectiveAssessmentReference;
    }

    /**
     * Sets the value of the studentObjectiveAssessmentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCStudentObjectiveAssessmentReferenceType }
     *     
     */
    public void setStudentObjectiveAssessmentReference(SLCStudentObjectiveAssessmentReferenceType value) {
        this.studentObjectiveAssessmentReference = value;
    }

    /**
     * Gets the value of the assessmentItemReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCAssessmentItemReferenceType }
     *     
     */
    public SLCAssessmentItemReferenceType getAssessmentItemReference() {
        return assessmentItemReference;
    }

    /**
     * Sets the value of the assessmentItemReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCAssessmentItemReferenceType }
     *     
     */
    public void setAssessmentItemReference(SLCAssessmentItemReferenceType value) {
        this.assessmentItemReference = value;
    }

}
