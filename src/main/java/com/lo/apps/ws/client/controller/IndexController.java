package com.lo.apps.ws.client.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lo.apps.ws.client.entity.invoice.SendInvoiceResponse;
import com.lo.apps.ws.client.entity.invoice.dto.InvoiceDTO;
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
	public String submitInvoice(@ModelAttribute InvoiceDTO invoiceDTO, BindingResult result, Model model) throws Exception {
		Assert.notNull(invoiceDTO);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		invoiceDTO.setRequestDateTime(sdf.format(new Date()));

		SendInvoiceResponse response = clientService.sendInvoice(invoiceDTO);
		if (response != null) {
			model.addAttribute("status", response.getStatus());
			model.addAttribute("description", response.getDescription());
			model.addAttribute("timestamp", response.getTimestamp());
		} else {
			model.addAttribute("status", "NIJE POSLATO!");
		}

		return "index";
	}

    @RequestMapping(value = "/accountStatus", method = RequestMethod.GET)
	public String accountStatus() throws Exception {
        return "accountStatus";
    }

}
