package com.it.personaldashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.it.personaldashboard.services.InitDatabaseService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class PersonalDashboardApplication implements CommandLineRunner {

	@Autowired
	private InitDatabaseService initDatabaseService;


	public PersonalDashboardApplication(){
		//
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonalDashboardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("PersonalDashboardApplication > START > init-db");
		initDatabaseService.executeInit();
		log.info("PersonalDashboardApplication > END > init-db");

	}

}
