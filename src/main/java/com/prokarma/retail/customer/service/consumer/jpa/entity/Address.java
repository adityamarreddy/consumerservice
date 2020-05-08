package com.prokarma.retail.customer.service.consumer.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "address")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "addressLine1")
  private String addressLine1;

  @Column(name = "addressLine2")
  private String addressLine2;

  @Column(name = "street")
  private String street;

  @Column(name = "postalCode")
  private String postalCode;

  @OneToOne(mappedBy = "address")
  private Customer customer;

}
