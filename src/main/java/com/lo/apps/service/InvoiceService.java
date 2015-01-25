package com.lo.apps.service;

import com.lo.apps.ws.entity.invoice.SendInvoiceRequest;
import com.lo.apps.ws.entity.invoice.SendInvoiceResponse;

public interface InvoiceService {

	public SendInvoiceResponse sendInvoice(SendInvoiceRequest invoice) throws Exception;

}
