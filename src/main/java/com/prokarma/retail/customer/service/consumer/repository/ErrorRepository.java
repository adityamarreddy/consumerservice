package com.prokarma.retail.customer.service.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import com.prokarma.retail.customer.service.consumer.jpa.entity.ErrorLog;

public interface ErrorRepository extends CrudRepository<ErrorLog, Long> {

}
