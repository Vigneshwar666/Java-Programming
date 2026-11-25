package edu.jsp_banking_app_entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.jsp_banking_app_entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Loan {

  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private double amount;
  private LocalDateTime apply;
  private LocalDateTime approvalDate;
  private double balance;
  private String status;
  @ManyToOne
  @JoinColumn
  @JsonBackReference
  private User user;
  
}