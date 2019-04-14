package com.vibenails.emailservice.service;

import java.util.List;

import com.vibenails.emailservice.entities.Clients;

public interface UpdateService {

	public String addNewUser(String name
			, String email
			, Integer minimumDayRate
			, String timeLine
			, Integer maxLeadsPerDay
			, Integer maxBudget
			, Integer unitPrice
			, String checkValue);
	public Iterable<Clients> getAllUsers();
	public List<Clients> getClients();
	public String updateSent(Integer id);
	public String updateDone(Integer id);
	public String updateMiss(Integer id);
	public Boolean updateReset();
	public String deleteUser(Integer id);
	public String deleteAllUsers();

}
