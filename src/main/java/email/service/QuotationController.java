package email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import email.service.components.EmailConfiguration;
import email.service.models.PersonQuote;
import email.service.util.EmailUtil;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping( value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getQuotation(@RequestBody PersonQuote quotation, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return "Quotation details are wrong.";
		} else {
			emailUtil.emailQuotation(quotation);
			System.out.println(quotation);
		}
		return "Quotation is received successfully";
	}
}
