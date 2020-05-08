package com.prokarma.retail.customer.service.consumer.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "audit_log")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "customerNumber")
  private String customerNumber;

  @Column(name = "customerJson")
  private String customerJson;

}
