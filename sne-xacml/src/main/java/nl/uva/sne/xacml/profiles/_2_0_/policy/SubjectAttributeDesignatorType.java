//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.01 at 04:14:23 PM CEST 
//


package nl.uva.sne.xacml.profiles._2_0_.policy;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for SubjectAttributeDesignatorType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SubjectAttributeDesignatorType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:xacml:2.0:policy:schema:os}AttributeDesignatorType">
 *       &lt;attribute name="SubjectCategory" type="{http://www.w3.org/2001/XMLSchema}anyURI"
 * default="urn:oasis:names:tc:xacml:1.0:subject-category:access-subject" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectAttributeDesignatorType")
public class SubjectAttributeDesignatorType
        extends AttributeDesignatorType {

    @XmlAttribute(name = "SubjectCategory")
    @XmlSchemaType(name = "anyURI")
    protected String subjectCategory;

    /**
     * Gets the value of the subjectCategory property.
     *
     * @return possible object is {@link String }
     */
    public String getSubjectCategory() {
        if (subjectCategory == null) {
            return "urn:oasis:names:tc:xacml:1.0:subject-category:access-subject";
        } else {
            return subjectCategory;
        }
    }

    /**
     * Sets the value of the subjectCategory property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSubjectCategory(String value) {
        this.subjectCategory = value;
    }

}