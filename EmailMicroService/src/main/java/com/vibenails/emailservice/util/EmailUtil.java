package com.vibenails.emailservice.util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.vibenails.emailservice.components.EmailConfiguration;
import com.vibenails.emailservice.entities.Clients;
import com.vibenails.emailservice.models.PersonQuote;
import com.vibenails.emailservice.service.UpdateService;

@Component
public class EmailUtil {

	// private static int receiver = 0;
	// private List<String> receiverList;

	@Autowired
	public EmailConfiguration configuration;

	@Autowired
	private UpdateService updateService;

	/*
	 * public EmailUtil() { // TODO Auto-generated constructor stub receiverList =
	 * new ArrayList<>(); receiverList.add("pallurubhargav4@gmail.com");
	 * receiverList.add("2@sample.com"); receiverList.add("3@sample.com");
	 * receiverList.add("4@sample.com"); receiverList.add("5@sample.com"); //
	 * System.out.println("Clients : " + clients);
	 * 
	 * }
	 */

	/*
	 * public void emailQuotation(PersonQuote quotation) {
	 * 
	 * List<Clients> clients = updateService.getClients();
	 * System.out.println("Clients :  " + clients); checkConstraints(clients,
	 * quotation); JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	 * mailSender.setHost(this.configuration.getHost());
	 * mailSender.setPort(this.configuration.getPort());
	 * mailSender.setUsername(this.configuration.getUsername());
	 * mailSender.setPassword(this.configuration.getPassword());
	 * 
	 * SimpleMailMessage mailMessage = new SimpleMailMessage();
	 * mailMessage.setFrom(quotation.getEmail());
	 * mailMessage.setTo(receiverList.get(receiver));
	 * mailMessage.setSubject("New Quotation Received from " +
	 * quotation.getFullName());
	 * mailMessage.setText("Find the Quotation details below:\n" +
	 * quotation.toString()); mailSender.send(mailMessage); receiver = (receiver +
	 * 1) % receiverList.size(); }
	 */

	public void checkConstraints(PersonQuote quotation) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		LocalTime sysTime = LocalTime.now();

		List<Clients> receiverLst = new ArrayList<Clients>();

		receiverLst = updateService.getClients();

		// System.out.println("Clients : " + receiverLst);

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.configuration.getHost());
		mailSender.setPort(this.configuration.getPort());
		mailSender.setUsername(this.configuration.getUsername());
		mailSender.setPassword(this.configuration.getPassword());

		// retrieve all the Clients having checkValue in N

		// receiverLst = new ArrayList<Clients>();

		if (!StringUtils.isEmpty(receiverLst)) {
			// if receiverLst is not empty and if it's empty then in else reset all the
			// clients checkValue field to N
			for (Clients receiver : receiverLst) {

				System.out.println("Clients :  " + receiver);

				if (!StringUtils.isEmpty(receiver)) {
					if ((!StringUtils.isEmpty(receiver.getMinimumDayRate()))
							&& (!StringUtils.isEmpty(receiver.getTimeLine()))
							&& (!StringUtils.isEmpty(receiver.getMaxLeadsPerDay()))) {
						// emailQuotation(PersonQuote quotation)
						if (quotation.getPriceQuote() >= receiver.getMinimumDayRate()) {
							if (receiver.getTimeLine() == "AE") {
								if (receiver.getMaxLeadsPerDay() <= receiver.getCurrentSent()) {
									// send email to the email
									// update checkValue field to Y
									// update value of currentSent and totalSent

									SimpleMailMessage mailMessage = new SimpleMailMessage();
									mailMessage.setFrom(quotation.getEmail());
									mailMessage.setTo(receiver.getEmail());
									mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
									mailMessage.setText("Find the Quotation details below:\n" + quotation.toString());
									mailSender.send(mailMessage);

									updateService.updateSent(receiver.getId());

								} else {
									updateService.updateDone(receiver.getId());
									continue;
								}

							} else if (receiver.getTimeLine() == "WE" && sysTime.getHour() >= 9
									&& sysTime.getHour() <= 17) {
								if (receiver.getMaxLeadsPerDay() <= receiver.getCurrentSent()) {
									// send email to the email
									// update checkValue field to Y
									// update value of currentSent and totalSent
									SimpleMailMessage mailMessage = new SimpleMailMessage();
									mailMessage.setFrom(quotation.getEmail());
									mailMessage.setTo(receiver.getEmail());
									mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
									mailMessage.setText("Find the Quotation details below:\n" + quotation.toString());
									mailSender.send(mailMessage);

									updateService.updateSent(receiver.getId());

								} else {
									updateService.updateDone(receiver.getId());
									continue;
								}
							} else if (receiver.getTimeLine() == "AW" && day != 5 && day != 6) {
								if (receiver.getMaxLeadsPerDay() <= receiver.getCurrentSent()) {
									// send email to the email
									// update checkValue field to Y
									// update value of currentSent and totalSent
									SimpleMailMessage mailMessage = new SimpleMailMessage();
									mailMessage.setFrom(quotation.getEmail());
									mailMessage.setTo(receiver.getEmail());
									mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
									mailMessage.setText("Find the Quotation details below:\n" + quotation.toString());
									mailSender.send(mailMessage);

									updateService.updateSent(receiver.getId());
								} else {
									updateService.updateDone(receiver.getId());
									continue;
								}
							} else if (receiver.getTimeLine() == "WW" && day != 5 && day != 6 && sysTime.getHour() >= 9
									&& sysTime.getHour() <= 17) {
								if (receiver.getMaxLeadsPerDay() <= receiver.getCurrentSent()) {
									// send email to the email
									// update checkValue field to Y
									// update value of currentSent and totalSent
									SimpleMailMessage mailMessage = new SimpleMailMessage();
									mailMessage.setFrom(quotation.getEmail());
									mailMessage.setTo(receiver.getEmail());
									mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
									mailMessage.setText("Find the Quotation details below:\n" + quotation.toString());
									mailSender.send(mailMessage);

									updateService.updateSent(receiver.getId());
								} else {
									updateService.updateDone(receiver.getId());
									continue;
								}
							} else {
								updateService.updateMiss(receiver.getId());

								SimpleMailMessage mailMessage = new SimpleMailMessage();
								mailMessage.setFrom(quotation.getEmail());
								mailMessage.setTo("Default@Email.com");
								mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
								mailMessage.setText("Find the Quotation details below:\n" + quotation.toString());
								mailSender.send(mailMessage);

								continue;
							}
						} else {
							updateService.updateMiss(receiver.getId());

							SimpleMailMessage mailMessage = new SimpleMailMessage();
							mailMessage.setFrom(quotation.getEmail());
							mailMessage.setTo("Default@Email.com");
							mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
							mailMessage.setText("Find the Quotation details below:\n" + quotation.toString());
							mailSender.send(mailMessage);

							continue;
						}
					} else {
						continue;
					}

				} else {
					continue;
				}

			}
		} else {
			// check if any value with Y and update the value to N
			// else send the email to bin

			Boolean flag;
			flag = updateService.updateReset();
			if (flag.TRUE) {
				checkConstraints(quotation);
			} else {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setFrom(quotation.getEmail());
				mailMessage.setTo("Default@Email.com");
				mailMessage.setSubject("New Quotation Received from " + quotation.getFullName());
				mailMessage.setText("Find the Quotation details below:\n" + quotation.toString());
				mailSender.send(mailMessage);
			}

		}

	}

}
