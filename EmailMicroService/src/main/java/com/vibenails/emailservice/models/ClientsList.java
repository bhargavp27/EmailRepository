package com.vibenails.emailservice.models;

public class ClientsList {
    
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