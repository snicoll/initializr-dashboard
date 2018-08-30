package io.spring.sample.initializrdashboard.stats;

import io.spring.sample.initializrdashboard.DashboardProperties;
import io.spring.sample.initializrdashboard.stats.support.ReverseLookupDescriptor;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReverseLookupClient {

	private final RestTemplate client;

	public ReverseLookupClient(DashboardProperties properties, RestTemplateBuilder builder) {
		this.client = builder
				.setReadTimeout(properties.getReverseLookup().getTimeout() * 1000).build();
	}

	public ReverseLookupDescriptor freeReverseLookup(String ip) {
		return this.client.getForObject("http://localhost:8081/reverse-lookup/free/{ip}", ReverseLookupDescriptor.class, ip);
	}

	public ReverseLookupDescriptor payingReverseLookup(String ip) {
		return this.client.getForObject("http://localhost:8081/reverse-lookup/costly/{ip}", ReverseLookupDescriptor.class, ip);
	}
}
