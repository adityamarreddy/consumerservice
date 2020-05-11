package com.prokarma.retail.customer.service.consumer.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prokarma.retail.customer.service.consumer.jpa.entity.Audit;
import com.prokarma.retail.customer.service.consumer.jpa.entity.Customer;
import com.prokarma.retail.customer.service.consumer.mapper.CustomerMapper;
import com.prokarma.retail.customer.service.consumer.repository.AuditRepository;
import com.prokarma.retail.customer.service.consumer.repository.CustomerRepository;

@Service
public class DataService {

  private CustomerRepository customerRepo;
  private AuditRepository auditRepo;
  private CustomerMapper customerMapper;


  @Autowired
  public DataService(CustomerRepository customerRepo, AuditRepository auditRepo) {
    this.customerRepo = customerRepo;
    this.customerMapper = Mappers.getMapper(CustomerMapper.class);
    this.auditRepo = auditRepo;
  }


  public void persistAndAuditCustomer(
      com.prokarma.retail.customer.service.consumer.model.Customer customer, String payload) {
    auditTransaction(persistCustomer(buildCustomerEntity(customer, payload)));
  }

  private void auditTransaction(Customer persistCustomer) {
    auditRepo.save(Audit.builder().customerJson(persistCustomer.getCustomerJson())
        .customerNumber(persistCustomer.getCustomerNumber()).build());
  }

  private Customer persistCustomer(Customer customerEntity) {
    return customerRepo.save(customerEntity);
  }

  private Customer buildCustomerEntity(
      com.prokarma.retail.customer.service.consumer.model.Customer customer, String payload) {

    Customer customerEntity = customerMapper.sourceToDestination(customer);
    customerEntity.setCustomerJson(payload);
    return customerEntity;
  }
}
