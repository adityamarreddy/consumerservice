package com.prokarma.retail.customer.service.consumer.service.helper;


import static com.prokarma.retail.customer.service.consumer.constants.ConsumerServiceConstants.FIRST_FOUR_CHAR_MASK_REGEX;
import static com.prokarma.retail.customer.service.consumer.constants.ConsumerServiceConstants.FIRST_FOUR_CHAR_MASK_REPLACE_TEXT;
import static com.prokarma.retail.customer.service.consumer.constants.ConsumerServiceConstants.LAST_FOUR_CHAR_MASK_REGEX;
import static com.prokarma.retail.customer.service.consumer.constants.ConsumerServiceConstants.LAST_FOUR_CHAR_MASK_REPLACE_TEXT;
import org.springframework.stereotype.Component;
import com.prokarma.retail.customer.service.consumer.model.Address;
import com.prokarma.retail.customer.service.consumer.model.Customer;

@Component
public class MaskHelper {



  public Customer maskCustomer(Customer source) {
    if (source == null) {
      return null;
    }

    Customer customer = new Customer();

    customer.setCustomerNumber(maskLastFourCharacters(source.getCustomerNumber()));
    customer.setFirstName(source.getFirstName());
    customer.setLastName(source.getLastName());
    customer.setBirthDate(maskFirstFourCharacters(source.getBirthDate()));
    customer.setCountry(source.getCountry());
    customer.setCountryCode(source.getCountryCode());
    customer.setMobileNumber(source.getMobileNumber());
    customer.setEmail(maskFirstFourCharacters(source.getEmail()));
    customer.setCustomerStatus(source.getCustomerStatus());
    customer.setAddress(addressToAddress(source.getAddress()));

    return customer;
  }

  private String maskLastFourCharacters(String input) {
    return input.replaceAll(LAST_FOUR_CHAR_MASK_REGEX, LAST_FOUR_CHAR_MASK_REPLACE_TEXT);
  }

  private String maskFirstFourCharacters(String input) {
    return input.replaceAll(FIRST_FOUR_CHAR_MASK_REGEX, FIRST_FOUR_CHAR_MASK_REPLACE_TEXT);
  }

  protected Address addressToAddress(Address address) {
    if (address == null) {
      return null;
    }

    Address address1 = new Address();

    address1.setAddressLine1(address.getAddressLine1());
    address1.setAddressLine2(address.getAddressLine2());
    address1.setStreet(address.getStreet());
    address1.setPostalCode(address.getPostalCode());

    return address1;
  }
}
