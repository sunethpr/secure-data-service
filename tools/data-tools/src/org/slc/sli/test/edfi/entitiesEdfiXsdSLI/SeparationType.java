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
 * <p>Java class for SeparationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SeparationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Voluntary separation"/>
 *     &lt;enumeration value="Involuntary separation"/>
 *     &lt;enumeration value="Mutual agreement"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SeparationType")
@XmlEnum
public enum SeparationType {

    @XmlEnumValue("Voluntary separation")
    VOLUNTARY_SEPARATION("Voluntary separation"),
    @XmlEnumValue("Involuntary separation")
    INVOLUNTARY_SEPARATION("Involuntary separation"),
    @XmlEnumValue("Mutual agreement")
    MUTUAL_AGREEMENT("Mutual agreement"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    SeparationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SeparationType fromValue(String v) {
        for (SeparationType c: SeparationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
