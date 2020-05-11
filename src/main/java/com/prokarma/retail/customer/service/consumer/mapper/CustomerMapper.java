package com.prokarma.retail.customer.service.consumer.mapper;

import org.mapstruct.Mapper;
import com.prokarma.retail.customer.service.consumer.model.Customer;

// componentModel = "spring",
@Mapper(uses = {DateMapper.class, CustomerStatusMapper.class})
public interface CustomerMapper {

  com.prokarma.retail.customer.service.consumer.jpa.entity.Customer sourceToDestination(
      Customer source);

  // Customer destinationToSource(com.prokarma.retail.customer.service.producer.jpa.entity.Customer
  // destination);
}
