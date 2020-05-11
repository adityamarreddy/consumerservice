package com.prokarma.retail.customer.service.consumer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateTests {


  @Test
  public void parseDate() throws ParseException {
    Date initDate = new SimpleDateFormat("dd-MM-yyyy").parse("10-12-2016");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String parsedDate = formatter.format(initDate);
    System.out.println(parsedDate);
  }
}
