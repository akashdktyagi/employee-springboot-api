package com.example.demoapi;

import com.example.demoapi.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}
}
