package com.bt.micrometer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroMeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroMeterApplication.class, args);
	}
	
	
	@GetMapping(path="/greeting")
	public String greetingApi() {
		return "Hello Sample Application";
	}
}
