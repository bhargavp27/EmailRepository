package com.vibenails.emailservice.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.vibenails.emailservice.components.EmailConfiguration;
import com.vibenails.emailservice.entities.Clients;
import com.vibenails.emailservice.models.PersonQuote;
import com.vibenails.emailservice.service.UpdateService;

@Component
public class EmailUtil {
	
	private static int receiver = 0;
	private List<String> receiverList;

	@Autowired
	public EmailConfiguration configuration;
	
	@Autowired
	UpdateService updateService;
	
	List<Clients> clients = new ArrayList<>();
	
	public EmailUtil() {
		// TODO Auto-generated constructor stub
		receiverList= new ArrayList<>();
		receiverList.add("pallurubhargav4@gmail.com");
		receiverList.add("2@sample.com");
		receiverList.add("3@sample.com");
		receiverList.add("4@sample.com");
		receiverList.add("5@sample.com");
		//System.out.println("Clients :  " + clients);
		
	}
	
	
	/*public void EmailUtils(List <Clients> receiverLst, PersonQuote quotation)
	{
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		LocalTime sysTime = LocalTime.now();
		
		//retrieve all the Clients having checkValue in N
		
		//receiverLst = new ArrayList<Clients>();
		//if receiverLst is not empty and if it's empty then in else reset all the clients checkValue field to N
		 for(Clients receiver:receiverLst) {
			 if(!StringUtils.isEmpty(receiver)) {
				 if((!StringUtils.isEmpty(receiver.getMinimumDayRate())) && (!StringUtils.isEmpty(receiver.getTimeLine()))&&(!StringUtils.isEmpty(receiver.getMaxLeadsPerMonth()) && (!StringUtils.isEmpty(receiver.getMaxLeadsPerDay())))){
					 //  emailQuotation(PersonQuote quotation)
					 if (Integer.parseInt(quotation.getPriceQuote()) >= Integer.parseInt(receiver.getMinimumDayRate())) {
						 if(receiver.getTimeLine() == "AE") {
							 if(Integer.parseInt(receiver.getMaxLeadsPerDay()) <= Integer.parseInt(receiver.getCurrentSent())) {
								 //send email to the email 
								 //update checkValue field to Y
								 //update value of currentSent and totalSent
								 
							 } else {
								 continue;
							 }
							 
						 } else if(receiver.getTimeLine() == "WE" && sysTime.) {
if(Integer.parseInt(receiver.getMaxLeadsPerDay()) <= Integer.parseInt(receiver.getCurrentSent())) {
								//send email to the email 
	 							//update checkValue field to Y
	 							//update value of currentSent and totalSent
								 
							 } else {
								 continue;
							 }
						 } else if(receiver.getTimeLine() == "AW" && day != 5 && day != 6) {
if(Integer.parseInt(receiver.getMaxLeadsPerDay()) <= Integer.parseInt(receiver.getCurrentSent())) {
								//send email to the email 
	 							//update checkValue field to Y
	 							//update value of currentSent and totalSent
							 } else {
								 continue;
							 }
						 } else if(receiver.getTimeLine() == "WW" && day != 5 && day != 6 && sysTime.) {
if(Integer.parseInt(receiver.getMaxLeadsPerDay()) <= Integer.parseInt(receiver.getCurrentSent())) {
								 
							 } else {
								 continue;
							 }
						 }
					 }
				 }else {
					 // donot send email logic 
				 }
				 
			 }
			 
			 
		 }
	}*/
	
	
	
	
	public void emailQuotation(PersonQuote quotation) {
		
		clients = updateService.getClients();
		System.out.println("Clients :  " + clients);
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
