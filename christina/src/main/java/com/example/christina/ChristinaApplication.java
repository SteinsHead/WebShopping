package com.example.christina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChristinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChristinaApplication.class, args);
		for(int i = 0; i < 40; i++){
			System.out.print("\u265E");
			System.out.print(" ");
		}

	}

}
