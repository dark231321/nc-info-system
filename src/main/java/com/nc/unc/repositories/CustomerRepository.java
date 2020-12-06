package com.nc.unc.repositories;

import com.nc.unc.model.Customer;

import java.util.Map;
import java.util.stream.Collectors;

public class CustomerRepository extends Repository<Long, Customer> {

    public CustomerRepository(String fileName) {
        super(fileName, CustomerRepository.class);
    }

    public Map<Long, Customer> getCustomer(String search){
        String sought = search.toLowerCase();
        return this.entities.entrySet().stream()
                .filter(entry -> entry.getValue().getFirstName().toLowerCase().contains(sought))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
