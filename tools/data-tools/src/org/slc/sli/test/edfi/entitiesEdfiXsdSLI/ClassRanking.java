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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The academic rank information of a student in relation to his or her graduating class 
 * 
 * <p>Java class for ClassRanking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassRanking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClassRank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TotalNumberInClass" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PercentageRanking" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ClassRankingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassRanking", propOrder = {
    "classRank",
    "totalNumberInClass",
    "percentageRanking",
    "classRankingDate"
})
public class ClassRanking {

    @XmlElement(name = "ClassRank")
    protected int classRank;
    @XmlElement(name = "TotalNumberInClass")
    protected int totalNumberInClass;
    @XmlElement(name = "PercentageRanking")
    protected Integer percentageRanking;
    @XmlElement(name = "ClassRankingDate")
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected String classRankingDate;

    /**
     * Gets the value of the classRank property.
     * 
     */
    public int getClassRank() {
        return classRank;
    }

    /**
     * Sets the value of the classRank property.
     * 
     */
    public void setClassRank(int value) {
        this.classRank = value;
    }

    /**
     * Gets the value of the totalNumberInClass property.
     * 
     */
    public int getTotalNumberInClass() {
        return totalNumberInClass;
    }

    /**
     * Sets the value of the totalNumberInClass property.
     * 
     */
    public void setTotalNumberInClass(int value) {
        this.totalNumberInClass = value;
    }

    /**
     * Gets the value of the percentageRanking property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPercentageRanking() {
        return percentageRanking;
    }

    /**
     * Sets the value of the percentageRanking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPercentageRanking(Integer value) {
        this.percentageRanking = value;
    }

    /**
     * Gets the value of the classRankingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassRankingDate() {
        return classRankingDate;
    }

    /**
     * Sets the value of the classRankingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassRankingDate(String value) {
        this.classRankingDate = value;
    }

}
