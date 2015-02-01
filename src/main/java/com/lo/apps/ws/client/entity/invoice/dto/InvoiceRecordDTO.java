package com.lo.apps.ws.client.entity.invoice.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Invoice Record DTO class.
 * 
 * @author milos.poljak
 *
 */
public class InvoiceRecordDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String recordNumber;
	private String merchOrServiceName;
	private BigDecimal amount;
	private String unitOfIssue;
	private BigDecimal unitPrice;
	private BigDecimal value;
	private BigDecimal rebatePercentage;
	private BigDecimal rebateAmount;
	private BigDecimal rebateDeducted;
	private BigDecimal taxTotal;

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getMerchOrServiceName() {
		return merchOrServiceName;
	}

	public void setMerchOrServiceName(String merchOrServiceName) {
		this.merchOrServiceName = merchOrServiceName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getUnitOfIssue() {
		return unitOfIssue;
	}

	public void setUnitOfIssue(String unitOfIssue) {
		this.unitOfIssue = unitOfIssue;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getRebatePercentage() {
		return rebatePercentage;
	}

	public void setRebatePercentage(BigDecimal rebatePercentage) {
		this.rebatePercentage = rebatePercentage;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public BigDecimal getRebateDeducted() {
		return rebateDeducted;
	}

	public void setRebateDeducted(BigDecimal rebateDeducted) {
		this.rebateDeducted = rebateDeducted;
	}

	public BigDecimal getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(BigDecimal taxTotal) {
		this.taxTotal = taxTotal;
	}

}
