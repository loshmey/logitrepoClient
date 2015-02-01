package com.lo.apps.ws.client.entity.invoice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Invoice DTO class.
 * 
 * @author milos.poljak
 *
 */
public class InvoiceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String requestDateTime;
	private String supplierName;
	private String supplierAddress;
	private String supplierPIB;
	private String buyerName;
	private String buyerAddress;
	private String buyerPIB;
	private String accountNumber;
	private String accountDate;
	private BigDecimal merchValue;
	private BigDecimal serviceValue;
	private BigDecimal merchAndServiceSum;
	private BigDecimal rebateSum;
	private BigDecimal taxSum;
	private BigDecimal amountToPay;
	private String payToAccount;
	private String currencyCode;
	private String dateOfCurrency;
	private List<InvoiceRecordDTO> invoiceRecordList;

	public String getRequestDateTime() {
		return requestDateTime;
	}

	public void setRequestDateTime(String requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierPIB() {
		return supplierPIB;
	}

	public void setSupplierPIB(String supplierPIB) {
		this.supplierPIB = supplierPIB;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerPIB() {
		return buyerPIB;
	}

	public void setBuyerPIB(String buyerPIB) {
		this.buyerPIB = buyerPIB;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}

	public BigDecimal getMerchValue() {
		return merchValue;
	}

	public void setMerchValue(BigDecimal merchValue) {
		this.merchValue = merchValue;
	}

	public BigDecimal getServiceValue() {
		return serviceValue;
	}

	public void setServiceValue(BigDecimal serviceValue) {
		this.serviceValue = serviceValue;
	}

	public BigDecimal getMerchAndServiceSum() {
		return merchAndServiceSum;
	}

	public void setMerchAndServiceSum(BigDecimal merchAndServiceSum) {
		this.merchAndServiceSum = merchAndServiceSum;
	}

	public BigDecimal getRebateSum() {
		return rebateSum;
	}

	public void setRebateSum(BigDecimal rebateSum) {
		this.rebateSum = rebateSum;
	}

	public BigDecimal getTaxSum() {
		return taxSum;
	}

	public void setTaxSum(BigDecimal taxSum) {
		this.taxSum = taxSum;
	}

	public BigDecimal getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(BigDecimal amountToPay) {
		this.amountToPay = amountToPay;
	}

	public String getPayToAccount() {
		return payToAccount;
	}

	public void setPayToAccount(String payToAccount) {
		this.payToAccount = payToAccount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getDateOfCurrency() {
		return dateOfCurrency;
	}

	public void setDateOfCurrency(String dateOfCurrency) {
		this.dateOfCurrency = dateOfCurrency;
	}

	public List<InvoiceRecordDTO> getInvoiceRecordList() {
		return invoiceRecordList;
	}

	public void setInvoiceRecordList(List<InvoiceRecordDTO> invoiceRecordList) {
		this.invoiceRecordList = invoiceRecordList;
	}

}
