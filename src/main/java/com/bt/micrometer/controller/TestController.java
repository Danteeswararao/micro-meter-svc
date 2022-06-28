package com.bt.micrometer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
public class TestController {
	
	//@Autowired
	//MeterRegistry registry;
	
	@Timed(value = "get.counter.requests",description = "Metric details for the helloworld API", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "version",
	"v1" })
	@GetMapping(path="/hello")
	public String helloWorld() {
		
		//registry.counter("custom.metrics.message").increment();
		/*for(int i=0;i<100000;i++) {
			System.out.println("Do Nothing");
		}*/
		return "Hello World";
		
	}
}
