//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.05 at 01:12:38 PM EST 
//


package org.slc.sli.sample.entitiesR1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TermType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TermType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Fall Semester"/>
 *     &lt;enumeration value="Spring Semester"/>
 *     &lt;enumeration value="Summer Semester"/>
 *     &lt;enumeration value="First Trimester"/>
 *     &lt;enumeration value="Second Trimester"/>
 *     &lt;enumeration value="Third Trimester"/>
 *     &lt;enumeration value="Year Round"/>
 *     &lt;enumeration value="MiniTerm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TermType")
@XmlEnum
public enum TermType {

    @XmlEnumValue("Fall Semester")
    FALL_SEMESTER("Fall Semester"),
    @XmlEnumValue("Spring Semester")
    SPRING_SEMESTER("Spring Semester"),
    @XmlEnumValue("Summer Semester")
    SUMMER_SEMESTER("Summer Semester"),
    @XmlEnumValue("First Trimester")
    FIRST_TRIMESTER("First Trimester"),
    @XmlEnumValue("Second Trimester")
    SECOND_TRIMESTER("Second Trimester"),
    @XmlEnumValue("Third Trimester")
    THIRD_TRIMESTER("Third Trimester"),
    @XmlEnumValue("Year Round")
    YEAR_ROUND("Year Round"),
    @XmlEnumValue("MiniTerm")
    MINI_TERM("MiniTerm");
    private final String value;

    TermType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TermType fromValue(String v) {
        for (TermType c: TermType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
