//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.02 at 11:44:08 AM CEST 
//


package oasis.names.tc.xacml._3_0.core.schema.wd_17;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DecisionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DecisionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Permit"/>
 *     &lt;enumeration value="Deny"/>
 *     &lt;enumeration value="Indeterminate"/>
 *     &lt;enumeration value="NotApplicable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DecisionType")
@XmlEnum
public enum DecisionType {

    @XmlEnumValue("Deny")
    DENY("Deny"),
    @XmlEnumValue("Indeterminate")
    INDETERMINATE("Indeterminate"),
    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable"),
    @XmlEnumValue("Permit")
    PERMIT("Permit");
    public static DecisionType fromValue(String v) {
        for (DecisionType c: DecisionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    private final String value;

    DecisionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

}
