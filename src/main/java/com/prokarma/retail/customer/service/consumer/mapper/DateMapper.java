package com.prokarma.retail.customer.service.consumer.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMapper {

  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

  public java.sql.Date asSqlDate(String birthDate) throws ParseException {
    Date parsedDate = format.parse(birthDate);
    return new java.sql.Date(parsedDate.getTime());
  }

  public String asLocalDate(java.sql.Date birthDate) {
    return format.format(birthDate);
  }
}
