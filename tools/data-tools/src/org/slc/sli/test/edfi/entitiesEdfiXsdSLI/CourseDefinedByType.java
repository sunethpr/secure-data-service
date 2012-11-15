//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.15 at 05:29:39 PM EST 
//


package org.slc.sli.test.edfi.entitiesEdfiXsdSLI;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CourseDefinedByType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CourseDefinedByType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="LEA"/>
 *     &lt;enumeration value="National Organization"/>
 *     &lt;enumeration value="SEA"/>
 *     &lt;enumeration value="School"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CourseDefinedByType")
@XmlEnum
public enum CourseDefinedByType {

    LEA("LEA"),
    @XmlEnumValue("National Organization")
    NATIONAL_ORGANIZATION("National Organization"),
    SEA("SEA"),
    @XmlEnumValue("School")
    SCHOOL("School");
    private final String value;

    CourseDefinedByType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CourseDefinedByType fromValue(String v) {
        for (CourseDefinedByType c: CourseDefinedByType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
