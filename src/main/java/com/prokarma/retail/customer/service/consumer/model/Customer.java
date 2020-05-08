package com.prokarma.retail.customer.service.consumer.model;

import java.math.BigInteger;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.threetenbp.deser.LocalDateDeserializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * Customer
 */
@Validated
@javax.annotation.Generated(
    value = "com.prokarma.retail.customer.service.producer.codegen.v3.generators.java.SpringCodegen",
    date = "2020-04-18T05:15:19.983Z[GMT]")
public class Customer {
  @JsonProperty("customerNumber")
  private String customerNumber = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  // @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonProperty("birthDate")
  private LocalDate birthDate = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("mobileNumber")
  private BigInteger mobileNumber = null;

  @JsonProperty("email")
  private String email = null;

  /**
   * valid customer statuses
   */
  public enum CustomerStatusEnum {
    O("Open"),

    C("Closed"),

    S("Suspended"),

    R("Restored");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CustomerStatusEnum fromValue(String text) {
      for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("customerStatus")
  private CustomerStatusEnum customerStatus = null;

  @JsonProperty("address")
  private Address address = null;

  public Customer customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

  /**
   * Get customerNumber
   * 
   * @return customerNumber
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Pattern(regexp = "[A-Z0-9]{1,10}")
  @Size(max = 10)
  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * 
   * @return firstName
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Size(min = 10, max = 50)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * 
   * @return lastName
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Size(max = 50)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Customer birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * 
   * @return birthDate
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Customer country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * 
   * @return country
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Customer countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * 
   * @return countryCode
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Size(min = 2, max = 2)
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Customer mobileNumber(BigInteger mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * 
   * @return mobileNumber
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public BigInteger getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(BigInteger mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * 
   * @return email
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Customer customerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
    return this;
  }

  /**
   * valid customer statuses
   * 
   * @return customerStatus
   **/
  @ApiModelProperty(required = true, value = "valid customer statuses")
  @NotNull

  public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
  }

  public Customer address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * 
   * @return address
   **/
  @ApiModelProperty(value = "")

  @Valid
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.customerNumber, customer.customerNumber)
        && Objects.equals(this.firstName, customer.firstName)
        && Objects.equals(this.lastName, customer.lastName)
        && Objects.equals(this.birthDate, customer.birthDate)
        && Objects.equals(this.country, customer.country)
        && Objects.equals(this.countryCode, customer.countryCode)
        && Objects.equals(this.mobileNumber, customer.mobileNumber)
        && Objects.equals(this.email, customer.email)
        && Objects.equals(this.customerStatus, customer.customerStatus)
        && Objects.equals(this.address, customer.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, firstName, lastName, birthDate, country, countryCode,
        mobileNumber, email, customerStatus, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");

    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
