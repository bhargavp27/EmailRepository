package com.vibenails.emailservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clients", schema = "vibenails_data")// This tells Hibernate to make a table out of this class
public class Clients {
	
	
	public Clients() {
		
	}
	
    public Clients(Integer id, String name, String email, Integer minimumDayRate, String timeLine, Integer maxLeadsPerDay,
			Integer maxLeadsPerMonth, Integer maxBudget, Integer unitPrice, Integer currentSent, Integer totalSent,
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
    
    private Integer minimumDayRate;
    
    private String timeLine;
    
    private Integer maxLeadsPerDay;
    
    private Integer maxLeadsPerMonth;
    
    private Integer maxBudget;
    
    private Integer unitPrice;
    
    private Integer currentSent;
    
    private Integer totalSent;
    
    private String checkValue;
    
    public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}

	public Integer getCurrentSent() {
		return currentSent;
	}

	public void setCurrentSent(Integer currentSent) {
		this.currentSent = currentSent;
	}

	public Integer getTotalSent() {
		return totalSent;
	}

	public void setTotalSent(Integer totalSent) {
		this.totalSent = totalSent;
	}

	public Integer getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(Integer maxBudget) {
		this.maxBudget = maxBudget;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
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

	public Integer getMinimumDayRate() {
		return minimumDayRate;
	}

	public void setMinimumDayRate(Integer minimumDayRate) {
		this.minimumDayRate = minimumDayRate;
	}

	public String getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}

	public Integer getMaxLeadsPerDay() {
		return maxLeadsPerDay;
	}

	public void setMaxLeadsPerDay(Integer maxLeadsPerDay) {
		this.maxLeadsPerDay = maxLeadsPerDay;
	}

	public Integer getMaxLeadsPerMonth() {
		return maxLeadsPerMonth;
	}

	public void setMaxLeadsPerMonth(Integer maxLeadsPerMonth) {
		this.maxLeadsPerMonth = maxLeadsPerMonth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
