package com.engsoft2.realstate;

import com.engsoft2.realstate.services.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealstateApplication.class, args);
	}

	@Autowired
	private DBService dbService;

	@PostConstruct
	private void init() {
		dbService.instantiateTestDatabase();
	}

}
