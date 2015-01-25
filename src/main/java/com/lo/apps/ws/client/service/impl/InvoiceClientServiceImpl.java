package com.lo.apps.ws.client.service.impl;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.lo.apps.ws.client.entity.invoice.Invoice;
import com.lo.apps.ws.client.entity.invoice.SendInvoiceRequest;
import com.lo.apps.ws.client.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.client.service.InvoiceClientService;

public class InvoiceClientServiceImpl extends WebServiceGatewaySupport implements InvoiceClientService {

	@Override
	public SendInvoiceResponse sendInvoice(Invoice invoice) throws Exception {
		SendInvoiceRequest request = new SendInvoiceRequest();
		request.setInvoice(invoice);

		SendInvoiceResponse response = (SendInvoiceResponse) getWebServiceTemplate().marshalSendAndReceive(request);

		return response;
	}

}
