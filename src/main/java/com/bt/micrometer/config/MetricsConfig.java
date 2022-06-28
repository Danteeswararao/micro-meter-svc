package com.bt.micrometer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;

@Configuration
public class MetricsConfig {
	
	  @Value("${host}")
	  private String host;
	
	  @Value("${service}")
	  private String service;

	  @Value("${env}")
	  private String env;
	  
	  /*@Bean
	  public TimedAspect timedAspect(MeterRegistry mr) {
		  return new TimedAspect(mr);
	  }*/
	  
	  @Bean
	  MeterRegistryCustomizer<MeterRegistry> meterRegistryCustomizer() {
	    return registry -> registry.config()
	        .commonTags("host", host,
	            "service", service,
	            "env", env)
	        .meterFilter(MeterFilter.deny(id -> {
	          String uri = id.getTag("uri");
	          return uri != null && uri.startsWith("/actuator");
	        }))
	        .meterFilter(MeterFilter.deny(id -> {
	          String uri = id.getTag("uri");
	          return uri != null && uri.contains("favicon");
	        }));
	  }
}
