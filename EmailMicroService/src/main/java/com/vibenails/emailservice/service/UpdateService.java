package com.vibenails.emailservice.service;

import java.util.List;

import com.vibenails.emailservice.entities.Clients;
import com.vibenails.emailservice.models.ClientsList;

public interface UpdateService {

	public String addNewUser(String name
			, String email
			, String minimumDayRate
			, String timeLine
			, String maxLeadsPerDay
			, String maxBudget
			, String unitPrice
			, String checkValue);
	public Iterable<Clients> getAllUsers();
	public List<Clients> getClients();
	public String updateSent(Integer id);

}
