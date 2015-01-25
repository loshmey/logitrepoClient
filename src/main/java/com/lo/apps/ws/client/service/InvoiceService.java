package com.lo.apps.ws.client.service;

import com.lo.apps.ws.entity.invoice.SendInvoiceRequest;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;

public interface InvoiceService {

	public SendInvoiceResponse sendInvoice(SendInvoiceRequest invoice) throws Exception;

}
