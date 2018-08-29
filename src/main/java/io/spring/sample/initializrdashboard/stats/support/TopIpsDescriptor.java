package io.spring.sample.initializrdashboard.stats.support;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopIpsDescriptor {

	private final List<String> ips;

	@JsonCreator
	TopIpsDescriptor(@JsonProperty("ips") List<String> ips) {
		this.ips = ips;
	}

	public List<String> getIps() {
		return this.ips;
	}

}
