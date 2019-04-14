package com.vibenails.emailservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Clients {
	
	
	public Clients() {
		
	}
	
    public Clients(Integer id, String name, String email, String minimumDayRate, String timeLine, String maxLeadsPerDay,
			String maxLeadsPerMonth, String maxBudget, String unitPrice, String currentSent, String totalSent,
			String checkValue) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.minimumDayRate = minimumDayRate;
		this.timeLine = timeLine;
		this.maxLeadsPerDay = maxLeadsPerDay;
		this.maxLeadsPerMonth = maxLeadsPerMonth;
		this.maxBudget = maxBudget;
		this.unitPrice = unitPrice;
		this.currentSent = currentSent;
		this.totalSent = totalSent;
		this.checkValue = checkValue;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;
    
    private String minimumDayRate;
    
    private String timeLine;
    
    private String maxLeadsPerDay;
    
    private String maxLeadsPerMonth;
    
    private String maxBudget;
    
    private String unitPrice;
    
    private String currentSent;
    
    private String totalSent;
    
    private String checkValue;
    
    public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}

	public String getCurrentSent() {
		return currentSent;
	}

	public void setCurrentSent(String currentSent) {
		this.currentSent = currentSent;
	}

	public String getTotalSent() {
		return totalSent;
	}

	public void setTotalSent(String totalSent) {
		this.totalSent = totalSent;
	}

	public String getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(String maxBudget) {
		this.maxBudget = maxBudget;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMinimumDayRate() {
		return minimumDayRate;
	}

	public void setMinimumDayRate(String minimumDayRate) {
		this.minimumDayRate = minimumDayRate;
	}

	public String getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}

	public String getMaxLeadsPerDay() {
		return maxLeadsPerDay;
	}

	public void setMaxLeadsPerDay(String maxLeadsPerDay) {
		this.maxLeadsPerDay = maxLeadsPerDay;
	}

	public String getMaxLeadsPerMonth() {
		return maxLeadsPerMonth;
	}

	public void setMaxLeadsPerMonth(String maxLeadsPerMonth) {
		this.maxLeadsPerMonth = maxLeadsPerMonth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
