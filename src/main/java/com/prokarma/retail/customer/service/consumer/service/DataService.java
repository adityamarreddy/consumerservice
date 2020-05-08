package com.prokarma.retail.customer.service.consumer.service;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.prokarma.retail.customer.service.consumer.jpa.entity.Audit;
import com.prokarma.retail.customer.service.consumer.mapper.CustomerMapper;
import com.prokarma.retail.customer.service.consumer.model.Customer;
import com.prokarma.retail.customer.service.consumer.repository.AuditRepository;
import com.prokarma.retail.customer.service.consumer.repository.CustomerRepository;

@Service
public class DataService {

  private CustomerRepository customerRepo;
  private AuditRepository auditRepo;
  private CustomerMapper customerMapper;

  @Autowired
  public DataService(Gson jsonConverter, CustomerRepository customerRepo, AuditRepository auditRepo) {
    this.customerRepo = customerRepo;
    this.customerMapper = Mappers.getMapper(CustomerMapper.class);
    this.auditRepo = auditRepo;
  }
  
  
  public void persistAndAuditCustomer(Customer customer, String payload) {
    auditTransaction(persistCustomer(buildCustomerEntity(customer, payload)));
  }
  
  private void auditTransaction(com.prokarma.retail.customer.service.consumer.jpa.entity.Customer persistCustomer) {
    auditRepo.save(Audit.builder().customerJson(persistCustomer.getCustomerJson())
        .customerNumber(persistCustomer.getCustomerNumber()).build());
  }

  private com.prokarma.retail.customer.service.consumer.jpa.entity.Customer persistCustomer(
      com.prokarma.retail.customer.service.consumer.jpa.entity.Customer customerEntity) {
    return customerRepo.save(customerEntity);
  }

  private com.prokarma.retail.customer.service.consumer.jpa.entity.Customer buildCustomerEntity(Customer customer,
      String payload) {

    com.prokarma.retail.customer.service.consumer.jpa.entity.Customer customerEntity =
        customerMapper.sourceToDestination(customer);
    customerEntity.setCustomerJson(payload);
    return customerEntity;
  }
}
