//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.22 at 11:39:00 PM CET 
//

package com.lo.apps.ws.client.entity.invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestDateTime" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="invoiceHeaderData" type="{http://localhost:8080/invoice/schema}InvoiceHeader"/>
 *         &lt;element name="invoiceRecordData" type="{http://localhost:8080/invoice/schema}InvoiceRecord" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://localhost:8080/invoice/schema}Id use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "requestDateTime", "invoiceHeaderData", "invoiceRecordData" })
@XmlRootElement(name = "Invoice")
public class Invoice {

	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	protected Date requestDateTime;
	@XmlElement(required = true)
	protected InvoiceHeader invoiceHeaderData;
	@XmlElement(required = true)
	protected List<InvoiceRecord> invoiceRecordData;
	@XmlAttribute(name = "Id", namespace = "http://localhost:8080/invoice/schema", required = true)
	protected long id;

	/**
	 * Gets the value of the requestDateTime property.
	 * 
	 * @return possible object is {@link Date }
	 * 
	 */
	public Date getRequestDateTime() {
		return requestDateTime;
	}

	/**
	 * Sets the value of the requestDateTime property.
	 * 
	 * @param value
	 *            allowed object is {@link Date }
	 * 
	 */
	public void setRequestDateTime(Date value) {
		this.requestDateTime = value;
	}

	/**
	 * Gets the value of the invoiceHeaderData property.
	 * 
	 * @return possible object is {@link InvoiceHeader }
	 * 
	 */
	public InvoiceHeader getInvoiceHeaderData() {
		return invoiceHeaderData;
	}

	/**
	 * Sets the value of the invoiceHeaderData property.
	 * 
	 * @param value
	 *            allowed object is {@link InvoiceHeader }
	 * 
	 */
	public void setInvoiceHeaderData(InvoiceHeader value) {
		this.invoiceHeaderData = value;
	}

	/**
	 * Gets the value of the invoiceRecordData property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the invoiceRecordData property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInvoiceRecordData().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link InvoiceRecord }
	 * 
	 * 
	 */
	public List<InvoiceRecord> getInvoiceRecordData() {
		if (invoiceRecordData == null) {
			invoiceRecordData = new ArrayList<InvoiceRecord>();
		}
		return this.invoiceRecordData;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 */
	public void setId(long value) {
		this.id = value;
	}

}