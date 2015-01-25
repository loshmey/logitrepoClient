package com.lo.apps.ws.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lo.apps.ws.client.entity.invoice.Invoice;
import com.lo.apps.ws.client.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.client.service.InvoiceClientService;

@Controller
public class IndexController {

	@Autowired
	private InvoiceClientService clientService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String invoicePage(Model model) throws Exception {
		model.addAttribute("message", "Welcome to the XWS Client!");

		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String submitInvoice(@RequestBody(required = true) Invoice invoice, Model model) throws Exception {
		Assert.notNull(invoice);
		SendInvoiceResponse response = clientService.sendInvoice(invoice);
		if (response != null) {
			model.addAttribute("status", response.getStatus());
			model.addAttribute("description", response.getDescription());
			model.addAttribute("timestamp", response.getTimestamp());
		}

		return "index";
	}

}
