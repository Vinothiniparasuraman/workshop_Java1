package com.provility.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopApplication extends CSVReaderInJava{
    public static void main(String args[]){

		SpringApplication.run(WorkshopApplication.class, args);
	}

}
