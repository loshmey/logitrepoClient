package com.lo.apps.ws.client.service;

import com.lo.apps.ws.client.entity.invoice.Invoice;
import com.lo.apps.ws.client.entity.invoice.SendInvoiceResponse;

public interface InvoiceClientService {

	public SendInvoiceResponse sendInvoice(Invoice invoice) throws Exception;

}
