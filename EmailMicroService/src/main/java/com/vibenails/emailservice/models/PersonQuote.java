package com.vibenails.emailservice.models;

import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;

public class PersonQuote {
	
	@NonNull
	private String firstName;
	
	@NonNull
	private String lastName;
	
	@NonNull
	private String phoneNumber;
	
	@NonNull
	private Integer priceQuote;
	
	@NonNull
	@Email
	private String email;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the priceQuote
	 */
	public Integer getPriceQuote() {
		return priceQuote;
	}

	/**
	 * @param priceQuote the priceQuote to set
	 */
	public void setPriceQuote(Integer priceQuote) {
		this.priceQuote = priceQuote;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "firstName=" + firstName + "\n lastName=" + lastName + "\n phoneNumber=" + phoneNumber
				+ "\n priceQuote=" + priceQuote + "\n email=" + email;
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}
	
	
	

}
