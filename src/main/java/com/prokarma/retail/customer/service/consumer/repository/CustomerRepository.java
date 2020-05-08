package com.prokarma.retail.customer.service.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.prokarma.retail.customer.service.consumer.jpa.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {


  // <S extends Customer> S save(Customer c);
}
