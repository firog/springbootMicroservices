package com.microservices;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepo extends MongoRepository<Customer, String>
{
	public List<Customer> findByLastName(@Param("firstName") String firstName);
	public Customer findById(String id);
}
