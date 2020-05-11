package com.prokarma.retail.customer.service.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import com.prokarma.retail.customer.service.consumer.exception.InvalidCustomerException;
import com.prokarma.retail.customer.service.consumer.jpa.entity.ErrorLog;
import com.prokarma.retail.customer.service.consumer.model.Customer;
import com.prokarma.retail.customer.service.consumer.repository.ErrorRepository;
import com.prokarma.retail.customer.service.consumer.service.helper.MaskHelper;

@Service
public class KafkaConsumerService {

  private ObjectMapper jsonMapper;
  private ErrorRepository errorRepo;
  private DataService dataService;
  private MaskHelper maskHelper;
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

  @Autowired
  public KafkaConsumerService(MaskHelper maskHelper, ObjectMapper jsonMapper,
      ErrorRepository errorRepo, DataService dataService) {
    this.jsonMapper = jsonMapper;
    this.errorRepo = errorRepo;
    this.dataService = dataService;
    this.maskHelper = maskHelper;

  }

  @KafkaListener(topics = "customerTopic")
  public void consumeFromKafka(ConsumerRecord<String, String> consumerRecord)
      throws JsonProcessingException {
    Customer customer = null;
    try {
      LOGGER.info(consumerRecord.value());
      customer = jsonMapper.readValue(consumerRecord.value(), Customer.class);
      if (isInvalidCustomer(customer)) {
        throw new InvalidCustomerException(
            "Consumed payload is not relevant to customer structuer");
      } else {
        LOGGER.info(String.format("ConsumerRecord value is:: %s",
            jsonMapper.writeValueAsString(maskHelper.maskCustomer(customer))));
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
          jsonMapper.writeValueAsString((maskHelper.maskCustomer(customer)))), ex);
      errorRepo.save(ErrorLog.builder().errorType(ex.getClass().getName())
          .errorDescription(ex.getMessage()).payload(consumerRecord.value()).build());
    }

  }

  private boolean isInvalidCustomer(Customer customer) {
    return StringUtils.isEmpty(customer.getCustomerNumber());
  }


}

