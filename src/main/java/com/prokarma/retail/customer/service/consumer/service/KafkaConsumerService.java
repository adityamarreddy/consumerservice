package com.prokarma.retail.customer.service.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.prokarma.retail.customer.service.consumer.exception.InvalidCustomerException;
import com.prokarma.retail.customer.service.consumer.jpa.entity.ErrorLog;
import com.prokarma.retail.customer.service.consumer.model.Customer;
import com.prokarma.retail.customer.service.consumer.repository.ErrorRepository;
import com.prokarma.retail.customer.service.consumer.util.MaskingUtil;

@Service
public class KafkaConsumerService {

  private Gson jsonConverter;
  private ErrorRepository errorRepo;
  private DataService dataService;
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

  @Autowired
  public KafkaConsumerService(Gson jsonConverter, ErrorRepository errorRepo,
      DataService dataService) {
    this.jsonConverter = jsonConverter;
    this.errorRepo = errorRepo;
    this.dataService = dataService;
  }

  @KafkaListener(topics = "customerTopic")
  public void consumeFromKafka(ConsumerRecord<String, String> consumerRecord) {
    Customer customer = null;
    try {

      customer = jsonConverter.fromJson(consumerRecord.value(), Customer.class);
      if (isInvalidCustomer(customer)) {
        throw new InvalidCustomerException(
            "Consumed payload is not relevant to customer structuer");
      } else {
        LOGGER.info(
            String.format("ConsumerRecord value is:: %s", jsonConverter.toJson(masked(customer))));
        dataService.persistAndAuditCustomer(customer, consumerRecord.value());
      }

    } catch (JsonParseException ex) {
      LOGGER
          .error(String.format("failed to convert consumerRecord value from kafka to customer:: %s",
              consumerRecord.value()), ex);
      errorRepo.save(ErrorLog.builder().errorType(ex.getClass().getName())
          .errorDescription(ex.getMessage()).payload(consumerRecord.value()).build());
    } catch (Exception ex) {
      LOGGER.error(String.format("failed to process consumerRecord from kafka:: %s",
          jsonConverter.toJson(masked(customer))), ex);
      errorRepo.save(ErrorLog.builder().errorType(ex.getClass().getName())
          .errorDescription(ex.getMessage()).payload(consumerRecord.value()).build());
    }

  }

  private boolean isInvalidCustomer(Customer customer) {
    return StringUtils.isEmpty(customer.getCustomerNumber());
  }

  private Customer masked(Customer customer) {
    try {
      customer.setCustomerNumber(MaskingUtil.maskString(customer.getCustomerNumber(),
          customer.getCustomerNumber().length() - 4, customer.getCustomerNumber().length(), '*'));
      customer.setEmail(MaskingUtil.maskEmailAddress(customer.getEmail(), '*'));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return customer;
  }


}

