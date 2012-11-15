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
 * <p>Java class for GPAWeightedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GPAWeightedType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Unweighted"/>
 *     &lt;enumeration value="Weighted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GPAWeightedType")
@XmlEnum
public enum GPAWeightedType {

    @XmlEnumValue("Unweighted")
    UNWEIGHTED("Unweighted"),
    @XmlEnumValue("Weighted")
    WEIGHTED("Weighted");
    private final String value;

    GPAWeightedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GPAWeightedType fromValue(String v) {
        for (GPAWeightedType c: GPAWeightedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
