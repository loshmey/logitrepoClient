
package com.lo.apps.ws.client.entity.invoice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Invoice record containing information about merch name, amount, quantity, prices...
 * 
 * <p>Java class for InvoiceRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordNumber">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;pattern value="\d{1,3}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="merchOrServiceName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="120"/>
 *               &lt;pattern value="[a-zA-Z]{0,120}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="amount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,10}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="unitOfIssue">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="6"/>
 *               &lt;pattern value="[a-zA-Z]{0,6}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="unitPrice">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,10}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="value">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,12}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rebatePercentage">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,5}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rebateAmount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,12}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="rebateDeducted">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,12}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="taxTotal">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,12}.{0,1}\d{2}"/>
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
@XmlType(name = "InvoiceRecord", namespace = "http://localhost:8080/invoice/schema", propOrder = {
    "recordNumber",
    "merchOrServiceName",
    "amount",
    "unitOfIssue",
    "unitPrice",
    "value",
    "rebatePercentage",
    "rebateAmount",
    "rebateDeducted",
    "taxTotal"
})
public class InvoiceRecord {

    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected String recordNumber;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected String merchOrServiceName;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal amount;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected String unitOfIssue;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal unitPrice;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal value;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal rebatePercentage;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal rebateAmount;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal rebateDeducted;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal taxTotal;

    /**
     * Gets the value of the recordNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordNumber() {
        return recordNumber;
    }

    /**
     * Sets the value of the recordNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordNumber(String value) {
        this.recordNumber = value;
    }

    /**
     * Gets the value of the merchOrServiceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchOrServiceName() {
        return merchOrServiceName;
    }

    /**
     * Sets the value of the merchOrServiceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchOrServiceName(String value) {
        this.merchOrServiceName = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the unitOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfIssue() {
        return unitOfIssue;
    }

    /**
     * Sets the value of the unitOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfIssue(String value) {
        this.unitOfIssue = value;
    }

    /**
     * Gets the value of the unitPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitPrice(BigDecimal value) {
        this.unitPrice = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the rebatePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRebatePercentage() {
        return rebatePercentage;
    }

    /**
     * Sets the value of the rebatePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRebatePercentage(BigDecimal value) {
        this.rebatePercentage = value;
    }

    /**
     * Gets the value of the rebateAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRebateAmount() {
        return rebateAmount;
    }

    /**
     * Sets the value of the rebateAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRebateAmount(BigDecimal value) {
        this.rebateAmount = value;
    }

    /**
     * Gets the value of the rebateDeducted property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRebateDeducted() {
        return rebateDeducted;
    }

    /**
     * Sets the value of the rebateDeducted property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRebateDeducted(BigDecimal value) {
        this.rebateDeducted = value;
    }

    /**
     * Gets the value of the taxTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxTotal() {
        return taxTotal;
    }

    /**
     * Sets the value of the taxTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxTotal(BigDecimal value) {
        this.taxTotal = value;
    }

}
