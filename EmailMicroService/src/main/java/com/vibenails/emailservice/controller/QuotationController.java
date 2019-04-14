package com.vibenails.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vibenails.emailservice.entities.Clients;
import com.vibenails.emailservice.models.PersonQuote;
import com.vibenails.emailservice.service.UpdateService;
import com.vibenails.emailservice.util.EmailUtil;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private UpdateService updateService;

	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getQuotation(@RequestBody PersonQuote quotation, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "Quotation details are wrong.";
		} else {
			// emailUtil.emailQuotation(quotation);
			emailUtil.checkConstraints(quotation);
			System.out.println(quotation);
		}
		return "Quotation is received successfully";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addClients(@RequestBody Clients client) {
		if (!StringUtils.isEmpty(client)) {
			updateService.addNewUser(client.getName(), client.getEmail(), client.getMinimumDayRate(),
					client.getTimeLine(), client.getMaxLeadsPerDay(), client.getMaxBudget(), client.getUnitPrice(),
					client.getCheckValue());
			return "Saved the Client";
		} else {
			return "Input data is not valid";
		}
	}

	@GetMapping(path = "/delete")
	public String deleteClients(@RequestParam Integer id) {
		if (!StringUtils.isEmpty(id)) {
			updateService.deleteUser(id);
			return "Successfully deleted the Client";
		} else {
			return "Input data is not valid";
		}
	}

	@GetMapping(path = "/deleteall")
	public String deleteAllClients() {
		updateService.deleteAllUsers();
		return "Successfully deleted all the Clients";

	}
}
