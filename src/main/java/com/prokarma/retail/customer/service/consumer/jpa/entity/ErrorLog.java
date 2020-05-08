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
@Table(name = "error_log")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorLog {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column(name = "error_type")
  String errorType;

  @Column(name = "error_description")
  String errorDescription;

  @Column(name = "payload")
  String payload;
}
