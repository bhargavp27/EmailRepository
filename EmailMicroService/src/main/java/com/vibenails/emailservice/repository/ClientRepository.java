package com.vibenails.emailservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vibenails.emailservice.entities.Clients;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClientRepository extends CrudRepository<Clients, Integer> {

	@Query("SELECT u FROM Clients u WHERE u.check_value ='N'")
	List<Clients> find();

}
