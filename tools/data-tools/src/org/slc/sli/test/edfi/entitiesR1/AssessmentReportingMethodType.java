//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.17 at 02:49:01 PM EDT 
//


package org.slc.sli.test.edfi.entitiesR1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assessmentReportingMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="assessmentReportingMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Achievement/proficiency level"/>
 *     &lt;enumeration value="ACT score"/>
 *     &lt;enumeration value="Adaptive scale score"/>
 *     &lt;enumeration value="Age score"/>
 *     &lt;enumeration value="C-scaled scores"/>
 *     &lt;enumeration value="College Board examination scores"/>
 *     &lt;enumeration value="Composite Score"/>
 *     &lt;enumeration value="Composite Rating"/>
 *     &lt;enumeration value="Composition Score"/>
 *     &lt;enumeration value="Grade equivalent or grade-level indicator"/>
 *     &lt;enumeration value="Grade equivalent or grade-level indicator"/>
 *     &lt;enumeration value="Graduation score"/>
 *     &lt;enumeration value="Growth/value-added/indexing"/>
 *     &lt;enumeration value="International Baccalaureate score"/>
 *     &lt;enumeration value="Letter grade/mark"/>
 *     &lt;enumeration value="Mastery level"/>
 *     &lt;enumeration value="Normal curve equivalent"/>
 *     &lt;enumeration value="Normalized standard score"/>
 *     &lt;enumeration value="Number score"/>
 *     &lt;enumeration value="Pass-fail"/>
 *     &lt;enumeration value="Percentile"/>
 *     &lt;enumeration value="Percentile rank"/>
 *     &lt;enumeration value="Proficiency level"/>
 *     &lt;enumeration value="Promotion score"/>
 *     &lt;enumeration value="Ranking"/>
 *     &lt;enumeration value="Ratio IQ's"/>
 *     &lt;enumeration value="Raw score"/>
 *     &lt;enumeration value="Scale score"/>
 *     &lt;enumeration value="Standard age score"/>
 *     &lt;enumeration value="Standard error measurement"/>
 *     &lt;enumeration value="Stanine score"/>
 *     &lt;enumeration value="Sten score"/>
 *     &lt;enumeration value="Theta"/>
 *     &lt;enumeration value="T-score"/>
 *     &lt;enumeration value="Vertical score"/>
 *     &lt;enumeration value="Workplace readiness score"/>
 *     &lt;enumeration value="Z-score"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Not applicable"/>
 *     &lt;enumeration value="Quantile Measure"/>
 *     &lt;enumeration value="Lexile Measure"/>
 *     &lt;enumeration value="Vertical Scale Score"/>
 *     &lt;enumeration value="National College-Bound Percentile"/>
 *     &lt;enumeration value="State College-Bound Percentile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "assessmentReportingMethodType")
@XmlEnum
public enum AssessmentReportingMethodType {

    @XmlEnumValue("Achievement/proficiency level")
    ACHIEVEMENT_PROFICIENCY_LEVEL("Achievement/proficiency level"),
    @XmlEnumValue("ACT score")
    ACT_SCORE("ACT score"),
    @XmlEnumValue("Adaptive scale score")
    ADAPTIVE_SCALE_SCORE("Adaptive scale score"),
    @XmlEnumValue("Age score")
    AGE_SCORE("Age score"),
    @XmlEnumValue("C-scaled scores")
    C_SCALED_SCORES("C-scaled scores"),
    @XmlEnumValue("College Board examination scores")
    COLLEGE_BOARD_EXAMINATION_SCORES("College Board examination scores"),
    @XmlEnumValue("Composite Score")
    COMPOSITE_SCORE("Composite Score"),
    @XmlEnumValue("Composite Rating")
    COMPOSITE_RATING("Composite Rating"),
    @XmlEnumValue("Composition Score")
    COMPOSITION_SCORE("Composition Score"),
    @XmlEnumValue("Grade equivalent or grade-level indicator")
    GRADE_EQUIVALENT_OR_GRADE_LEVEL_INDICATOR("Grade equivalent or grade-level indicator"),
    @XmlEnumValue("Graduation score")
    GRADUATION_SCORE("Graduation score"),
    @XmlEnumValue("Growth/value-added/indexing")
    GROWTH_VALUE_ADDED_INDEXING("Growth/value-added/indexing"),
    @XmlEnumValue("International Baccalaureate score")
    INTERNATIONAL_BACCALAUREATE_SCORE("International Baccalaureate score"),
    @XmlEnumValue("Letter grade/mark")
    LETTER_GRADE_MARK("Letter grade/mark"),
    @XmlEnumValue("Mastery level")
    MASTERY_LEVEL("Mastery level"),
    @XmlEnumValue("Normal curve equivalent")
    NORMAL_CURVE_EQUIVALENT("Normal curve equivalent"),
    @XmlEnumValue("Normalized standard score")
    NORMALIZED_STANDARD_SCORE("Normalized standard score"),
    @XmlEnumValue("Number score")
    NUMBER_SCORE("Number score"),
    @XmlEnumValue("Pass-fail")
    PASS_FAIL("Pass-fail"),
    @XmlEnumValue("Percentile")
    PERCENTILE("Percentile"),
    @XmlEnumValue("Percentile rank")
    PERCENTILE_RANK("Percentile rank"),
    @XmlEnumValue("Proficiency level")
    PROFICIENCY_LEVEL("Proficiency level"),
    @XmlEnumValue("Promotion score")
    PROMOTION_SCORE("Promotion score"),
    @XmlEnumValue("Ranking")
    RANKING("Ranking"),
    @XmlEnumValue("Ratio IQ's")
    RATIO_IQ_S("Ratio IQ's"),
    @XmlEnumValue("Raw score")
    RAW_SCORE("Raw score"),
    @XmlEnumValue("Scale score")
    SCALE_SCORE("Scale score"),
    @XmlEnumValue("Standard age score")
    STANDARD_AGE_SCORE("Standard age score"),
    @XmlEnumValue("Standard error measurement")
    STANDARD_ERROR_MEASUREMENT("Standard error measurement"),
    @XmlEnumValue("Stanine score")
    STANINE_SCORE("Stanine score"),
    @XmlEnumValue("Sten score")
    STEN_SCORE("Sten score"),
    @XmlEnumValue("Theta")
    THETA("Theta"),
    @XmlEnumValue("T-score")
    T_SCORE("T-score"),
    @XmlEnumValue("Vertical score")
    VERTICAL_SCORE("Vertical score"),
    @XmlEnumValue("Workplace readiness score")
    WORKPLACE_READINESS_SCORE("Workplace readiness score"),
    @XmlEnumValue("Z-score")
    Z_SCORE("Z-score"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Not applicable")
    NOT_APPLICABLE("Not applicable"),
    @XmlEnumValue("Quantile Measure")
    QUANTILE_MEASURE("Quantile Measure"),
    @XmlEnumValue("Lexile Measure")
    LEXILE_MEASURE("Lexile Measure"),
    @XmlEnumValue("Vertical Scale Score")
    VERTICAL_SCALE_SCORE("Vertical Scale Score"),
    @XmlEnumValue("National College-Bound Percentile")
    NATIONAL_COLLEGE_BOUND_PERCENTILE("National College-Bound Percentile"),
    @XmlEnumValue("State College-Bound Percentile")
    STATE_COLLEGE_BOUND_PERCENTILE("State College-Bound Percentile");
    private final String value;

    AssessmentReportingMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssessmentReportingMethodType fromValue(String v) {
        for (AssessmentReportingMethodType c: AssessmentReportingMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
