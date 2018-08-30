package io.spring.sample.initializrdashboard;

import io.spring.sample.initializrdashboard.stats.ReverseLookupClient;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
class ReverseLookupHealthIndicator extends AbstractHealthIndicator {

	private final ReverseLookupClient client;

	public ReverseLookupHealthIndicator(ReverseLookupClient client) {
		this.client = client;
	}

	@Override
	protected void doHealthCheck(Health.Builder builder) {
		client.freeReverseLookup("10.10.10.10");
		builder.up();
	}

}
