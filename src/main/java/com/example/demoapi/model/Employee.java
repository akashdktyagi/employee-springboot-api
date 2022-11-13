package com.example.demoapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

//lombok
//TO remove the Boilerplate code like getters and setters and constructors and to String etc
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(setterPrefix = "with")
@Entity
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
}
