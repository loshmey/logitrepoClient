
package com.lo.apps.ws.client.entity.invoice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Transaction properties.
 * 
 * <p>Java class for Transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="merchValue">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,15}.{0,1}\d{0,2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="serviceValue">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,15}.{0,1}\d{0,2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sums" type="{http://localhost:8080/invoice/schema}Sums"/>
 *         &lt;element name="amountToPay">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;fractionDigits value="2"/>
 *               &lt;minInclusive value="1"/>
 *               &lt;pattern value="\d{1,15}.{0,1}\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="payToAccount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;pattern value="[1-9]{1}[\d\-]{17}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="currencyCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;pattern value="[a-zA-Z]{3}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dateOfCurrency">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
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
@XmlType(name = "Transaction", namespace = "http://localhost:8080/invoice/schema", propOrder = {
    "merchValue",
    "serviceValue",
    "sums",
    "amountToPay",
    "payToAccount",
    "currencyCode",
    "dateOfCurrency"
})
public class Transaction {

    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal merchValue;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal serviceValue;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected Sums sums;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected BigDecimal amountToPay;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected String payToAccount;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected String currencyCode;
    @XmlElement(namespace = "http://localhost:8080/invoice/schema", required = true)
    protected String dateOfCurrency;

    /**
     * Gets the value of the merchValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMerchValue() {
        return merchValue;
    }

    /**
     * Sets the value of the merchValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMerchValue(BigDecimal value) {
        this.merchValue = value;
    }

    /**
     * Gets the value of the serviceValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getServiceValue() {
        return serviceValue;
    }

    /**
     * Sets the value of the serviceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setServiceValue(BigDecimal value) {
        this.serviceValue = value;
    }

    /**
     * Gets the value of the sums property.
     * 
     * @return
     *     possible object is
     *     {@link Sums }
     *     
     */
    public Sums getSums() {
        return sums;
    }

    /**
     * Sets the value of the sums property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sums }
     *     
     */
    public void setSums(Sums value) {
        this.sums = value;
    }

    /**
     * Gets the value of the amountToPay property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

    /**
     * Sets the value of the amountToPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountToPay(BigDecimal value) {
        this.amountToPay = value;
    }

    /**
     * Gets the value of the payToAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayToAccount() {
        return payToAccount;
    }

    /**
     * Sets the value of the payToAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayToAccount(String value) {
        this.payToAccount = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the dateOfCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfCurrency() {
        return dateOfCurrency;
    }

    /**
     * Sets the value of the dateOfCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfCurrency(String value) {
        this.dateOfCurrency = value;
    }

}
