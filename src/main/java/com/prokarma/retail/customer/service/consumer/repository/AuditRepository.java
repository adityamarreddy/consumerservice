package com.prokarma.retail.customer.service.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.prokarma.retail.customer.service.consumer.jpa.entity.Audit;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {


}
