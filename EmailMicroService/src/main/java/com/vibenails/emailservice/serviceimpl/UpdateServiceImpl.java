package com.vibenails.emailservice.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vibenails.emailservice.entities.Clients;
import com.vibenails.emailservice.repository.ClientRepository;
import com.vibenails.emailservice.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	private UpdateService updateService;
	
	@Autowired
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
	public List<Clients> getAllUsers() {
		// TODO Auto-generated method stub
		List<Clients> clients = new ArrayList<>();
		userRepository.find().forEach(clients::add);
		return clients;
	}

	@Override
	public List<Clients> getClients() {
		// TODO Auto-generated method stub
		List<Clients> clients = new ArrayList<>();
		userRepository.find().forEach(clients::add);
		return clients;
	}

	@Override
	public String updateSent(Integer id) {
		// TODO Auto-generated method stub
		Clients n = userRepository.findById(id).get();
		
		n.setCurrentSent(n.getCurrentSent()+1);
		n.setTotalSent(n.getTotalSent()+1);
		n.setCheckValue("Y");
		
		userRepository.save(n);
		return "Updated";
	}
	
	@Override
	public String updateDone(Integer id) {
		// TODO Auto-generated method stub
		Clients n = userRepository.findById(id).get();
		
		n.setCheckValue("D");
		
		userRepository.save(n);
		return "Updated";
	}
	
	@Override
	public String updateMiss(Integer id) {
		// TODO Auto-generated method stub
		Clients n = userRepository.findById(id).get();
		
		n.setCheckValue("M");
		
		userRepository.save(n);
		return "Updated";
	}
	
	@Override
	public Boolean updateReset() {
		// TODO Auto-generated method stub
		userRepository.setN();
		
		List<Clients> n = new ArrayList<>();
		n = updateService.getClients();
		
		if(!StringUtils.isEmpty(n)) {
			return true;
		} else {
			return false;
		}
	}

}
