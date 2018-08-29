package io.spring.sample.initializrdashboard;

import io.spring.sample.initializrdashboard.stats.ReverseLookupClient;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class ReverseLookupHealthIndicator implements HealthIndicator {

	private final ReverseLookupClient client;

	public ReverseLookupHealthIndicator(ReverseLookupClient client) {
		this.client = client;
	}

	@Override
	public Health health() {
		try {
			client.freeReverseLookup("10.10.10.10");
		}
		catch (Exception exc) {
			return Health.down(exc).build();

		}
		return Health.up().build();
	}
}
