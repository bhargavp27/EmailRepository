package email.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import email.service.components.EmailConfiguration;
import email.service.models.PersonQuote;

@Component
public class EmailUtil {
	
	private static int receiver = 0;
	private List<String> receiverList;
	
	@Autowired
	public EmailConfiguration configuration;
	
	public EmailUtil() {
		// TODO Auto-generated constructor stub
		receiverList = new ArrayList<>();
		receiverList.add("1@sample.com");
		receiverList.add("2@sample.com");
		receiverList.add("3@sample.com");
		receiverList.add("4@sample.com");
		receiverList.add("5@sample.com");
	}
	
	
	public void emailQuotation(PersonQuote quotation) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.configuration.getHost());
        mailSender.setPort(this.configuration.getPort());
        mailSender.setUsername(this.configuration.getUsername());
        mailSender.setPassword(this.configuration.getPassword());
        
        
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(quotation.getEmail());
        mailMessage.setTo(receiverList.get(receiver));
        mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
        mailMessage.setText("Find the Quotation details below:\n"+quotation.toString());
        mailSender.send(mailMessage);
        receiver= (receiver+1)%receiverList.size();
	}
	

}
