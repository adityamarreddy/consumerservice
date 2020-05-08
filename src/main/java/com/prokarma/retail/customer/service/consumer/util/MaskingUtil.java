package com.prokarma.retail.customer.service.consumer.util;

import org.springframework.util.StringUtils;

public class MaskingUtil {

  public static String maskString(String strText, int start, int end, char maskChar)
      throws Exception {

    if (StringUtils.isEmpty(strText))
      return "";

    if (start < 0)
      start = 0;

    if (end > strText.length())
      end = strText.length();

    if (start > end)
      throw new Exception("Masking failed: End index cannot be greater than start index");

    int maskLength = end - start;

    if (maskLength == 0)
      return strText;

    StringBuilder sbMaskString = new StringBuilder(maskLength);

    for (int i = 0; i < maskLength; i++) {
      sbMaskString.append(maskChar);
    }

    return strText.substring(0, start) + sbMaskString.toString()
        + strText.substring(start + maskLength);
  }

  public static String maskEmailAddress(String customerEmail, char maskChar) throws Exception {

    if (StringUtils.isEmpty(customerEmail))
      return "";
    String[] parts = customerEmail.split("@");

    // mask first part
    String strId = "";
    if (parts[0].length() < 4)
      strId = maskString(parts[0], 0, parts[0].length(), maskChar);
    else
      strId = maskString(parts[0], 0, 4, maskChar);

    // now append the domain part to the masked id part
    return strId + "@" + parts[1];
  }

}
