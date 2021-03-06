
package com.lo.apps.ws.client.entity.invoice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Handles sums in transaction.
 * 
 * <p>Java class for Sums complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sums">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="merchAndServiceSum">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,15}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rebateSum">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,15}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="taxSum">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,15}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sums", namespace = "http://localhost:8080/invoice/schema", propOrder = {
    "merchAndServiceSum",
    "rebateSum",
    "taxSum"
})
public class Sums {

    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal merchAndServiceSum;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal rebateSum;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal taxSum;

    /**
     * Gets the value of the merchAndServiceSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMerchAndServiceSum() {
        return merchAndServiceSum;
    }

    /**
     * Sets the value of the merchAndServiceSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMerchAndServiceSum(BigDecimal value) {
        this.merchAndServiceSum = value;
    }

    /**
     * Gets the value of the rebateSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRebateSum() {
        return rebateSum;
    }

    /**
     * Sets the value of the rebateSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRebateSum(BigDecimal value) {
        this.rebateSum = value;
    }

    /**
     * Gets the value of the taxSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxSum() {
        return taxSum;
    }

    /**
     * Sets the value of the taxSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxSum(BigDecimal value) {
        this.taxSum = value;
    }

}
