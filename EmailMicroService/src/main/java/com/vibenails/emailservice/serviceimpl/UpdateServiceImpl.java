package com.vibenails.emailservice.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vibenails.emailservice.entities.Clients;
import com.vibenails.emailservice.models.ClientsList;
import com.vibenails.emailservice.repository.ClientRepository;
import com.vibenails.emailservice.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {

	private ClientRepository userRepository;
	
	@Override
	public String addNewUser(String name, String email, String minimumDayRate, String timeLine, String maxLeadsPerDay,
			String maxBudget, String unitPrice, String checkValue) {
		// TODO Auto-generated method stub
		Clients n = new Clients();
		n.setName(name);
		n.setEmail(email);
		n.setMinimumDayRate(minimumDayRate);
		n.setTimeLine(timeLine);
		n.setMaxLeadsPerDay(maxLeadsPerDay);
		n.setMaxBudget(maxBudget);
		n.setUnitPrice(unitPrice);
		n.setCheckValue(checkValue);
		userRepository.save(n);
		return "Saved";
	}

	@Override
	public Iterable<Clients> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<Clients> getClients() {
		// TODO Auto-generated method stub
		List<Clients> clients = userRepository.find();
		return clients;
	}

	@Override
	public String updateSent(Integer id) {
		// TODO Auto-generated method stub
		Clients n = userRepository.findById(id).get();
		
		n.setCurrentSent(n.getCurrentSent()+1);
		n.setTotalSent(n.getTotalSent()+1);
		
		userRepository.save(n);
		return "Updated";
	}

}
