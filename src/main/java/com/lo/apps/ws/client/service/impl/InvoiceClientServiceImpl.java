package com.lo.apps.ws.client.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.lo.apps.ws.client.entity.invoice.Account;
import com.lo.apps.ws.client.entity.invoice.Buyer;
import com.lo.apps.ws.client.entity.invoice.Invoice;
import com.lo.apps.ws.client.entity.invoice.InvoiceHeader;
import com.lo.apps.ws.client.entity.invoice.InvoiceRecord;
import com.lo.apps.ws.client.entity.invoice.SendInvoiceRequest;
import com.lo.apps.ws.client.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.client.entity.invoice.Sums;
import com.lo.apps.ws.client.entity.invoice.Supplier;
import com.lo.apps.ws.client.entity.invoice.Transaction;
import com.lo.apps.ws.client.entity.invoice.dto.InvoiceDTO;
import com.lo.apps.ws.client.entity.invoice.dto.InvoiceRecordDTO;
import com.lo.apps.ws.client.service.InvoiceClientService;

public class InvoiceClientServiceImpl extends WebServiceGatewaySupport implements InvoiceClientService {

	@Override
	public SendInvoiceResponse sendInvoice(InvoiceDTO invoiceDTO) throws Exception {
		SendInvoiceRequest request = new SendInvoiceRequest();
		SendInvoiceResponse response = null;

		Invoice invoice = new Invoice();
		invoice = buildInvoiceFromDto(invoiceDTO);

		if (invoice != null) {
			request.setInvoice(invoice);
			response = (SendInvoiceResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		}

		return response;
	}

	private Invoice buildInvoiceFromDto(InvoiceDTO invoiceDTO) throws Exception {
		Invoice invoice = new Invoice();
		InvoiceHeader invoiceHeader = new InvoiceHeader();
		List<InvoiceRecordDTO> invoiceRecordDTO = new ArrayList<InvoiceRecordDTO>();
		Buyer buyer = new Buyer();
		Supplier supplier = new Supplier();
		Transaction transaction = new Transaction();
		Account account = new Account();
		Sums sums = new Sums();
		DateFormatter df = new DateFormatter("yyyy-MM-dd");

		account.setAccountDate(df.parse(invoiceDTO.getAccountDate(), Locale.ENGLISH));
		account.setAccountNumber(invoiceDTO.getAccountNumber());

		buyer.setAccount(account);
		buyer.setBuyerAddress(invoiceDTO.getBuyerAddress());
		buyer.setBuyerName(invoiceDTO.getBuyerName());
		buyer.setBuyerPIB(invoiceDTO.getBuyerPIB());

		supplier.setSupplierAddress(invoiceDTO.getSupplierAddress());
		supplier.setSupplierName(invoiceDTO.getSupplierName());
		supplier.setSupplierPIB(invoiceDTO.getSupplierPIB());

		sums.setMerchAndServiceSum(invoiceDTO.getMerchAndServiceSum());
		sums.setRebateSum(invoiceDTO.getRebateSum());
		sums.setTaxSum(invoiceDTO.getTaxSum());

		transaction.setAmountToPay(invoiceDTO.getAmountToPay());
		transaction.setCurrencyCode(invoiceDTO.getCurrencyCode());
		transaction.setDateOfCurrency(df.parse(invoiceDTO.getDateOfCurrency(), Locale.ENGLISH));
		transaction.setMerchValue(invoiceDTO.getMerchValue());
		transaction.setPayToAccount(invoiceDTO.getPayToAccount());
		transaction.setServiceValue(invoiceDTO.getServiceValue());
		transaction.setSums(sums);

		invoiceHeader.setBuyer(buyer);
		invoiceHeader.setSupplier(supplier);
		invoiceHeader.setTransaction(transaction);

		if (!invoiceDTO.getInvoiceRecordList().isEmpty()) {
			invoiceRecordDTO = invoiceDTO.getInvoiceRecordList();
			for (InvoiceRecordDTO curr : invoiceRecordDTO) {
				InvoiceRecord invoiceRecord = new InvoiceRecord();

				invoiceRecord.setAmount(curr.getAmount());
				invoiceRecord.setMerchOrServiceName(curr.getMerchOrServiceName());
				invoiceRecord.setRebateAmount(curr.getRebateAmount());
				invoiceRecord.setRebateDeducted(curr.getRebateDeducted());
				invoiceRecord.setRebatePercentage(curr.getRebatePercentage());
				invoiceRecord.setRecordNumber(curr.getRecordNumber());
				invoiceRecord.setTaxTotal(curr.getTaxTotal());
				invoiceRecord.setUnitOfIssue(curr.getUnitOfIssue());
				invoiceRecord.setUnitPrice(curr.getUnitPrice());
				invoiceRecord.setValue(curr.getValue());

				invoice.getInvoiceRecordData().add(invoiceRecord);
			}
		}

		invoice.setInvoiceHeaderData(invoiceHeader);

		return invoice;
	}
}
