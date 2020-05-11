package com.prokarma.retail.customer.service.consumer.service.helper;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.prokarma.retail.customer.service.consumer.model.Address;
import com.prokarma.retail.customer.service.consumer.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class MaskHelperTest {

  private MaskHelper maskHelper = new MaskHelper();

  @Test
  public void testCustomerMasking() {
    Customer customer = new Customer();
    customer.setCustomerNumber("C00001000100012345");
    customer.setEmail("customer@gmail.com");
    customer.setBirthDate("30-12-2020");
    Address address = new Address();
    customer.setAddress(address);
    Customer maskCustomer = maskHelper.maskCustomer(customer);
    assertEquals("C0000100010001****", maskCustomer.getCustomerNumber());
    assertEquals("****omer@gmail.com", maskCustomer.getEmail());

  }

  @Test
  public void testCustomerMaskingWithCustomerAsNull() {
    Customer expected = null;
    Customer maskCustomer = maskHelper.maskCustomer(null);
    assertEquals(expected, maskCustomer);
  }

  @Test
  public void testCustomerMaskingWithAddressAsNull() {
    Customer customer = new Customer();
    customer.setCustomerNumber("C00001000100012345");
    customer.setEmail("customer@gmail.com");
    customer.setBirthDate("30-12-2020");
    customer.setAddress(null);
    Customer maskCustomer = maskHelper.maskCustomer(customer);
    assertEquals("C0000100010001****", maskCustomer.getCustomerNumber());
    assertEquals("****omer@gmail.com", maskCustomer.getEmail());
    assertEquals("****2-2020", maskCustomer.getBirthDate());

  }

}

