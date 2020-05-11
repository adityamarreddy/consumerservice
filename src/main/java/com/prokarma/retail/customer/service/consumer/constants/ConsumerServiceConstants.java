package com.prokarma.retail.customer.service.consumer.constants;

public class ConsumerServiceConstants {


  private ConsumerServiceConstants() {
    // private constructor
  }

  public static final String LAST_FOUR_CHAR_MASK_REGEX = ".{4}$";
  public static final String LAST_FOUR_CHAR_MASK_REPLACE_TEXT = "****";
  public static final String FIRST_FOUR_CHAR_MASK_REGEX = "^\\S{4}";
  public static final String FIRST_FOUR_CHAR_MASK_REPLACE_TEXT = "****";
}
