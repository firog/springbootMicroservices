package com.microservices;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "store", path = "store")
public interface StoreRepo extends MongoRepository<Store, String>
{
	public List<Store> findByStoreName(@Param("storeName") String storeName);
	public Store findById(String id);
}
