package edu.jsp_banking_app_entity;

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
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long a_id;
private long accountNo;
private double balance;
@ManyToOne
@JoinColumn
private User user;

}