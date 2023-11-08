package com.example.demo;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;


@SpringBootApplication
public class DemoApplication
{
	@Autowired
	static DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
