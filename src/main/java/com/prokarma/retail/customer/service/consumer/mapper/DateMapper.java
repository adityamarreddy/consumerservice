package com.prokarma.retail.customer.service.consumer.mapper;

import org.springframework.stereotype.Component;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.LocalDate;

public class DateMapper {

  public java.sql.Date asSqlDate(LocalDate birthDate) {
    return DateTimeUtils.toSqlDate(birthDate);
  }

  public LocalDate asLocalDate(java.sql.Date birthDate) {
    return DateTimeUtils.toLocalDate(birthDate);
  }
}
