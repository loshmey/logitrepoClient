package com.lo.apps.ws.client.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lo.apps.ws.client.entity.invoice.*;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.lo.apps.ws.client.entity.invoice.dto.InvoiceDTO;
import com.lo.apps.ws.client.entity.invoice.dto.InvoiceRecordDTO;
import com.lo.apps.ws.client.service.InvoiceClientService;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class InvoiceClientServiceImpl extends WebServiceGatewaySupport implements InvoiceClientService {

    private static final ObjectFactory WS_CLIENT_OBJECT_FACTORY = new ObjectFactory();

	@Override
	public SendInvoiceResponse sendInvoice(InvoiceDTO invoiceDTO) throws Exception {
		SendInvoiceRequest request = WS_CLIENT_OBJECT_FACTORY.createSendInvoiceRequest();
		SendInvoiceResponse response = null;
		Invoice invoice = buildInvoiceFromDto(invoiceDTO);

		if(invoice != null){
            request.setInvoice(invoice);
            response = (SendInvoiceResponse) getWebServiceTemplate().marshalSendAndReceive(request);
//            response = (SendInvoiceResponse)getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("http://localhost:8080/invoice/schema/SendInvoiceRequest"));
        }

		return response;
	}

	private Invoice buildInvoiceFromDto(InvoiceDTO invoiceDTO) throws Exception {
		Invoice invoice = WS_CLIENT_OBJECT_FACTORY.createInvoice();
		InvoiceHeader invoiceHeader = WS_CLIENT_OBJECT_FACTORY.createInvoiceHeader();
		Buyer buyer = WS_CLIENT_OBJECT_FACTORY.createBuyer();
		Supplier supplier = WS_CLIENT_OBJECT_FACTORY.createSupplier();
		Transaction transaction = WS_CLIENT_OBJECT_FACTORY.createTransaction();
		Account account = WS_CLIENT_OBJECT_FACTORY.createAccount();
		Sums sums = WS_CLIENT_OBJECT_FACTORY.createSums();

        List<InvoiceRecordDTO> invoiceRecordDTO;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		account.setAccountDate(invoiceDTO.getAccountDate());
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
		transaction.setCurrencyCode(getCurrencyCode(invoiceDTO.getCurrencyCode()));

		transaction.setDateOfCurrency(sdf.format(new Date()));
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

		invoice.setRequestDateTime(sdf.format(new Date()));
		invoice.setInvoiceHeaderData(invoiceHeader);

		return invoice;
	}

	private String getCurrencyCode(String currencyCodeValue) {
		String currencyCode = "";
		switch (currencyCodeValue) {
		case "1":
			currencyCode = "RSD";
			break;
		case "2":
			currencyCode = "EUR";
			break;
		case "3":
			currencyCode = "USD";
			break;
		}

		return currencyCode;
	}
}
