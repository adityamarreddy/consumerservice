package com.prokarma.retail.customer.service.consumer.jpa.entity;

import java.math.BigInteger;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

  @Id
  @Column(name = "customerNumber")
  private String customerNumber;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "birthDate")
  private Date birthDate;

  @Column(name = "country")
  private String country;

  @Column(name = "countryCode")
  private String countryCode;

  @Column(name = "mobileNumber")
  private BigInteger mobileNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "customerStatus")
  private String customerStatus;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "addressId", referencedColumnName = "id")
  private Address address;

  @Column(name = "customerJson")
  private String customerJson;

}
/*
 * 
 * public String getCustomerNumber() { return customerNumber; } public void setCustomerNumber(String
 * customerNumber) { this.customerNumber = customerNumber; } public String getFirstName() { return
 * firstName; } public void setFirstName(String firstName) { this.firstName = firstName; } public
 * String getLastName() { return lastName; } public void setLastName(String lastName) {
 * this.lastName = lastName; } public Date getBirthDate() {
 * 
 * return birthDate; } public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
 * public String getCountry() { return country; } public void setCountry(String country) {
 * this.country = country; } public String getCountryCode() { return countryCode; } public void
 * setCountryCode(String countryCode) { this.countryCode = countryCode; } public BigInteger
 * getMobileNumber() { return mobileNumber; } public void setMobileNumber(BigInteger mobileNumber) {
 * this.mobileNumber = mobileNumber; } public String getEmail() { return email; } public void
 * setEmail(String email) { this.email = email; } public String getCustomerStatus() { return
 * customerStatus; } public void setCustomerStatus(String customerStatus) { this.customerStatus =
 * customerStatus; } public Address getAddress() { return address; } public void setAddress(Address
 * address) { this.address = address; } public String getCustomerJson() { return customerJson; }
 * public void setCustomerJson(String customerJson) { this.customerJson = customerJson; }
 * 
 */
