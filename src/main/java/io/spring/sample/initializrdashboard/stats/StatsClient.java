package io.spring.sample.initializrdashboard.stats;

import java.util.List;

import io.spring.sample.initializrdashboard.stats.support.Event;
import io.spring.sample.initializrdashboard.stats.support.EventsDescriptor;
import io.spring.sample.initializrdashboard.stats.support.GenerationStatistics;
import io.spring.sample.initializrdashboard.stats.support.TopIpsDescriptor;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StatsClient {

	private final RestTemplate client;

	public StatsClient(RestTemplateBuilder builder) {
		this.client = builder.rootUri("http://localhost:8081").build();
	}

	public GenerationStatistics fetchGenerationStats(String fromDate, String toDate) {
		return this.client.getForObject("/statistics/{from}/{to}", GenerationStatistics.class, fromDate, toDate);
	}

	public List<Event> fetchEvents(String fromDate, String toDate) {
		return this.client.getForObject("/events/{from}/{to}", EventsDescriptor.class, fromDate, toDate)
				.getEvents();
	}

	public TopIpsDescriptor fetchIps(String fromDate, String toDate) {
		return this.client.getForObject("/top-ips/{from}/{to}", TopIpsDescriptor.class, fromDate, toDate);
	}

}
