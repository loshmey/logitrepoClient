package com.lo.apps.ws.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lo.apps.ws.entity.invoice.SendInvoiceRequest;

@Controller
public class IndexController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String invoicePage(Model model) throws Exception {
		model.addAttribute("message", "Welcome to the XWS Client!");

		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String submitInvoice(@RequestBody(required = true) SendInvoiceRequest request, Model model) throws Exception {

		return "index";
	}

}
