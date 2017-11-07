package com.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/store")
public class StoreService {
	
	@Autowired
	public StoreRepo repository;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public List<Store> getAllStores()
	{
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public Store getById(@PathVariable String id) throws Exception
	{
		if(repository.exists(id))
		{
			return repository.findById(id);
		} else {
			throw new Exception("Store with id " + id + "does not exist");
		}
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public Store addNew(@RequestParam(value = "location") String location, 
			@RequestParam(value = "storeName") String storeName)
	{
		Store store = new Store(location, storeName);
		repository.save(store);
		return store;
	}
}
