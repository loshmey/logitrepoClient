package com.lo.apps.service.impl;

import javax.jws.WebService;

import com.lo.apps.service.InvoiceService;
import com.lo.apps.ws.entity.invoice.SendInvoiceRequest;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;

@WebService(endpointInterface = "com.lo.apps.service.InvoiceService", serviceName = "InvoiceService")
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public SendInvoiceResponse sendInvoice(SendInvoiceRequest invoice) throws Exception {
		// TODO Snimiti u XML bazu
		SendInvoiceResponse response = new SendInvoiceResponse();
		return null;
	}

}
