package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    Integer id;
    String name;
    Integer age;
    String email;
    String phone;
    String department;
    String salary;
    String designation;
    String manager;
}
