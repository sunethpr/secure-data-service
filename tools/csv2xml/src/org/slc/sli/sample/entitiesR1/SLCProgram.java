//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.05 at 01:12:38 PM EST 
//


package org.slc.sli.sample.entitiesR1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Program record with key field: ProgramId. Made ProgramId a required field.
 * 
 * <p>Java class for SLC-Program complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-Program">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://ed-fi.org/0100}Program">
 *       &lt;sequence>
 *         &lt;element name="ProgramId" type="{http://ed-fi.org/0100}ProgramId"/>
 *         &lt;element name="ProgramType" type="{http://ed-fi.org/0100}ProgramType"/>
 *         &lt;element name="ProgramSponsor" type="{http://ed-fi.org/0100}ProgramSponsorType" minOccurs="0"/>
 *         &lt;element name="Services" type="{http://ed-fi.org/0100}ServiceDescriptorType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-Program")
public class SLCProgram
    extends Program
{


}
