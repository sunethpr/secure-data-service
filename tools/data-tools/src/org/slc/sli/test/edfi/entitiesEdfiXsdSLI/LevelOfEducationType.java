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
 * <p>Java class for LevelOfEducationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LevelOfEducationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="No Degree"/>
 *     &lt;enumeration value="Bachelor's"/>
 *     &lt;enumeration value="Master's"/>
 *     &lt;enumeration value="Doctorate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LevelOfEducationType")
@XmlEnum
public enum LevelOfEducationType {

    @XmlEnumValue("No Degree")
    NO_DEGREE("No Degree"),
    @XmlEnumValue("Bachelor's")
    BACHELOR_S("Bachelor's"),
    @XmlEnumValue("Master's")
    MASTER_S("Master's"),
    @XmlEnumValue("Doctorate")
    DOCTORATE("Doctorate");
    private final String value;

    LevelOfEducationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LevelOfEducationType fromValue(String v) {
        for (LevelOfEducationType c: LevelOfEducationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
