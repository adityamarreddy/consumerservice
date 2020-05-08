package com.prokarma.retail.customer.service.consumer.mapper;

import com.prokarma.retail.customer.service.consumer.model.Customer.CustomerStatusEnum;

public class CustomerStatusMapper {

  public String asString(CustomerStatusEnum customerStatus) {
    return customerStatus.name();
  }

  public CustomerStatusEnum asCustomerStatusEnum(String customerStatus) {
    return CustomerStatusEnum.fromValue(customerStatus);
  }
}
