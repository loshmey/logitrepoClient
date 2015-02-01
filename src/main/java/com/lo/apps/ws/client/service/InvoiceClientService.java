package com.lo.apps.ws.client.service;

import com.lo.apps.ws.client.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.client.entity.invoice.dto.InvoiceDTO;

public interface InvoiceClientService {

	public SendInvoiceResponse sendInvoice(InvoiceDTO invoiceDTO) throws Exception;

}
